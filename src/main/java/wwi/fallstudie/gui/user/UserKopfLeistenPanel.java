package wwi.fallstudie.gui.user;

import wwi.fallstudie.gui.admin.KopfleistenButtonPanel;
import wwi.fallstudie.gui.admin.KopfleistenNamenInfoPanel;

import javax.swing.*;
import java.awt.*;

public class UserKopfLeistenPanel extends JPanel {
    private UserKopfleistenNamenInfoPanel namenInfoPanel;
    private UserKopfLeistenButtonPanel kopfleistenButtonPanel;

    public UserKopfLeistenPanel(UserOberflaeche userOberflaeche){
        setLayout(new BorderLayout());

        namenInfoPanel = new UserKopfleistenNamenInfoPanel();
        kopfleistenButtonPanel = new UserKopfLeistenButtonPanel(userOberflaeche);

        add(namenInfoPanel, BorderLayout.WEST);
        add(kopfleistenButtonPanel, BorderLayout.EAST);
    }
}
