package wwi.fallstudie.gui.user;

import backend.Logik;
import wwi.fallstudie.gui.popupAllgemein.MessagePopup;

import javax.swing.*;
import java.awt.*;

public class InsightsPanel extends JPanel {

    private String[] insightsArray;

    private InsightsHeadPanel headPanel;

    private JList ausgabenListe;
    private DefaultListModel listModel;

    public InsightsPanel(){
        setLayout(new BorderLayout());

        headPanel = new InsightsHeadPanel(this);

        insightsArray = null;

        listModel = new DefaultListModel(); // erstelle list model
        addKategorisierteausgabenausArray2ListModel(); // füge daten aus dem Array ins ListModel ein
        ausgabenListe = new JList(listModel); // erstelle JList mit default list model
        ausgabenListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        add(headPanel, BorderLayout.NORTH);
        add(new JScrollPane(ausgabenListe), BorderLayout.CENTER);
    }

    public void update(){
        try {
            setInsightsArray(Logik.getInsights(headPanel.getStartDate().getText(), headPanel.getEndDate().getText()));
        } catch (Exception e){
            new MessagePopup("Insights konnten nicht geladen werden");
        }

        addKategorisierteausgabenausArray2ListModel(); // listmodel mit neuem Array befüllen
    }

    public String[] getInsightsArray() {
        return insightsArray;
    }

    public void setInsightsArray(String[] insightsArray) {
        this.insightsArray = insightsArray;
    }

    public void addKategorisierteausgabenausArray2ListModel(){
        listModel.removeAllElements(); // lösche alle elemente in dem List Modell, da durch die folgende Schleife neue hinzugefügt werden

        for(int i = 0; i < getInsightsArray().length; i++){
            System.out.println("i = " + i);
            listModel.addElement(getInsightsArray()[i]);
        }
    }
}
