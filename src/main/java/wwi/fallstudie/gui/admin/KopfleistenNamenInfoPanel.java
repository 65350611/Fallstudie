package wwi.fallstudie.gui.admin;

import javax.swing.*;
import java.awt.*;

public class KopfleistenNamenInfoPanel extends JPanel {

    private JLabel adminLabel;
    private JButton passwortAendern;

    public KopfleistenNamenInfoPanel(){

        setLayout(new FlowLayout());

        adminLabel = new JLabel("Admin");
        passwortAendern = new JButton("Passwort aendern");

        add(adminLabel);
        add(passwortAendern);
    }
}
