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
                new UserPopUpAusgabeBearbeiten(ausgabenAnzeigenPanel, kategorienAnzeigenPanel);
            }
        });

        ausgabeLoeschen = new JButton("Ausgabe löschen");
        ausgabeLoeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserPopUpAusgabeLoeschen(ausgabenAnzeigenPanel, kategorienAnzeigenPanel);
            }
        });

        kategorieBearbeiten = new JButton("Kategorie bearbeiten");
        kategorieBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserPopUpKategorieBearbeiten(kategorienAnzeigenPanel, ausgabenAnzeigenPanel);
            }
        });

        kategorieLoeschen = new JButton("Kategorie löschen");
        kategorieLoeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserPopUpKategorieLoeschen(ausgabenAnzeigenPanel, kategorienAnzeigenPanel);
            }
        });

        ausgabenAnzeigen = new JButton("Ausgaben anzeigen");
        ausgabenAnzeigen.setForeground(Color.GRAY);
        ausgabenAnzeigen.setOpaque(true);
        ausgabenAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ausgabenAnzeigen.setForeground(Color.GRAY);
                kategorienAnzeigen.setForeground(Color.BLUE);
                insights.setForeground(Color.BLUE);

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
                ausgabenAnzeigen.setForeground(Color.BLUE);
                kategorienAnzeigen.setForeground(Color.GRAY);
                insights.setForeground(Color.BLUE);

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
                ausgabenAnzeigen.setForeground(Color.BLUE);
                kategorienAnzeigen.setForeground(Color.BLUE);
                insights.setForeground(Color.GRAY);

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
