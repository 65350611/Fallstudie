package wwi.fallstudie.gui.user;

import wwi.fallstudie.gui.popupAllgemein.MessagePopup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UserPopUpKategorieBearbeiten extends JFrame{
    private JTextField alteKategorie;
    private JTextField neueKategorie;
    private JButton aendern;
    private JButton abbrechen;

    public UserPopUpKategorieBearbeiten(KategorienAnzeigenPanel kategorienAnzeigenPanel){
        super("Kategorie bearbeiten");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise variables
        alteKategorie = new JTextField();
        neueKategorie = new JTextField();
        aendern = new JButton("Ändern");
        abbrechen = new JButton("Abbrechen");


        //edit alteKategorie
        alteKategorie.setForeground(Color.LIGHT_GRAY);
        alteKategorie.setText("Alter Name");
        alteKategorie.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //edit neueKategorie
        neueKategorie.setForeground(Color.LIGHT_GRAY);
        neueKategorie.setText("Neuer Name");
        neueKategorie.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //set buttons on clicklistener
        aendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try{
                    //TODO lösche alte kategorie
                    kategorienAnzeigenPanel.update();
                } catch (Exception e){
                    new MessagePopup("Fehler beim Ändern. Bitte erneut versuchen");
                }
                dispose(); // popup schließen
            }
        });

        abbrechen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

         /*
        setting variables to Layout
         */
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;

        ////////////////////// reihe 1 ///////////////////////

        //alte kategorie
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(alteKategorie, gc);

        ////////////////////// reihe 2 ///////////////////////

        //neue kategorie
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 2;
        add(neueKategorie, gc);

        ////////////////////// reihe 3 ///////////////////////

        gc.gridwidth = 1;
        gc.ipady = 0;

        //hinzufuegen
        gc.gridx = 0;
        gc.gridy = 2;
        add(aendern, gc);

        //abbrechen
        gc.gridx = 1;
        gc.gridy = 2;
        add(abbrechen, gc);

        //set JFrame data
        setSize(320, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
