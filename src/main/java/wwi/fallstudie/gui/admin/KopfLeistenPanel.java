package wwi.fallstudie.gui.admin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class KopfLeistenPanel extends JPanel {

    private KopfleistenNamenInfoPanel namenInfoPanel;
    private KopfleistenButtonPanel kopfleistenButtonPanel;

    public KopfLeistenPanel(AdminOberflaeche adminOberflaeche){
        setLayout(new BorderLayout());

        namenInfoPanel = new KopfleistenNamenInfoPanel();
        kopfleistenButtonPanel = new KopfleistenButtonPanel(adminOberflaeche);

        add(namenInfoPanel, BorderLayout.WEST);
        add(kopfleistenButtonPanel, BorderLayout.EAST);
    }
}
