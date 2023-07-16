/*
 * Araohat Kokate 1001829841
 */
package code6_1001829841;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GameFrame extends JFrame
{

    private final JLabel label1;
    private final JButton OKButton;
    private final JButton CancelButton;
    private final JTextField textField1;
    String storename = " ";
    String showresponse = " ";

    public GameFrame()
    {
        super("Welcome to my guessing game");
        setLayout(new FlowLayout());
        Random rn = new Random();
        int a = rn.nextInt(4) + 1;
        switch (a)
        {
            case 1:
                storename = "Fred";
                break;
            case 2:
                storename = "Velma";
                break;
            case 3:
                storename = "Shaggy";
                break;
            case 4:
                storename = "Daphne";
                break;

            default:
                System.out.println("An error occured...");
        }
        Icon CC = new ImageIcon(getClass().getResource(storename + ".png"));

        label1 = new JLabel();
        label1.setText("Guess who the Scooby Doo character is?");
        label1.setIcon(CC);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setVerticalTextPosition(SwingConstants.BOTTOM);
        label1.setToolTipText("They are famous! You got this!");
        add(label1);

        EventHandler handler = new EventHandler();

        textField1 = new JTextField("Type your answer here");
        textField1.addActionListener(handler);
        textField1.selectAll();
        add(textField1);
        OKButton = new JButton("OK");
        OKButton.addActionListener(handler);
        add(OKButton);
        CancelButton = new JButton("Cancel");
        CancelButton.addActionListener(handler);
        add(CancelButton);

    }

    private class EventHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            String string = textField1.getText();
            boolean check = false;
            /*if (event.getSource() == textField1)
            {
                string = event.getActionCommand();
            }*/

            if (storename.equalsIgnoreCase(string))
            {
                string = "Correct!";
                check = true;
            }

            else
            {
                string = "Incorrect! Guess again";
            }

            if (event.getSource() == OKButton || event.getSource() == textField1)
            {
                JOptionPane.showMessageDialog(null, string);
                if (check == true)
                {
                    System.exit(0);
                }
            }

            else if (event.getSource() == CancelButton)
            {
                System.exit(0);
            }
        }
    }

}