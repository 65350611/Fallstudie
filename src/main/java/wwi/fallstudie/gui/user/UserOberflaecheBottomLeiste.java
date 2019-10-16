package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;

public class UserOberflaecheBottomLeiste extends JPanel {

    private JButton passwortAendern;
    private JButton userNamenAendern;

    private JButton ausgabenAnzeigen;
    private JButton kategorienAnzeigen;
    private JButton insights;

    public UserOberflaecheBottomLeiste(){
        setLayout(new FlowLayout());

        passwortAendern = new JButton("Ausgabe ändern");
        userNamenAendern = new JButton("Ausgabe löschen");

        ausgabenAnzeigen = new JButton("Ausgaben anzeigen");
        kategorienAnzeigen = new JButton("Kategorien anzeigen");
        insights = new JButton("Insights");

        add(passwortAendern);
        add(userNamenAendern);

        add(ausgabenAnzeigen);
        add(kategorienAnzeigen);
        add(insights);
    }
}
