package wwi.fallstudie.gui.user;

import wwi.fallstudie.gui.popupAllgemein.MessagePopup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UserPopUpKategorieLoeschen extends JFrame {
    private JTextField kategorie;
    private JButton loeschen;
    private JButton abbrechen;

    public UserPopUpKategorieLoeschen(KategorienAnzeigenPanel kategorienAnzeigenPanel){
        super("Kategorie löschen");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise variables
        kategorie = new JTextField();
        loeschen = new JButton("Löschen");
        abbrechen = new JButton("Abbrechen");


        //edit usernameField
        kategorie.setForeground(Color.LIGHT_GRAY);
        kategorie.setText("Kategorie");
        kategorie.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //set buttons on clicklistener
        loeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try{
                    //TODO lösche alte kategorie
                    kategorienAnzeigenPanel.update();
                } catch (Exception e){
                    new MessagePopup("Fehler beim Löschen. Bitte erneut versuchen");
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

        //kategorie
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(kategorie, gc);

        ////////////////////// reihe 2 ///////////////////////

        gc.gridwidth = 1;
        gc.ipady = 0;

        //hinzufuegen
        gc.gridx = 0;
        gc.gridy = 1;
        add(loeschen, gc);

        //abbrechen
        gc.gridx = 1;
        gc.gridy = 1;
        add(abbrechen, gc);

        //set JFrame data
        setSize(320, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
