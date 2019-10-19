package wwi.fallstudie.gui.user;

import wwi.fallstudie.gui.login.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserKopfLeistenButtonPanel extends JPanel {
    private JButton kategorieHinzufuegen;
    private JButton ausgabeHinzufuegen;
    private JButton abmelden;

    public UserKopfLeistenButtonPanel(UserOberflaeche userOberflaeche){
        setLayout(new FlowLayout());

        ausgabeHinzufuegen = new JButton("Ausgabe hinzufügen");
        ausgabeHinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserPopUpAusgabeHinzufuegen();
            }
        });

        kategorieHinzufuegen = new JButton("Kategorie hinzufügen");
        kategorieHinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO neue Kategorie hinzufügen
                new UserPopUpKategorieHinzufuegen(userOberflaeche);
            }
        });

        abmelden = new JButton("Abmelden");
        abmelden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                userOberflaeche.dispose();
                new Login();
            }
        });

        add(ausgabeHinzufuegen);
        add(kategorieHinzufuegen);
        add(abmelden);
    }
}
