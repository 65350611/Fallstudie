package wwi.fallstudie.gui.user;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import backend.Logik;

public class AusgabenAnzeigenPanel extends JPanel {

    private String[] ausgabenArray;

    private DefaultListModel listModel;
    private JList ausgabenListe;

    public AusgabenAnzeigenPanel(){
        setLayout(new BorderLayout());

        setAusgabenArray(Logik.getAlleAusgaben());

        listModel = new DefaultListModel();

        ausgabenListe = new JList(listModel); // erstelle list model
        addAusgabenAusArray2ListModel(); // füge daten aus dem Array ins ListModel ein
        ausgabenListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // erstelle JList mit default list model

        add(new JScrollPane(ausgabenListe), BorderLayout.CENTER);
    }

    public void update(){
        setAusgabenArray(Logik.getAlleAusgaben());
        addAusgabenAusArray2ListModel(); // listmodel mit neuem Array befüllen
    }

    public String[] getAusgabenArray() {
        return ausgabenArray;
    }

    public void setAusgabenArray(String[] ausgabenArray) {
        this.ausgabenArray = ausgabenArray;
    }

    public void addAusgabenAusArray2ListModel(){
        listModel.removeAllElements(); // lösche alle elemente in dem List Modell, da durch die folgende Schleife neue hinzugefügt werden

        for(int i=0; i < getAusgabenArray().length; i++){
            System.out.println("i = " + i);
            listModel.addElement(getAusgabenArray()[i]);
        }
    }
}

