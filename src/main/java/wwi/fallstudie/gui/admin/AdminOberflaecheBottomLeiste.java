package wwi.fallstudie.gui.admin;

import wwi.fallstudie.gui.popupAllgemein.PopUpChangeUsername;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOberflaecheBottomLeiste extends JPanel {

    private JButton passwortAendern;
    private JButton deleteUser;

    public AdminOberflaecheBottomLeiste(){
        setLayout(new FlowLayout());

        passwortAendern = new JButton("Passwort von Nutzer ändern");
        passwortAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AdminOberflaechePopUpPasswortUserNeuSetzen();
            }
        });

        deleteUser = new JButton(("Nutzer löschen"));
        deleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PopUpChangeUsername();
            }
        });

        add(passwortAendern);
        add(deleteUser);
    }
}
