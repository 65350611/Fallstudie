package wwi.fallstudie.gui.user;

import wwi.fallstudie.gui.admin.AdminOberflaecheBottomLeiste;
import wwi.fallstudie.gui.admin.AdminOberflaechePopUpUserHinzufuegen;
import wwi.fallstudie.gui.admin.KopfLeistenPanel;

import javax.swing.*;
import java.awt.*;

public class UserOberflaeche extends JFrame{
    private UserKopfLeistenPanel headpanel;
    private JLayeredPane anzeigePanel;
    private UserOberflaecheBottomLeiste bottomLeiste;

    private AusgabenAnzeigenPanel ausgabenAnzeigenPanel = new AusgabenAnzeigenPanel();
    private KategorienAnzeigenPanel kategorienAnzeigenPanel = new KategorienAnzeigenPanel();
    private InsightsPanel insightsPanel = new InsightsPanel();

    public UserOberflaeche(){
        super("Nutzer Oberfläche");

        setLayout(new BorderLayout());

        //edit anzeigePanel
        anzeigePanel = new JLayeredPane();
        anzeigePanel.setLayout(new BorderLayout());

        anzeigePanel.add(insightsPanel, BorderLayout.CENTER);
        anzeigePanel.add(kategorienAnzeigenPanel, BorderLayout.CENTER);
        anzeigePanel.add(ausgabenAnzeigenPanel, BorderLayout.CENTER);

        //set other Variables
        headpanel = new UserKopfLeistenPanel(this);
        bottomLeiste = new UserOberflaecheBottomLeiste(anzeigePanel, ausgabenAnzeigenPanel, kategorienAnzeigenPanel, insightsPanel);

        /*
        private String[] nutzerListeArray = {"asdf", "a", "asdf", "jafdjdfjj", "sadfjfadsjlafds", "asdf", "alal"};
        private JList nutzerliste;
        nutzerliste = new JList(nutzerListeArray);
        nutzerliste.setVisibleRowCount(5);
        nutzerliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(nutzerliste), BorderLayout.CENTER);
         */

        add(headpanel, BorderLayout.NORTH);
        add(anzeigePanel, BorderLayout.CENTER);
        add(bottomLeiste, BorderLayout.SOUTH);

        //set JFrame
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}
