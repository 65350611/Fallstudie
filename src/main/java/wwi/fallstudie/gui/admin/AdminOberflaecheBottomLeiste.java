package wwi.fallstudie.gui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOberflaecheBottomLeiste extends JPanel {

    private JButton passwortAendern;
    private JButton deleteUser;

    public AdminOberflaecheBottomLeiste(AdminOberflaeche adminOberflaeche){
        setLayout(new FlowLayout()); //layout setzen

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
                new PopUpDeleteUser(adminOberflaeche);
            }
        });

        //zu contentpane hinzufügen
        add(passwortAendern);
        add(deleteUser);
    }
}
