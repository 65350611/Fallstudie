package wwi.fallstudie.gui.admin;

import javax.swing.*;
import java.awt.*;

public class KopfleistenButtonPanel extends JPanel {

    private JButton hinzufuegen;
    private JButton abmelden;

    public KopfleistenButtonPanel(){
        setLayout(new FlowLayout());

        hinzufuegen = new JButton("Nutzer hinzufügen");
        abmelden = new JButton("Abmelden");

        add(hinzufuegen);
        add(abmelden);
    }

}
