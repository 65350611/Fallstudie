package wwi.fallstudie.gui.admin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AdminOberflaeche extends JFrame {
    private KopfLeistenPanel headpanel;
    private JList nutzerliste;
    private AdminOberflaecheBottomLeiste bottomLeiste;

    private String[] nutzerListeArray = {"asdf", "a", "asdf", "jafdjdfjj", "sadfjfadsjlafds", "asdf", "alal"};

    public AdminOberflaeche(){
        super("Admin Oberfläche");

        setLayout(new BorderLayout());

       // nutzerListeArray = getAlleNutzer();

        headpanel = new KopfLeistenPanel();
        bottomLeiste = new AdminOberflaecheBottomLeiste();

        nutzerliste = new JList(nutzerListeArray);
        nutzerliste.setVisibleRowCount(5);
        nutzerliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


       add(headpanel, BorderLayout.NORTH);
       add(new JScrollPane(nutzerliste), BorderLayout.CENTER);
       add(bottomLeiste, BorderLayout.SOUTH);

        //set JFrame
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}
