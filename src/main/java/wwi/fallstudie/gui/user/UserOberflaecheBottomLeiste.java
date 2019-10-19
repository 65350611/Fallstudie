package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserOberflaecheBottomLeiste extends JPanel {

    private JButton ausgabeBearbeiten;
    private JButton ausgabeLoeschen;

    private JButton kategorieBearbeiten;
    private JButton kategorieLoeschen;

    private JButton ausgabenAnzeigen;
    private JButton kategorienAnzeigen;
    private JButton insights;

    public UserOberflaecheBottomLeiste(JLayeredPane anzeigePanel, AusgabenAnzeigenPanel ausgabenAnzeigenPanel, KategorienAnzeigenPanel kategorienAnzeigenPanel, InsightsPanel insightsPanel){
        setLayout(new FlowLayout());

        ausgabeBearbeiten = new JButton("Ausgabe bearbeiten");
        ausgabeBearbeiten.addActionListener(new ActionListener() {
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

        kategorieBearbeiten = new JButton("Kategorie bearbeiten");
        kategorieBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserPopUpKategorieBearbeiten();
            }
        });

        kategorieLoeschen = new JButton("Kategorie löschen");
        kategorieLoeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserPopUpKategorieLoeschen();
            }
        });

        ausgabenAnzeigen = new JButton("Ausgaben anzeigen");
        ausgabenAnzeigen.setForeground(Color.BLUE);
        ausgabenAnzeigen.setOpaque(true);
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
        kategorienAnzeigen.setForeground(Color.BLUE);
        kategorienAnzeigen.setOpaque(true);
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
        insights.setForeground(Color.BLUE);
        insights.setOpaque(true);
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

        add(ausgabeBearbeiten);
        add(ausgabeLoeschen);

        add(kategorieBearbeiten);
        add(kategorieLoeschen);

        add(ausgabenAnzeigen);
        add(kategorienAnzeigen);
        add(insights);
    }
}
