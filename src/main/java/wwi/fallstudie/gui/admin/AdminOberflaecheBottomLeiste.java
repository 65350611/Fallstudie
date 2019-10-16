package wwi.fallstudie.gui.admin;

import javax.swing.*;
import java.awt.*;

public class AdminOberflaecheBottomLeiste extends JPanel {

    private JButton passwortAendern;
    private JButton userNamenAendern;

    public AdminOberflaecheBottomLeiste(){
        setLayout(new FlowLayout());

        passwortAendern = new JButton("Passwort ändern");
        userNamenAendern = new JButton(("Nutzernamen ändern"));

        add(passwortAendern);
        add(userNamenAendern);
    }
}
