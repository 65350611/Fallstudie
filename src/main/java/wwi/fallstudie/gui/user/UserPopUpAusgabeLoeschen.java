package wwi.fallstudie.gui.user;

import wwi.fallstudie.gui.popupAllgemein.MessagePopup;
import wwi.fallstudie.gui.utilities.Window;

import javax.swing.*;

import backend.Logik;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UserPopUpAusgabeLoeschen extends JFrame {
    private JTextField ausgabenID;
    private JButton loeschen;
    private JButton abbrechen;

    public UserPopUpAusgabeLoeschen(AusgabenAnzeigenPanel ausgabenAnzeigenPanel, KategorienAnzeigenPanel kategorienAnzeigenPanel){
        super("Ausgabe löschen");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise variables
        ausgabenID = new JTextField();
        loeschen = new JButton("Löschen");
        abbrechen = new JButton("Abbrechen");


        //edit usernameField
        ausgabenID.setForeground(Color.LIGHT_GRAY);
        ausgabenID.setText("Ausgaben ID");
        ausgabenID.addFocusListener(new FocusAdapter() {
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
            	try {
            		int ausID = Integer.parseInt(ausgabenID.getText());
            		Logik.deleteAusgaben(ausID);
      
                ausgabenAnzeigenPanel.update();
                kategorienAnzeigenPanel.update();
                dispose(); //popup schließen
            } catch (Exception e){
                    e.printStackTrace();
                    new MessagePopup();
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
        add(ausgabenID, gc);

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
        Window.centerFrame(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
