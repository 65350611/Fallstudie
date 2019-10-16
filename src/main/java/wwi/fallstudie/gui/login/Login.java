package wwi.fallstudie.gui.login;

import backend.Anmeldung;
import backend.Logik;
import wwi.fallstudie.gui.admin.AdminOberflaeche;
import wwi.fallstudie.gui.login.LoginPanel;
import wwi.fallstudie.gui.popupAllgemein.MessagePopup;
import wwi.fallstudie.gui.user.UserOberflaeche;

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
        logoIcon = new ImageIcon("src/images/IMG_1020.JPG"); //TODO logo ändern <<src/images/BoB_Logo128.png
        logo = new JLabel(logoIcon);
        loginPanel = new LoginPanel();
        einloggen = new JButton("Einloggen");

        //listeners
        einloggen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Einloggen LoginScreen gedrückt");
                try {
                    System.out.println("getName" + loginPanel.getName() + "getPasswort" + loginPanel.getPasswort());
                    Anmeldung.anmelden(loginPanel.getNameLabel(), loginPanel.getPasswort());
                   
                    if(Logik.istAdmin()){
                        new AdminOberflaeche(); //öffne Admin oberfläche
                    } else {
                        new UserOberflaeche(); //öffne User oberfläche
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    new MessagePopup("Kein User gefunden");
                }
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
