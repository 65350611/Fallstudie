package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserOberflaecheBottomLeiste extends JPanel {

    private JButton passwortAendern;
    private JButton userNamenAendern;

    private JButton ausgabenAnzeigen;
    private JButton kategorienAnzeigen;
    private JButton insights;

    public UserOberflaecheBottomLeiste(){
        setLayout(new FlowLayout());

        passwortAendern = new JButton("Ausgabe bearbeiten");
        passwortAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserPopUpAusgabeBearbeiten();
            }
        });

        userNamenAendern = new JButton("Ausgabe löschen");

        ausgabenAnzeigen = new JButton("Ausgaben anzeigen");
        ausgabenAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO change to ausgabenAnzeigenPanel
            }
        });

        kategorienAnzeigen = new JButton("Kategorien anzeigen");
        kategorienAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO change to KategorienAnzeigenPanel
            }
        });

        insights = new JButton("Insights");
        insights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO change to InsightsAnzeigenPanel
            }
        });

        add(passwortAendern);
        add(userNamenAendern);

        add(ausgabenAnzeigen);
        add(kategorienAnzeigen);
        add(insights);
    }
}
