package wwi.fallstudie.gui.user;

import wwi.fallstudie.gui.popupAllgemein.PopUpPasswortAendern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserKopfleistenNamenInfoPanel extends JPanel {
    private JLabel userLabel;
    private JButton passwortAendern;

    public UserKopfleistenNamenInfoPanel(){

        setLayout(new FlowLayout());

        userLabel = new JLabel("Nutzer");
        passwortAendern = new JButton("Passwort ändern");
        passwortAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PopUpPasswortAendern();
            }
        });

        add(userLabel);
        add(passwortAendern);
    }
}
