package wwi.fallstudie;


import wwi.fallstudie.database.DbAbfragen;
import wwi.fallstudie.gui.admin.AdminOberflaeche;
import wwi.fallstudie.gui.admin.AdminOberflaechePopUpPasswortUserNeuSetzen;
import wwi.fallstudie.gui.admin.AdminOberflaechePopUpUserHinzufuegen;

import wwi.fallstudie.gui.admin.NutzerWirklichLoeschenDialog;
import wwi.fallstudie.gui.login.Login;
import wwi.fallstudie.gui.popupAllgemein.PopUpPasswortAendern;
import wwi.fallstudie.gui.user.UserOberflaeche;
import wwi.fallstudie.gui.user.UserPopUpAusgabeHinzufuegen;

public class App {
    public static void main(String[] args){

    	//DbAbfragen.baueVerbindungAuf();
        //Login fenster = new Login();

    	DbAbfragen.baueVerbindungAuf();
        new Login();
        //new AdminOberflaechePopUpUserHinzufuegen();
        //new AdminOberflaechePopUpPasswortUserNeuSetzen();
        //new PopUpPasswortAendern();
        //new UserPopUpKategorieHinzufuegen();
        //new UserPopUpAusgabeHinzufuegen();
        //AdminOberflaeche ao = new AdminOberflaeche();
        //new UserOberflaeche();
        //new NutzerWirklichLoeschenDialog(ao, "Heinrich Heine");
    }
}
