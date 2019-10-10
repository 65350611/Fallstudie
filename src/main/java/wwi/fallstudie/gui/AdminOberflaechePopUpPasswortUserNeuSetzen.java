package wwi.fallstudie.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AdminOberflaechePopUpPasswortUserNeuSetzen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField wdhPasswordField;
    private JButton hinzufuegen;
    private JButton abbrechen;

    public AdminOberflaechePopUpPasswortUserNeuSetzen(){
        super("Passwort neu setzten");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise variables
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        wdhPasswordField = new JPasswordField();
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

        //TODO einfügen von attributen in layout
         /*
        setting variables to Layout
         */
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;

        ////////////////////// reihe 1 ///////////////////////

        //usernameField
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(usernameField, gc);

        ////////////////////// reihe 2 ///////////////////////


        //set JFrame
        setSize(320, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
