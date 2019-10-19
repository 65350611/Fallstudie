package wwi.fallstudie.gui.admin;

import wwi.fallstudie.gui.popupAllgemein.MessagePopup;
import wwi.fallstudie.gui.utilities.Window;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AdminOberflaeche extends JFrame {
    private KopfLeistenPanel headpanel;
    private AdminOberflaecheBottomLeiste bottomLeiste;

    private JList nutzerliste;
    private DefaultListModel listModel;

    private String[] nutzerArray = {"Nutzer 1", "Nutzer 2", "Nutzer 3", "Nutzer 4", "Nutzer 5", "Nutzer 6"};

    public AdminOberflaeche(){
        super("Admin Oberfläche");

        setLayout(new BorderLayout());

        try {
            //TODO -> nutzerArray = getAlleNutzer();
        } catch (Exception e){
            e.printStackTrace();
            new MessagePopup();
        }

        headpanel = new KopfLeistenPanel(this);
        bottomLeiste = new AdminOberflaecheBottomLeiste(this);

        listModel = new DefaultListModel();
        addNutzerArray2ListModel();
        nutzerliste = new JList(listModel);
        nutzerliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


       add(headpanel, BorderLayout.NORTH);
       add(new JScrollPane(nutzerliste), BorderLayout.CENTER);
       add(bottomLeiste, BorderLayout.SOUTH);

        //set JFrame
        setSize(500, 450);
        Window.centerFrame(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    public void update(){
        // TODO setNutzerArray(Logik.getAlleNutzer());
        //TODO remove
        String[] test = {"Nutzer 1", "Nutzer 2", "Nutzer 3", "Nutzer 4", "Nutzer 5", "Nutzer 6", "updated"};
        setNutzerArray(test);

        addNutzerArray2ListModel();
    }

    public String[] getNutzerArray() {
        return nutzerArray;
    }

    public void setNutzerArray(String[] nutzerArray) {
        this.nutzerArray = nutzerArray;
    }

    public void addNutzerArray2ListModel(){
        listModel.removeAllElements(); // lösche alle elemente in dem List Modell, da durch die folgende Schleife neue hinzugefügt werden

        for(int i=0; i < getNutzerArray().length; i++){
            System.out.println("i = " + i);
            listModel.addElement(getNutzerArray()[i]);
        }
    }
}
