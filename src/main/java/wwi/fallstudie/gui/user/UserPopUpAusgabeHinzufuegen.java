package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UserPopUpAusgabeHinzufuegen extends JFrame {

    private String momentaneKategorie;

    private JComboBox kategorie;
    private JTextField datum;
    private JLabel betragLabel;
    private JTextField betragField;
    private JLabel euroLabel;
    private JTextField bezeichnung;
    private JButton hinzufuegen;
    private JButton abbrechen;

    public UserPopUpAusgabeHinzufuegen(){
        super("Ausgabe Hinzufügen");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise attributes
        kategorie = new JComboBox();
        datum = new JTextField("date");
        betragLabel = new JLabel("Betrag:");
        betragField = new JTextField(10);
        euroLabel = new JLabel("Euro");
        bezeichnung = new JTextField("bezeichnung");
        hinzufuegen = new JButton("Hinzufügen");
        abbrechen = new JButton("Abbrechen");

        //edit kategorie
        //TODO methode aufrufen die Kategorien als String[] zurückgibt => kategorie.addItem();
        kategorie.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(!momentaneKategorie.equals(kategorie.getSelectedItem())){
                    setMomentaneKategorie((String) kategorie.getSelectedItem()); //setze einen neue Kategorie
                }
            }
        });

        //edit datum

        //edit betragField

        //edit bezeichnung

        //set buttons on clicklistener
        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO füge neuen nutzer hinzu
                //dispose(); // popup schließen
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
        gc.ipady = 20;

        //kategorie
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 3;
        add(kategorie, gc);

        ////////////////////// reihe 2 ///////////////////////

        //datum
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 3;
        add(datum, gc);

        ////////////////////// reihe 3 ///////////////////////
        gc.ipady = 0;
        gc.gridwidth = 1;

        //betragLabel
        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        add(betragLabel, gc);

        //betragField
        gc.gridx = 1;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(betragField, gc);

        //euroLabel
        gc.gridx = 2;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(euroLabel, gc);

        ////////////////////// reihe 4 ///////////////////////
        gc.fill = GridBagConstraints.HORIZONTAL;

        //bezeichnung
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridwidth = 3;
        add(bezeichnung, gc);

        ////////////////////// reihe 2 ///////////////////////
        gc.ipady = 0;

        //hinzufuegen
        gc.gridx = 0;
        gc.gridy = 4;
        gc.gridwidth = 2;
        add(hinzufuegen, gc);

        //abbrechen
        gc.gridx = 2;
        gc.gridy = 4;
        gc.gridwidth = 1;
        add(abbrechen, gc);



        //set JFrame
        setSize(320, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public String getMomentaneKategorie() {
        return momentaneKategorie;
    }

    public void setMomentaneKategorie(String momentaneKategorie) {
        this.momentaneKategorie = momentaneKategorie;
    }
}
