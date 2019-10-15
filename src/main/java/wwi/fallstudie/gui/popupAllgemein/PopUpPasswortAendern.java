package wwi.fallstudie.gui.popupAllgemein;

import wwi.fallstudie.gui.plausi.Comparator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PopUpPasswortAendern extends JFrame{
    private JPasswordField altesPasswordField;
    private JPasswordField passwordField;
    private JPasswordField wdhPasswordField;
    private JButton hinzufuegen;
    private JButton abbrechen;

    public PopUpPasswortAendern(){
        super("Passwort ändern");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise variables
        altesPasswordField = new JPasswordField();
        passwordField = new JPasswordField();
        wdhPasswordField = new JPasswordField();
        hinzufuegen = new JButton("Hinzufügen");
        abbrechen = new JButton("Abbrechen");

        //edit altesPasswordField
        altesPasswordField.setEchoChar((char)0);
        altesPasswordField.setForeground(Color.LIGHT_GRAY);
        altesPasswordField.setText("Altes Passwort");
        altesPasswordField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JPasswordField source = (JPasswordField) e.getComponent();
                source.setText("");
                source.setEchoChar('\u25CF');
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //edit passwordField
        passwordField.setEchoChar((char)0);
        passwordField.setForeground(Color.LIGHT_GRAY);
        passwordField.setText("Neues Passwort");
        passwordField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JPasswordField source = (JPasswordField) e.getComponent();
                source.setText("");
                source.setEchoChar('\u25CF');
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //edit wdhPasswordField
        wdhPasswordField.setEchoChar((char)0);
        wdhPasswordField.setForeground(Color.LIGHT_GRAY);
        wdhPasswordField.setText("Passwort wiederholen");
        wdhPasswordField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JPasswordField source = (JPasswordField) e.getComponent();
                source.setText("");
                source.setEchoChar('\u25CF');
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //set buttons on clicklistener
        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Comparator.compatePasswords(passwordField.getPassword(), wdhPasswordField.getPassword())){
                    //TODO prüfen ob altes passwort korrekt ist
                    //TODO ändere das Passwort
                    //dispose(); // popup schließen
                } else {
                    new MessagePopup("Passwörter stimmen nicht überein!");
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

        //altesPasswordField
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(altesPasswordField, gc);

        ////////////////////// reihe 2 ///////////////////////

        //passwordField
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 2;
        add(passwordField, gc);

        ////////////////////// reihe 3 ///////////////////////

        //wdhPasswordField
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth = 2;
        add(wdhPasswordField, gc);

        ////////////////////// reihe 4 ///////////////////////

        gc.gridwidth = 1;
        gc.ipady = 0;

        //hinzufuegen
        gc.gridx = 0;
        gc.gridy = 3;
        add(hinzufuegen, gc);

        //abbrechen
        gc.gridx = 1;
        gc.gridy = 3;
        add(abbrechen, gc);


        //set JFrame
        setSize(320, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}