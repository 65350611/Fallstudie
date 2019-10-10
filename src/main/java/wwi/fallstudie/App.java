package wwi.fallstudie;

import wwi.fallstudie.gui.AdminOberflaechePopUpPasswortUserNeuSetzen;
import wwi.fallstudie.gui.AdminOberflaechePopUpUserHinzufuegen;
import wwi.fallstudie.gui.Login;
import wwi.fallstudie.gui.MessagePopup;

import javax.swing.*;

public class App {
    public static void main(String[] args){
        Login fenster = new Login();
        //AdminOberflaechePopUpUserHinzufuegen adminPopup = new AdminOberflaechePopUpUserHinzufuegen();
        AdminOberflaechePopUpPasswortUserNeuSetzen nutzerHinzufuegen = new AdminOberflaechePopUpPasswortUserNeuSetzen();
    }
}
