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
        try {
            DbAbfragen.baueVerbindungAuf(); //try windows Connection DB
            new Login();
        } catch (Exception e){
            e.printStackTrace();

           /* try{
                DbAbfragen.baueVerbindungAuf4Mac(); //try Mac Connection DB
                new Login();
            } catch (Exception e2){
                e.printStackTrace();
                System.out.println("Programm konnte nicht gestartet werden");
            }*/
        }
    }
}
