
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DemoGUI 
{
    public static void main(String arg[])
    {
        ABC abc = new ABC();
        
    }
    
}    
    class ABC extends JFrame implements ActionListener
    {
        JLabel l1;
        
        JTextField t1;
        JTextField t2;
        JButton b1;
        JButton b2;
        JButton b3;
        JButton b4;
        public ABC()
        {
            setLayout(new FlowLayout());
            setSize(400,400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            l1= new JLabel("Result");
            t1= new JTextField(10);
            t2= new JTextField(10);
            b1=new JButton("Add");
            b2=new JButton("sub");
            b3=new JButton("mult");
            b4=new JButton("div");
            
            add(l1);
            add(t1);
            add(t2);
            add(b1);
            add(b2);
            add(b3);
            add(b4);
            b1.addActionListener( this);
            b2.addActionListener( this);
            b3.addActionListener( this);
            b4.addActionListener( this);
        }
            @Override
        public void actionPerformed(ActionEvent e)
            {
                int n1=Integer.parseInt(t1.getText());
                int n2=Integer.parseInt(t2.getText());
                int val=0;
                if(e.getSource()==b1)
                {
                    val = n1+n2;
                }
                else if(e.getSource()==b2)
                {
                    val = n1-n2;
                }
                else if(e.getSource()==b3)
                {
                    val = n1*n2;
                }
                else if(e.getSource()==b4)
                {
                    if(n2!=0)
                    {
                         val = n1/n2;
                    }
                    else
                    {
                    l1.setText("Error: Division by zero");
                    return;
                    }
                }
                
                l1.setText(val+" ");
            }
        
    }









    