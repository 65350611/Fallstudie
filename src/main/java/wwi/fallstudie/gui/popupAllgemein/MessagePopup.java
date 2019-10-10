package wwi.fallstudie.gui.popupAllgemein;

import javax.swing.*;

public class MessagePopup {

    public MessagePopup(){
        JOptionPane.showMessageDialog(null, "Ups. Etwas ist schief gelaufen. Bitte versuche es noch einmal");
    }

    public MessagePopup(String nachricht){
        JOptionPane.showMessageDialog(null, nachricht);
    }
}
