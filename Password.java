/*
 * Araohat Kokate 1001829841
 */
package code6_1001829841;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class Password extends JFrame
{

    private final JPasswordField passwordField;
    String user_password = "";
    final String actualpassword = "2003";

    public Password()
    {
        super("Enter Password");
        setLayout(new FlowLayout());
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('X');
        add(passwordField);
        EventHandler handler = new EventHandler();
        passwordField.addActionListener(handler);
    }

    private class EventHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == passwordField)
            {
                user_password = event.getActionCommand();
            }

            if (user_password.equals(actualpassword))
            {
                setVisible(false);
                GameFrame gameframe = new GameFrame();
                gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameframe.setSize(460, 400);//460,380
                gameframe.setVisible(true);
            }

            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect password");
            }
        }

    }
}