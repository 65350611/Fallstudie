package wwi.fallstudie.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    private JPanel panelMain;

    public LoginScreen() {
        //ActionListener anmeldeButton
        anmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("angemeldet");
            }
        });
        //ActionListener passwortVergessenButton
        passwortVergessenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("vergessen");
            }
        });
    }

    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton anmeldenButton;
    private JButton passwortVergessenButton;

    /**
     * Create the JFrame for the Login Screen
     * Set Buttons on Action Listener
     */
    public static void main(String[] args){
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new LoginScreen().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        System.out.println("erfolgreich");

    }

}
