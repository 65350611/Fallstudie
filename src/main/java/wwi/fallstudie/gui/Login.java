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
<<<<<<< HEAD
        logoIcon = new ImageIcon("src/images/BoB_Logo128.png"); //TODO pfad ändern und logo auch
=======
        logoIcon = new ImageIcon("src/images/IMG_1020.JPG"); //TODO logo ändern <<src/images/BoB_Logo128.png
>>>>>>> branch 'master' of https://github.com/65350611/Fallstudie.git
        logo = new JLabel(logoIcon);
        loginPanel = new LoginPanel();
        einloggen = new JButton("Einloggen");

        //listeners
        einloggen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO login
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
