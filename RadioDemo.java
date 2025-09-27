
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RadioDemo 
{
    public static void main(String[] args) {
        RadioButtonDemo r =new RadioButtonDemo();
    }
    
}
class RadioButtonDemo extends JFrame
{
        JLabel l1;
        JTextField t1;
        JRadioButton b1,b2;
        JButton b;
        public RadioButtonDemo()
        {
            l1=new JLabel("Greetings");
            t1=new JTextField(20);
            b=new JButton("Proceed");
            b1=new JRadioButton("Male");
            b2=new JRadioButton("Female");
            ButtonGroup bg=new ButtonGroup();
            bg.add(b1);
            bg.add(b2);
            add(t1);
            add(b);
            add(b1);
            add(b2);
            add(l1);
            b.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    String name = t1.getText();
                    if(b1.isSelected())
                    {
                        name ="Mrs." + name;
                    }
                    else
                    {
                        name ="Ms." + name;
                    }
                    l1.setText(name);
                }
            });
            setLayout(new FlowLayout());
            setSize(400,400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}
