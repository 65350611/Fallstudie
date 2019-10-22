package wwi.fallstudie.gui.admin;

import backend.Logik;
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

    private String[] nutzerArray;

    public AdminOberflaeche(){
        super("Admin Oberfläche");

        setLayout(new BorderLayout());

        try {
            nutzerArray = Logik.getAlleNutzer(); //bekommt alle Nutzer als Array
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

        //variablen zu contentpane ninzufügen
       add(headpanel, BorderLayout.NORTH);
       add(new JScrollPane(nutzerliste), BorderLayout.CENTER);
       add(bottomLeiste, BorderLayout.SOUTH);

        //setze JFrame
        setSize(500, 450);
        Window.centerFrame(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    // aktualisiert die Anzeige der Nutzer
    public void update(){
        setNutzerArray(Logik.getAlleNutzer());
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
