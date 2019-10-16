package wwi.fallstudie.gui.admin;

import wwi.fallstudie.gui.popupAllgemein.PopUpChangeUsername;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOberflaecheBottomLeiste extends JPanel {

    private JButton passwortAendern;
    private JButton userNamenAendern;

    public AdminOberflaecheBottomLeiste(){
        setLayout(new FlowLayout());

        passwortAendern = new JButton("Passwort von Nutzer ändern");
        passwortAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AdminOberflaechePopUpPasswortUserNeuSetzen();
            }
        });

        userNamenAendern = new JButton(("Nutzernamen ändern"));
        userNamenAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PopUpChangeUsername();
            }
        });

        add(passwortAendern);
        add(userNamenAendern);
    }
}
