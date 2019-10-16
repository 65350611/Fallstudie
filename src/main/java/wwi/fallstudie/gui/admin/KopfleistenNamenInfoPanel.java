package wwi.fallstudie.gui.admin;

import wwi.fallstudie.gui.popupAllgemein.PopUpPasswortAendern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KopfleistenNamenInfoPanel extends JPanel {

    private JLabel adminLabel;
    private JButton passwortAendern;

    public KopfleistenNamenInfoPanel(){

        setLayout(new FlowLayout());

        adminLabel = new JLabel("Admin");
        passwortAendern = new JButton("Passwort ändern");
        passwortAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PopUpPasswortAendern();
            }
        });

        add(adminLabel);
        add(passwortAendern);
    }
}
