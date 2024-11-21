import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator 
{
    JFrame frame;
    JTextField textField;

    double n1, n2, result;
    char operation;

    Calculator() 
    {
        frame = new JFrame("Calculator");
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        frame.add(panel, BorderLayout.CENTER);

        String[] buttons = {"7", "8", "9", "/",
                            "4", "5", "6", "*",
                            "1", "2", "3", "-",
                            "0", ".", "=", "+"};

        for (String button : buttons) {
            JButton jButton = new JButton(button);
            jButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    switch (command) {
                        case "0": case "1": case "2": case "3": case "4":
                        case "5": case "6": case "7": case "8": case "9":
                            textField.setText(textField.getText() + command);
                            break;
                        case "+": case "-": case "*": case "/":
                            n1 = Double.parseDouble(textField.getText());
                            operation = command.charAt(0);
                            textField.setText("");
                            break;
                        case "=":
                            n2 = Double.parseDouble(textField.getText());
                            switch (operation) {
                                case '+':
                                    result = n1 + n2;
                                    break;
                                case '-':
                                    result = n1 - n2;
                                    break;
                                case '*':
                                    result = n1 * n2;
                                    break;
                                case '/':
                                    result = n1 / n2;
                                    break;
                            }
                            textField.setText(String.valueOf(result));
                            break;
                    }
                }
            });
            panel.add(jButton);
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
}



