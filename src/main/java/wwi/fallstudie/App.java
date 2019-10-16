package wwi.fallstudie;


import wwi.fallstudie.database.DbAbfragen;
import wwi.fallstudie.gui.admin.AdminOberflaeche;
import wwi.fallstudie.gui.admin.AdminOberflaechePopUpPasswortUserNeuSetzen;
import wwi.fallstudie.gui.admin.AdminOberflaechePopUpUserHinzufuegen;

import wwi.fallstudie.gui.login.Login;
import wwi.fallstudie.gui.popupAllgemein.PopUpPasswortAendern;
import wwi.fallstudie.gui.user.UserOberflaeche;
import wwi.fallstudie.gui.user.UserPopUpAusgabeHinzufuegen;
import wwi.fallstudie.gui.user.UserPopUpKategorieHinzufuegen;

public class App {
    public static void main(String[] args){
    	//DbAbfragen.baueVerbindungAuf();
        //Login fenster = new Login();
        //new AdminOberflaechePopUpUserHinzufuegen();
        //new AdminOberflaechePopUpPasswortUserNeuSetzen();
        //new PopUpPasswortAendern();
        //new UserPopUpKategorieHinzufuegen();
        //new UserPopUpAusgabeHinzufuegen();
        //new AdminOberflaeche();
        new UserOberflaeche();
    }
}
