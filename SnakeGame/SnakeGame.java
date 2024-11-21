
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;
class GamePanel extends JPanel implements ActionListener
{
    static final int SCREEN_WIDTH=600;
    static final int SCREEN_HEIGHT=600;
    static final int UNIT_SIZE=25;
    static final int GAME_UNITS=(SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE;
    static final int DELAY=75;
    final int x[]=new int[GAME_UNITS];
    final int y[]=new int[GAME_UNITS];
    int bodyParts=5;
    int appleEaten;
    int appleX;
    int appleY;
    char direction='R';
    boolean running = false;
    Random random;
    Timer timer;


    GamePanel()
    {
        random= new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame()
    {
        newApple();
        running =true;
        timer= new Timer(DELAY,this);
        timer.start();

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g)
    {
        if(running)
        {
            g.setColor(Color.red);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

        for(int i=0;i<bodyParts;i++)
        {
            if(i==0)
            {
                g.setColor(Color.green);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            else
            {
                g.setColor(new Color(45,180,0));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,30));
        FontMetrics metrics= getFontMetrics(g.getFont());
        g.drawString("Score: " + appleEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + appleEaten)) / 2, SCREEN_HEIGHT / 2 + 50);
    }
        else
        {
            gameOver(g);
        }
    }
    public void newApple()
    {
        appleX=random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY=random.nextInt((int)SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

    }
    public void move()
    {
        for(int i=bodyParts;i>0;i--)
        {
            x[i]=x[i-1];
            y[i]=y[i-1];

        }
        switch (direction) 
        {
            case 'U':
                y[0]=y[0]-UNIT_SIZE;
            break;
            case 'D':
                y[0]=y[0]+UNIT_SIZE;
            break;
            case 'R':
                x[0]=x[0]+UNIT_SIZE;
            break;
            case 'L':
                x[0]=x[0]-UNIT_SIZE;
            break;  
        }
    }
    public void checkApples()
    {
        if((x[0]==appleX) && (y[0]==appleY))
        {
            bodyParts++;
            appleEaten++;
            newApple();
        }
    }
    public void checkCollisions()
    {
        for(int i=bodyParts;i>0;i--)
        {
            if((x[0] == x[i]) && (y[0] == y[i]))

            {
                running=false;
            }
        }
        if(x[0]<0)
        {
            running=false;
        }
        if(x[0]>SCREEN_WIDTH)
        {
            running=false;
        }
        if(y[0]<0)
        {
            running=false;
        }
        if(y[0]>SCREEN_HEIGHT)
        {
            running=false;
        }
        if(!running)
        {
            timer.stop();
        }
    }
    public void gameOver(Graphics g)
    {
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics1= getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH-metrics1.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);

        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,30));
        FontMetrics metrics2= getFontMetrics(g.getFont());
        g.drawString("Score: "+appleEaten, (SCREEN_WIDTH-metrics2.stringWidth("Score; "+appleEaten))/2,g.getFont().getSize());
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(running)
        {
            move();
            checkApples();
            checkCollisions();

        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode()) 
            {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') 
                    {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') 
                    {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') 
                    {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') 
                    {
                        direction = 'D';
                    }
                    break;
            }
            
        }
    }
}

 class GameFrame extends JFrame 
 {
    GameFrame()
    {
        GamePanel panel = new GamePanel();
        this.add(panel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

 }

class SnakeGame 
{
    public static void main(String arg[])
    {
        new GameFrame();

    }
}