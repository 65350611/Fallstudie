package wwi.fallstudie.gui.user;

import wwi.fallstudie.gui.popupAllgemein.MessagePopup;
import wwi.fallstudie.gui.utilities.Window;

import javax.swing.*;

import backend.Logik;

import java.awt.*;
import java.awt.event.*;

public class UserPopUpAusgabeBearbeiten extends JFrame{
    private String momentaneKategorie;

    private JTextField ausgabenID;
    private JTextField kategorie;
    private JTextField datum;
    private JLabel betragLabel;
    private JTextField betragField;
    private JLabel euroLabel;
    private JTextField bezeichnung;
    private JButton aendern;
    private JButton abbrechen;

    public UserPopUpAusgabeBearbeiten(AusgabenAnzeigenPanel ausgabenAnzeigenPanel, KategorienAnzeigenPanel kategorienAnzeigenPanel){
        super("Ausgabe bearbeiten");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise attributes
        ausgabenID = new JTextField("Ausgaben ID");
        kategorie = new JTextField("Kategorie");
        datum = new JTextField("YYYY-MM-DD");
        betragLabel = new JLabel("Betrag:");
        betragField = new JTextField(10);
        euroLabel = new JLabel("Euro");
        bezeichnung = new JTextField("Titel der Ausgabe");
        aendern = new JButton("Ändern");
        abbrechen = new JButton("Abbrechen");

        //edit ausgabenID
        ausgabenID.setForeground(Color.LIGHT_GRAY);
        ausgabenID.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //edit kategorie
        kategorie.setForeground(Color.LIGHT_GRAY);
        kategorie.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //edit datum
        datum.setForeground(Color.LIGHT_GRAY);
        datum.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //edit bezeichnung
        bezeichnung.setForeground(Color.LIGHT_GRAY);
        bezeichnung.addFocusListener(new FocusAdapter() {
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
                    if(Logik.pruefeDatum(datum.getText())) {
                        if(kategorie.getText().equals("")) {
                            kategorie.setText("Sonstiges");
                        }
                        int ausID = Integer.parseInt(ausgabenID.getText());
                        Logik.ausgabeAendern(ausID, kategorie.getText(), datum.getText(), betragField.getText(), bezeichnung.getText());
                        System.out.println(ausID + " " + kategorie.getText() + " " + datum.getText() + " " + betragField.getText() + " " + bezeichnung.getText());

                        ausgabenAnzeigenPanel.update();
                        kategorienAnzeigenPanel.update();
                        dispose(); //popup schließen
                    } else {
                        new MessagePopup("Daten müssen im Format \"YYYY-MM-DD\" eingegeben werden!");
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    new MessagePopup();
                }
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

        //ausgabenID
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 3;
        add(ausgabenID, gc);

        ////////////////////// reihe 2 ///////////////////////

        //kategorie
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 3;
        add(kategorie, gc);

        ////////////////////// reihe 3 ///////////////////////

        //datum
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth = 3;
        add(datum, gc);

        ////////////////////// reihe 4 ///////////////////////
        gc.ipady = 0;
        gc.gridwidth = 1;

        //betragLabel
        gc.gridx = 0;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.NONE;
        add(betragLabel, gc);

        //betragField
        gc.gridx = 1;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(betragField, gc);

        //euroLabel
        gc.gridx = 2;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(euroLabel, gc);

        ////////////////////// reihe 5 ///////////////////////
        gc.fill = GridBagConstraints.HORIZONTAL;

        //bezeichnung
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.gridwidth = 3;
        add(bezeichnung, gc);

        ////////////////////// reihe 6 ///////////////////////
        gc.ipady = 0;

        //hinzufuegen
        gc.gridx = 0;
        gc.gridy = 5;
        gc.gridwidth = 2;
        add(aendern, gc);

        //abbrechen
        gc.gridx = 2;
        gc.gridy = 5;
        gc.gridwidth = 1;
        add(abbrechen, gc);


        //set JFrame
        setSize(320, 280);
        Window.centerFrame(this);
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
