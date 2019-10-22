package wwi.fallstudie.gui.admin;

import backend.Logik;
import wwi.fallstudie.gui.popupAllgemein.MessagePopup;
import wwi.fallstudie.gui.utilities.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class NutzerWirklichLoeschenDialog extends JFrame {
    private JLabel message;

    private JButton delete;
    private JButton abbrechen;

    public NutzerWirklichLoeschenDialog(AdminOberflaeche adminOberflaeche, String userName){
        super("Nutzer löschen");

        setLayout(new GridBagLayout()); //setze Layout Manager

        //initialisiere variablen
        message = new JLabel("Dem Nutzer sind noch Ausgaben zugeordnet. Soll "+ userName + " wirklich gelöscht werden?");
        delete = new JButton("Löschen");
        abbrechen = new JButton("Abbrechen");


        //setze buttons on clicklistener
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    System.out.println("gui -> username: " + userName);
                    Logik.deleteUserMitAusgaben(userName);
                    System.out.println("gui -> löschen mit ausgaben ausgeführt");
                    adminOberflaeche.update(); //update die Adminoberfläche
                    dispose(); //fenster schließen
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
        setze variablen in Layout
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
        add(message, gc);

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


        //setze JFrame
        setSize(600, 100);
        Window.centerFrame(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
