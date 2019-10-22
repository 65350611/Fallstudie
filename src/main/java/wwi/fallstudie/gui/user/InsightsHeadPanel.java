package wwi.fallstudie.gui.user;

import backend.Logik;
import wwi.fallstudie.gui.popupAllgemein.MessagePopup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InsightsHeadPanel extends JPanel {
    private JLabel startDateLabel;
    private JLabel endDateLabel;

    private JTextField startDate;
    private JTextField endDate;
    private JButton suchen;

    public InsightsHeadPanel(InsightsPanel insightsPanel){
        setLayout(new FlowLayout());

        startDateLabel = new JLabel("Startdatum: ");
        endDateLabel = new JLabel("Enddatum");

        startDate = new JTextField(15);
        endDate = new JTextField(15);

        //edit suchen
        suchen = new JButton("Suchen");
        suchen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (Logik.pruefeDatum(startDate.getText()) && Logik.pruefeDatum(endDate.getText())) {
                        insightsPanel.update();
                    } else {
                        new MessagePopup("Daten müssen im Format \"YYYY-MM-DD\" eingegeben werden!");
                    }
                } catch (NullPointerException e){
                    new MessagePopup("Daten müssen im Format \"YYYY-MM-DD\" eingegeben werden!");
                } catch (Exception e){
                    new MessagePopup();
                }
            }
        });

        //edit startDate
        startDate.setText("YYYY-MM-DD");
        startDate.setForeground(Color.LIGHT_GRAY);
        startDate.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //edit endDate
        endDate.setText("YYYY-MM-DD");
        endDate.setForeground(Color.LIGHT_GRAY);
        endDate.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.setForeground(Color.BLACK);
                source.removeFocusListener(this);
            }
        });

        //add components
        add(startDateLabel);
        add(startDate);
        add(endDateLabel);
        add(endDate);
        add(suchen);
    }

    public JTextField getStartDate() {
        return startDate;
    }

    public void setStartDate(JTextField startDate) {
        this.startDate = startDate;
    }

    public JTextField getEndDate() {
        return endDate;
    }

    public void setEndDate(JTextField endDate) {
        this.endDate = endDate;
    }
}

