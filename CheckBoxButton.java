
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CheckBoxButton 
{
    public static void main(String[] args) {
        CheckBox b =new CheckBox();
    }
}
class CheckBox extends JFrame
{
        JLabel l1;
        JTextField t1;
        JCheckBox b1,b2;
        JButton b;
        public CheckBox()
        {
            l1=new JLabel("Greetings");
            t1=new JTextField(20);
            b=new JButton("Proceed");
            b1=new JCheckBox("Dance");
            b2=new JCheckBox("Music");
            
            add(t1);
            add(b);
            add(b1);
            add(b2);
            add(l1);
            setLayout(new FlowLayout());
            setSize(400,400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}
