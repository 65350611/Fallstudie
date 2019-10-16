package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;

public class UserKopfLeistenButtonPanel extends JPanel {
    private JButton kategorieHinzufuegen;
    private JButton ausgabeHinzufuegen;
    private JButton abmelden;

    public UserKopfLeistenButtonPanel(){
        setLayout(new FlowLayout());

        ausgabeHinzufuegen = new JButton("Ausgabe hinzufügen");
        kategorieHinzufuegen = new JButton("Kategorie hinzufügen");
        abmelden = new JButton("Abmelden");

        add(ausgabeHinzufuegen);
        add(kategorieHinzufuegen);
        add(abmelden);
    }
}
