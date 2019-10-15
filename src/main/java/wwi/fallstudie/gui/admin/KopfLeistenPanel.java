package wwi.fallstudie.gui.admin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class KopfLeistenPanel extends JPanel {

    KopfleistenNamenInfoPanel namenInfoPanel = new KopfleistenNamenInfoPanel();
    KopfleistenButtonPanel kopfleistenButtonPanel = new KopfleistenButtonPanel();

    public KopfLeistenPanel(){
        setLayout(new BorderLayout());
    }
}
