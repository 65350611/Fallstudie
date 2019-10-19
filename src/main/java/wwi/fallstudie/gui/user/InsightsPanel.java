package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;

public class InsightsPanel extends JPanel {

    private String[] kategorisierteAusgabenArray = {"Sonstiges: 0€", "Wohnen: 1019€", "Essen: 100€"};

    private InsightsHeadPanel headPanel;

    private JList ausgabenListe;
    private DefaultListModel listModel;

    public InsightsPanel(){
        setLayout(new BorderLayout());

        headPanel = new InsightsHeadPanel(this);

        //TODO setKategoriesierteAusgabenArray(Logik.getAusgabenArray());

        listModel = new DefaultListModel(); // erstelle list model
        addKategorisierteausgabenausArray2ListModel(); // füge daten aus dem Array ins ListModel ein
        ausgabenListe = new JList(listModel); // erstelle JList mit default list model
        ausgabenListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        add(headPanel, BorderLayout.NORTH);
        add(new JScrollPane(ausgabenListe), BorderLayout.CENTER);
    }

    public void update(){
        System.out.println("entered update insights panel");

        //setKategorisierteAusgabenArray(TODO Logik.getAusgabenArray());

        addKategorisierteausgabenausArray2ListModel(); // listmodel mit neuem Array befüllen
    }

    public String[] getKategorisierteAusgabenArray() {
        return kategorisierteAusgabenArray;
    }

    public void setKategorisierteAusgabenArray(String[] kategorisierteAusgabenArray) {
        this.kategorisierteAusgabenArray = kategorisierteAusgabenArray;
    }

    public void addKategorisierteausgabenausArray2ListModel(){
        listModel.removeAllElements(); // lösche alle elemente in dem List Modell, da durch die folgende Schleife neue hinzugefügt werden

        for(int i=0; i < getKategorisierteAusgabenArray().length; i++){
            System.out.println("i = " + i);
            listModel.addElement(getKategorisierteAusgabenArray()[i]);
        }
    }
}
