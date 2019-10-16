package wwi.fallstudie.gui.admin;

import javax.swing.*;
import java.awt.*;

public class NutzerListePanel extends JPanel {

    private String[] nutzer = {"a", "b", "c", "d"};

    public NutzerListePanel(){
        //setBackground(Color.BLACK);

        //TODO nutzer = getNutzer();
        for(int i = 0; i < nutzer.length; i++){
            //TODO create new panels
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            JLabel label = new JLabel(nutzer[i]);

            panel.add(label);
        }
    }
}
