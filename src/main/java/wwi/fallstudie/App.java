package wwi.fallstudie;


import wwi.fallstudie.database.DbAbfragen;
import wwi.fallstudie.gui.admin.AdminOberflaeche;
import wwi.fallstudie.gui.admin.AdminOberflaechePopUpPasswortUserNeuSetzen;
import wwi.fallstudie.gui.admin.AdminOberflaechePopUpUserHinzufuegen;

import wwi.fallstudie.gui.admin.NutzerWirklichLoeschenDialog;
import wwi.fallstudie.gui.login.Login;
import wwi.fallstudie.gui.popupAllgemein.PopUpPasswortAendern;
import wwi.fallstudie.gui.user.*;

public class App {
    public static void main(String[] args){

    	//DbAbfragen.baueVerbindungAuf();
        //Login fenster = new Login();

    	DbAbfragen.baueVerbindungAuf();
        //DbAbfragen.baueVerbindungAuf4Mac();

    	//DbAbfragen.baueVerbindungAuf();
        //DbAbfragen.baueVerbindungAuf4Mac();

        new Login();
        //new AdminOberflaechePopUpUserHinzufuegen();
        //new AdminOberflaechePopUpPasswortUserNeuSetzen();
        //new PopUpPasswortAendern();
        //new UserPopUpKategorieHinzufuegen();
        //AdminOberflaeche ao = new AdminOberflaeche();
        //new UserOberflaeche();
        //new NutzerWirklichLoeschenDialog(ao, "Heinrich Heine");
    }
}
