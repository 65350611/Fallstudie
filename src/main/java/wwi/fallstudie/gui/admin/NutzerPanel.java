package wwi.fallstudie.gui.admin;

import wwi.fallstudie.gui.popupAllgemein.PopUpPasswortAendern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NutzerPanel extends JPanel {

    private JLabel nutzer;
    private JButton loeschen;
    private JButton passwortAendern;

    public NutzerPanel(){
        setLayout(new FlowLayout());

        nutzer = new JLabel();
        //TODO Nutzer muss ausgefüllt werden

        loeschen = new JButton();
        loeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO nutzer loeschen

                //eventuell Fehlermeldung zeigen
            }
        });

        passwortAendern = new JButton();
        passwortAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO passwort aendern
                new PopUpPasswortAendern();
            }
        });

        add(nutzer);
        add(loeschen);
        add(passwortAendern);
    }

}

