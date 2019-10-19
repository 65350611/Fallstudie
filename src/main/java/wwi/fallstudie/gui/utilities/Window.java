package wwi.fallstudie.gui.utilities;

import javax.swing.*;
import java.awt.*;

public class Window {

    private Window() {}

    public static void centerFrame(JFrame frame){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
