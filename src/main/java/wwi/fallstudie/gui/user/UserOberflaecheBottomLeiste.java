package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserOberflaecheBottomLeiste extends JPanel {

    private JButton passwortAendern;
    private JButton ausgabeLoeschen;

    private JButton ausgabenAnzeigen;
    private JButton kategorienAnzeigen;
    private JButton insights;

    public UserOberflaecheBottomLeiste(JLayeredPane anzeigePanel, AusgabenAnzeigenPanel ausgabenAnzeigenPanel, KategorienAnzeigenPanel kategorienAnzeigenPanel, InsightsPanel insightsPanel){
        setLayout(new FlowLayout());

        passwortAendern = new JButton("Ausgabe bearbeiten");
        passwortAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserPopUpAusgabeBearbeiten();
            }
        });

        ausgabeLoeschen = new JButton("Ausgabe löschen");
        ausgabeLoeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserPopUpAusgabeLoeschen();
            }
        });

        ausgabenAnzeigen = new JButton("Ausgaben anzeigen");
        ausgabenAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO change to ausgabenAnzeigenPanel
                anzeigePanel.removeAll();
                anzeigePanel.add(ausgabenAnzeigenPanel);
                anzeigePanel.repaint();
                anzeigePanel.revalidate();
            }
        });

        kategorienAnzeigen = new JButton("Kategorien anzeigen");
        kategorienAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO change to KategorienAnzeigenPanel
                anzeigePanel.removeAll();
                anzeigePanel.add(kategorienAnzeigenPanel);
                anzeigePanel.repaint();
                anzeigePanel.revalidate();
            }
        });

        insights = new JButton("Insights");
        insights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO change to InsightsAnzeigenPanel
                anzeigePanel.removeAll();
                anzeigePanel.add(insightsPanel);
                anzeigePanel.repaint();
                anzeigePanel.revalidate();

            }
        });

        add(passwortAendern);
        add(ausgabeLoeschen);

        add(ausgabenAnzeigen);
        add(kategorienAnzeigen);
        add(insights);
    }
}
