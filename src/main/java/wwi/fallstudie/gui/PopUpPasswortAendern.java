package wwi.fallstudie.gui;

import wwi.fallstudie.gui.MessagePopup;
import wwi.fallstudie.gui.plausi.Comparator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PopUpPasswortAendern extends JFrame{
    private JPasswordField passwordField;
    private JPasswordField wdhPasswordField;
    private JButton hinzufuegen;
    private JButton abbrechen;

    public PopUpPasswortAendern(){
        super("Passwort ändern");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise variables
        passwordField = new JPasswordField();
        wdhPasswordField = new JPasswordField();
        hinzufuegen = new JButton("Hinzufügen");
        abbrechen = new JButton("Abbrechen");

        //edit passwordField
        passwordField.setEchoChar((char)0);
        passwordField.setForeground(Color.LIGHT_GRAY);
        passwordField.setText("Passwort");
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
        System.out.println(wdhPasswordField.getEchoChar());
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
                    //TODO ändere das Passwort
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

        //passwordField
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(passwordField, gc);

        ////////////////////// reihe 2 ///////////////////////

        //wdhPasswordField
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 2;
        add(wdhPasswordField, gc);

        ////////////////////// reihe 3 ///////////////////////

        gc.gridwidth = 1;
        gc.ipady = 0;

        //hinzufuegen
        gc.gridx = 0;
        gc.gridy = 2;
        add(hinzufuegen, gc);

        //abbrechen
        gc.gridx = 1;
        gc.gridy = 2;
        add(abbrechen, gc);


        //set JFrame
        setSize(320, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
