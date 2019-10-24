package wwi.fallstudie.gui.user;

import backend.Logik;

import javax.swing.*;
import java.awt.*;

public class KategorienAnzeigenPanel extends JPanel {

    private String[] kategorienArray;

    private DefaultListModel listModel;
    private JList kategorienListe;

    public KategorienAnzeigenPanel(){
        setLayout(new BorderLayout());

        setKategorienArray(Logik.getAlleKategorien());

        listModel = new DefaultListModel();
        addKategorienAusArray2ListModel();
        kategorienListe = new JList(listModel);
        kategorienListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(new JScrollPane(kategorienListe), BorderLayout.CENTER);
    }

    public void update(){
        setKategorienArray(Logik.getAlleKategorien());
        addKategorienAusArray2ListModel();
    }

    public String[] getKategorienArray() {
        return kategorienArray;
    }

    public void setKategorienArray(String[] kategorienArray) {
        this.kategorienArray = kategorienArray;
    }

    public void addKategorienAusArray2ListModel(){
        listModel.removeAllElements(); // lösche alle elemente in dem List Modell, da durch die folgende Schleife neue hinzugefügt werden

        for(int i=0; i < getKategorienArray().length; i++){
            System.out.println("i = " + i);
            listModel.addElement(getKategorienArray()[i]);
        }
    }
}
