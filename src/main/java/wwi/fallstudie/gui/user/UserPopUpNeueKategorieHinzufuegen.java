package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UserPopUpNeueKategorieHinzufuegen extends JFrame{

    private JTextField kategorie;

    private JButton aendern;
    private JButton abbrechen;

    public UserPopUpNeueKategorieHinzufuegen(){
        super("Passwort neu setzen");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise variables
        kategorie = new JTextField();
        aendern = new JButton("Hinzufügen");
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
        aendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO ändern
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

        //usernameField
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
        add(aendern, gc);

        //abbrechen
        gc.gridx = 1;
        gc.gridy = 1;
        add(abbrechen, gc);


        //set JFrame
        setSize(320, 130);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
