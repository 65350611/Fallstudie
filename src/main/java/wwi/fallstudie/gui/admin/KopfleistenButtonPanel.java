package wwi.fallstudie.gui.admin;

import wwi.fallstudie.gui.login.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KopfleistenButtonPanel extends JPanel {

    private JButton hinzufuegen;
    private JButton abmelden;

    public KopfleistenButtonPanel(AdminOberflaeche adminOberflaeche){
        setLayout(new FlowLayout());

        hinzufuegen = new JButton("Nutzer hinzufügen");
        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AdminOberflaechePopUpUserHinzufuegen(adminOberflaeche);
            }
        });

        abmelden = new JButton("Abmelden");
        abmelden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                adminOberflaeche.dispose();
                new Login();
            }
        });

        add(hinzufuegen);
        add(abmelden);
    }

}
