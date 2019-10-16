package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;

public class UserKopfleistenNamenInfoPanel extends JPanel {
    private JLabel userLabel;
    private JButton passwortAendern;

    public UserKopfleistenNamenInfoPanel(){

        setLayout(new FlowLayout());

        userLabel = new JLabel("Nutzer");
        passwortAendern = new JButton("Passwort ändern");

        add(userLabel);
        add(passwortAendern);
    }
}
