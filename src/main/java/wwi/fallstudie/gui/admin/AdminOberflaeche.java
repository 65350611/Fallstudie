package wwi.fallstudie.gui.admin;

import javax.swing.*;
import java.awt.*;

public class AdminOberflaeche extends JFrame {
    KopfLeistenPanel headpanel = new KopfLeistenPanel();
    JScrollPane nutzerlisteScrollPane = new JScrollPane();

    public AdminOberflaeche(){
        super("Admin Oberfläche");

        setLayout(new GridBagLayout());


         /*
        setting variables to Layout
         */
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;

        ////////////////////// reihe 1 ///////////////////////

        //headpanel
        gc.gridx = 0;
        gc.gridy = 0;
        add(headpanel, gc);

        ////////////////////// reihe 2 ///////////////////////

        //nutzerlisteScrollPane
        gc.gridx = 0;
        gc.gridy = 1;
        add(nutzerlisteScrollPane, gc);

        //set JFrame
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}
