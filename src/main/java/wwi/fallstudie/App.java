package wwi.fallstudie;

import wwi.fallstudie.gui.admin.AdminOberflaechePopUpPasswortUserNeuSetzen;
import wwi.fallstudie.gui.admin.AdminOberflaechePopUpUserHinzufuegen;
import wwi.fallstudie.gui.login.Login;
import wwi.fallstudie.gui.popupAllgemein.PopUpPasswortAendern;
import wwi.fallstudie.gui.user.UserPopUpKategorieHinzufuegen;

public class App {
    public static void main(String[] args){
        Login fenster = new Login();
        //new AdminOberflaechePopUpUserHinzufuegen();
        //new AdminOberflaechePopUpPasswortUserNeuSetzen();
        //new PopUpPasswortAendern();
        new UserPopUpKategorieHinzufuegen();
    }
}
