package wwi.fallstudie.gui.login;

import wwi.fallstudie.gui.popupAllgemein.MessagePopup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel{

    private JTextField name;
    private JLabel nameLabel;
    private JPasswordField passwort;
    private JLabel passqortLabel;
    private JButton passwortVergessen;

    public LoginPanel(){
        setLayout(new GridBagLayout()); //set Layout

        //initialise variables
        name = new JTextField(15);
        nameLabel = new JLabel("Nutzername:");
        passwort = new JPasswordField(15);
        passqortLabel = new JLabel("Passwort:");
        passwortVergessen = new JButton("Passwort vergessen?");

        //setting listeners
        passwortVergessen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MessagePopup("Passwort vergessen?\n" + "Kein Problem!\n" + "Bitte wende dich an deinen Administrator um ein neues Passwort zu erhalten. \n" +
                        "Keine Sorge, du kannst es danach jederzeit ändern.");
            }
        });

        /*
        setting variables to Layout
         */
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;

        ////////////////////// reihe 1 ///////////////////////

        //nameLabel
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.EAST;
        add(nameLabel, gc);

        //name
        gc.gridx = 1;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(name, gc);

        ////////////////////// reihe 2 ///////////////////////

        //passwortLabel
        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.EAST;
        add(passqortLabel, gc);

        //passwort
        gc.gridx = 1;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(passwort, gc);

        ////////////////////// reihe 3 ///////////////////////

        //passwortvergessen
        gc.gridx = 1;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(passwortVergessen, gc);
    }
}
