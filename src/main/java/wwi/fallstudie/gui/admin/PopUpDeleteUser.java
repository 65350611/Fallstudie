package wwi.fallstudie.gui.admin;

import backend.Logik;
import wwi.fallstudie.gui.popupAllgemein.MessagePopup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PopUpDeleteUser extends JFrame {

    private JTextField usernameField;

    private JButton delete;
    private JButton abbrechen;

    public PopUpDeleteUser(){
        super("Nutzer löschen");

        setLayout(new GridBagLayout()); //set Layout Manager

        //initialise variables
        usernameField = new JTextField();
        delete = new JButton("Löschen");
        abbrechen = new JButton("Abbrechen");


        //edit usernameField
        usernameField.setForeground(Color.LIGHT_GRAY);
        usernameField.setText("Nutzername");
        usernameField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });




        //set buttons on clicklistener
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    System.out.println(usernameField.getText());
                    Logik.deleteUser(usernameField.getText()); //lösche Nutzer
                    dispose();
                } catch(Exception e){
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

        //usernameField
        gc.ipady = 20;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(usernameField, gc);

        ////////////////////// reihe 2 ///////////////////////

        gc.gridwidth = 1;
        gc.ipady = 0;

        //hinzufuegen
        gc.gridx = 0;
        gc.gridy = 1;
        add(delete, gc);

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
