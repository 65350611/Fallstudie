package wwi.fallstudie.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private ImageIcon logoIcon;
    private JLabel logo;
    private LoginPanel loginPanel;
    private JButton einloggen;

    public Login(){
        super("Login");

        setLayout(new BorderLayout()); //set Layout Manager

        //initialise variables
        logoIcon = new ImageIcon("/Users/niconeitzert/IdeaProjects/Fallstudie/src/images/BoB_Logo128.png"); //TODO pfad ändern und logo auch
        logo = new JLabel(logoIcon);
        loginPanel = new LoginPanel();
        einloggen = new JButton("Einloggen");

        //listeners
        einloggen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO open popup Passwort vergessen
            }
        });
        //add to content pane
        add(logo, BorderLayout.NORTH);
        add(loginPanel, BorderLayout.CENTER);
        add(einloggen, BorderLayout.SOUTH);


        //set Frame
        setSize(320, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
