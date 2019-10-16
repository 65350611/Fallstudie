package wwi.fallstudie.gui.user;

import wwi.fallstudie.gui.admin.AdminOberflaecheBottomLeiste;
import wwi.fallstudie.gui.admin.AdminOberflaechePopUpUserHinzufuegen;
import wwi.fallstudie.gui.admin.KopfLeistenPanel;

import javax.swing.*;
import java.awt.*;

public class UserOberflaeche extends JFrame{
    private UserKopfLeistenPanel headpanel;
    private JList nutzerliste;
    private UserOberflaecheBottomLeiste bottomLeiste;

    private String[] nutzerListeArray = {"asdf", "a", "asdf", "jafdjdfjj", "sadfjfadsjlafds", "asdf", "alal"};

    public UserOberflaeche(){
        super("Nutzer Oberfläche");

        setLayout(new BorderLayout());

        // nutzerListeArray = getAlleNutzer();

        headpanel = new UserKopfLeistenPanel(this);
        bottomLeiste = new UserOberflaecheBottomLeiste();

        nutzerliste = new JList(nutzerListeArray);
        nutzerliste.setVisibleRowCount(5);
        nutzerliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        add(headpanel, BorderLayout.NORTH);
        add(new JScrollPane(nutzerliste), BorderLayout.CENTER);
        add(bottomLeiste, BorderLayout.SOUTH);

        //set JFrame
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}
