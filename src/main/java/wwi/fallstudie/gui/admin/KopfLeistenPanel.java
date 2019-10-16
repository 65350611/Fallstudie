package wwi.fallstudie.gui.admin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class KopfLeistenPanel extends JPanel {

    private KopfleistenNamenInfoPanel namenInfoPanel;
    KopfleistenButtonPanel kopfleistenButtonPanel;

    public KopfLeistenPanel(){
        setLayout(new BorderLayout());

        namenInfoPanel = new KopfleistenNamenInfoPanel();
        kopfleistenButtonPanel = new KopfleistenButtonPanel();

        add(namenInfoPanel, BorderLayout.WEST);
        add(kopfleistenButtonPanel, BorderLayout.EAST);
    }
}
