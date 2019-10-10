package wwi.fallstudie.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AdminOberflaechePopUpUserHinzufuegen extends JFrame {

    private JTextField usernameField;
    private JButton hinzufuegen;
    private JButton abbrechen;

    public AdminOberflaechePopUpUserHinzufuegen(){
        super("Nutzer hinzufügen");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise variables
        usernameField = new JTextField();
        hinzufuegen = new JButton("Hinzufügen");
        abbrechen = new JButton("Abbrechen");


        //edit usernameField
        usernameField.setForeground(Color.LIGHT_GRAY);
        usernameField.setText("Nutzername:");
        usernameField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //set buttons on clicklistener
        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO füge neuen nutzer hinzu
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

        ////////////////////// reihe 1 ///////////////////////

        //usernameField
        gc.gridx = 0;
        gc.gridy = 0;
        add(usernameField, gc);

        ////////////////////// reihe 2 ///////////////////////

        //hinzufuegen
        gc.gridx = 0;
        gc.gridy = 1;
        add(hinzufuegen, gc);

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
