package wwi.fallstudie.gui.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InsightsHeadPanel extends JPanel {
    JLabel startDateLabel;
    JLabel endDateLabel;

    JTextField startDate;
    JTextField endDate;
    JButton suchen;

    public InsightsHeadPanel(InsightsPanel insightsPanel){
        setLayout(new FlowLayout());

        startDateLabel = new JLabel("Startdatum: ");
        endDateLabel = new JLabel("Enddatum");

        startDate = new JTextField("YYYY-MM-DD");
        endDate = new JTextField("YYYY-MM-DD");

        //edit suchen
        suchen = new JButton("Suchen");
        suchen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                insightsPanel.update();
            }
        });

        //edit startDate
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
}

