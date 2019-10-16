package wwi.fallstudie.gui.admin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AdminOberflaeche extends JFrame {
    private KopfLeistenPanel headpanel;
    private NutzerListePanel nutzerlistePanel;
    private JScrollPane nutzerlisteScrollPane;

    public AdminOberflaeche(){
        super("Admin Oberfläche");

        setLayout(new BorderLayout());

        headpanel = new KopfLeistenPanel();
        nutzerlistePanel = new NutzerListePanel();
        nutzerlisteScrollPane = new JScrollPane(nutzerlistePanel);


       add(headpanel, BorderLayout.NORTH);
       add(nutzerlisteScrollPane, BorderLayout.CENTER);

        //set JFrame
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}
