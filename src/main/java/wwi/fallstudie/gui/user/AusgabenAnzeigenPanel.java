package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;

public class AusgabenAnzeigenPanel extends JPanel {

    private String[] ausgabenArray = {"Ausgaben ID: 1; Kategorie: Wohnen; Titel: Miete; Betrag: 1000,00€; Datum: 2019-10-01", "Ausgaben ID: 2; Kategorie: Wohnen; Titel: GEZ; Betrag: 19,00€; Datum: 2019-10-01"};

    private DefaultListModel listModel;
    private JList ausgabenListe;

    public AusgabenAnzeigenPanel(){
        setLayout(new BorderLayout());

        //setAusgabenArray(TODO Logik.getAusgabenArray());

        listModel = new DefaultListModel();

        ausgabenListe = new JList(listModel); // erstelle list model
        addAusgabenAusArray2ListModel(); // füge daten aus dem Array ins ListModel ein
        ausgabenListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // erstelle JList mit default list model

        add(new JScrollPane(ausgabenListe), BorderLayout.CENTER);
    }

    public void update(){
        //setAusgabenArray(TODO Logik.getAusgabenArray()); //setze Array

        //TODO test -> remove
        String[] test = {"Ausgaben ID: 1; Kategorie: Wohnen; Titel: Miete; Betrag: 1000,00€; Datum: 2019-10-01", "Ausgaben ID: 2; Kategorie: Wohnen; Titel: GEZ; Betrag: 19,00€; Datum: 2019-10-01", "updated"};
        setAusgabenArray(test);

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

