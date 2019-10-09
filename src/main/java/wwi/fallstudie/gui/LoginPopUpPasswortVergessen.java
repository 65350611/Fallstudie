package wwi.fallstudie.gui;

import javax.swing.*;
import java.awt.*;

public class LoginPopUpPasswortVergessen extends JFrame {

    private JTextArea textanzeige;
    private final String text = "Passwort vergessen?\n" + "Kein Problem!\n" + "Bitte wende dich an deinen Administrator um ein \nneues Passwort zu erhalten. \n" +
            "Keine Sorge, du kannst es danach jederzeit ändern";

    public LoginPopUpPasswortVergessen(){
        super("Passwort vergessen?");

        setLayout(new BorderLayout()); //set Layout Manager

        textanzeige = new JTextArea(text);
        textanzeige.setFont(textanzeige.getFont().deriveFont(15f)); //ändert die Textgröße
        textanzeige.setEditable(false);

        //Komponenten zur ContentPane hinzufügen
        add(textanzeige, BorderLayout.CENTER);


        //JLabel einrichten
        setSize(380, 130);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
    }
}
