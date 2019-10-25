package backend;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import backend_exceptions.AdmKannSichNichtSelberLoeschenException;
import backend_exceptions.FalscheAdmPwdAendernMethodeException;
import backend_exceptions.UserHatNochAusgabenException;
import backend_exceptions.UsrNichtGefundenException;
import haushaltsbuch.dbConnector;
import wwi.fallstudie.database.DbAbfragen;
import wwi.fallstudie.pojos.AdmPojo;
import wwi.fallstudie.pojos.UserPojo;

public class Logik {
	private static UserPojo usr;
	private static AdmPojo adm;
	private static boolean admGemeldet;
	static final dbConnector con = new dbConnector();

	private Logik() {

	}

	public static void nutzerAnlegen(int rolle, String userName, String pwd) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException
	{
//		DbAbfragen.neuerNutzer(rolle, pwd, userName);
		DbAbfragen.neuerNutzer(rolle, Krypto.encrypt(pwd), userName);
	}

	public static void admMelden(String name) {
		adm = new AdmPojo(name);
		admGemeldet = true;
	}

	public static void usrMelden(String name) {
		usr = new UserPojo(name);
		admGemeldet = false;
	}

	public static boolean istAdmin() {
		return admGemeldet;
	}

	public static void userErzeugen(String userName) {
		if (admGemeldet) {
			DbAbfragen.neuerNutzer(2, "start123", userName);
		}
	}

	public static void deleteUser(String userName)
			throws UserHatNochAusgabenException, AdmKannSichNichtSelberLoeschenException, UsrNichtGefundenException {
		if (admGemeldet && !adm.getName().contentEquals(userName.toString())) {
			switch (DbAbfragen.loescheNutzer(userName)) {
			case -1:
				throw new UserHatNochAusgabenException();
			case 0:
				throw new UsrNichtGefundenException();
			case 1:
				break;
			}
		} else {
			throw new AdmKannSichNichtSelberLoeschenException();
		}

	}
	
	public static void deleteAusgaben(int ausID) {
		
		DbAbfragen.loescheAusgabe(ausID);
	}
	
	public static void deleteKategorie(String katLabel) {
		
		int katID = DbAbfragen.gibIDderKategorie(katLabel, usr.getName());
			
		ArrayList<String> kategList = DbAbfragen.gibAusgabenFuerKategorie(usr.getName(), katID);
	
		if (kategList.size() == 0) {
			DbAbfragen.loescheKategorie(usr.getName(), katID);
		}
		else {
			DbAbfragen.aendereKategorieDerAusgabenAufSonstiges(usr.getName(), katID);
			DbAbfragen.loescheKategorie(usr.getName(), katID);
		}
	}

	public static void deleteUserMitAusgaben(String userName) throws AdmKannSichNichtSelberLoeschenException {
		if (admGemeldet) {
			if ((!adm.getName().contentEquals(userName.toString()))) {
				DbAbfragen.loescheAusgabenUndNutzer(userName);
			} else {
				throw new AdmKannSichNichtSelberLoeschenException();
			}
		}
	}
//Usr/adm aendert pwd fuer sich selbst
	public static void pwdAendern(String pwd) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
		if (admGemeldet) {
//			DbAbfragen.aenderePasswort(adm.getName(), pwd);
			DbAbfragen.aenderePasswort(adm.getName(), Krypto.encrypt(pwd));

		} else {
//			DbAbfragen.aenderePasswort(usr.getName(), pwd);
			DbAbfragen.aenderePasswort(usr.getName(), Krypto.encrypt(pwd));
		}
	}

	// PWD ändern als Admin von User
	public static void pwdAendern(String userName, String pwd) throws FalscheAdmPwdAendernMethodeException,
			UsrNichtGefundenException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
		if (admGemeldet && !adm.getName().contentEquals(userName)) {

//			if (DbAbfragen.aenderePasswort(userName, pwd) == false) 
			if (DbAbfragen.aenderePasswort(userName, Krypto.encrypt(pwd)) == false)
			{
				throw new UsrNichtGefundenException();
			}
		} else {
			throw new FalscheAdmPwdAendernMethodeException();
		}
	}

	public static String returnPwd() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, IOException {
		if (admGemeldet) {
			return Krypto.decrypt(DbAbfragen.gibPasswort(adm.getName()));
//			return DbAbfragen.gibPasswort(adm.getName());
		} else {
			return Krypto.decrypt(DbAbfragen.gibPasswort(usr.getName()));
//			return DbAbfragen.gibPasswort(usr.getName());
		}

	}

//	public static void usrAenderePwd(String pwd) {
//		DbAbfragen.aenderePasswort(usr.getName(), pwd);
//
//	}

	public static String[] getAlleNutzer() {
		if (admGemeldet) {
			ArrayList<String> usrList = DbAbfragen.gibNutzer();
			String[] arr = new String[usrList.size()];
			for (int i = 0; i < usrList.size(); i++) {
				arr[i] = usrList.get(i);
			}
			return arr;
		}
		return null;

	}

	public static void kategorieAnlegen(String kateg) {
		if (!admGemeldet) {

		}
	}

	public static void kategorieAendern(String katAlt, String katNeu) {
		
		int katIDAlt = DbAbfragen.gibIDderKategorie(katAlt, usr.getName());
		
			if (katNeu.contains("Sonstiges")) 
			{
				DbAbfragen.aendereKategorieDerAusgabenAufSonstiges(usr.getName(), katIDAlt);
			} 
			
			else 
			{
				ArrayList<String> katList = DbAbfragen.gibKategorienamen(usr.getName());
				boolean drin = katList.contains(katNeu);
				
				if (drin)
				{
					int katIDNeu = DbAbfragen.gibIDderKategorie(katNeu, usr.getName());
					DbAbfragen.aendereKategorieDerAusgaben(katIDNeu, usr.getName(), katIDAlt);
				} 
				else {
						DbAbfragen.aendereKategorieDerAusgabenAufNeu(katNeu, usr.getName(), katIDAlt);
				}	
			}
	}

	public static String[] getAlleKategorien() {
		if (!admGemeldet) {
			ArrayList<String> kategList = DbAbfragen.gibKategorienamen(usr.getName());
			String[] arr = new String[kategList.size()];
			for (int i = 0; i < kategList.size(); i++) {
				arr[i] = kategList.get(i);
			}
			return arr;
		} else
			return null;
	}
	/*
	public static String[] getZeitraum() {
		String untereZeitgrenze = "";
		String obereZeitgrenze = "";
		
		
		if (!admGemeldet) 
		{
			ArrayList<String> timeList = DbAbfragen.gibZeitraum(usr.getName());
			
			untereZeitgrenze = timeList.get(0);
			obereZeitgrenze = timeList.get(1);
			
			ArrayList<String> listKategorien = DbAbfragen.gibKategorienamenFuerZeitraum(usr.getName(), untereZeitgrenze,
					obereZeitgrenze);
			ArrayList<String> listAusgaben = DbAbfragen.gibAusgabenFuerZeitraum(usr.getName(), untereZeitgrenze, obereZeitgrenze);
			String[] rueckgabeArray = new String[listKategorien.size()];
			
			for (int i = 0; i < listKategorien.size(); i++) {
				rueckgabeArray[i] = listKategorien.get(i) + ": " + listAusgaben.get(i) + "€";
			}
	
			return rueckgabeArray;
		}
		
		else
		{
			return null;
		}
	}

	 */

	public static boolean pruefeDatum(String date) {
		return (date.length() == 10 && date.charAt(4) == '-' && date.charAt(7) == '-');
	}
	
	public static String[] getAllCategories() {
        String untereZeitgrenze = "";
        String obereZeitgrenze = "";
        
        if (!admGemeldet) 
        {
                     ArrayList<String> timeList = DbAbfragen.gibZeitraum(usr.getName());
                     
                     untereZeitgrenze = timeList.get(0);
                     obereZeitgrenze = timeList.get(1);
                     
                     ArrayList<String> insightsList = DbAbfragen.gibAusgabenFuerZeitraumMitKategorienamen(usr.getName(), untereZeitgrenze, obereZeitgrenze);
                     String[] rueckgabeArray = new String[insightsList.size()/2];

                     int array_counter = 0;


                     for(int i = 0; i < insightsList.size(); i+=2){
                                  rueckgabeArray[array_counter] = insightsList.get(i) + " : " + insightsList.get(i+1) + "€";
                                  array_counter++;
                     }

                     return rueckgabeArray;
        }
        return null;
}

	public static String[] getInsights(String startDat, String endDat) {
		if (!admGemeldet) {

			System.out.println("test1");


			ArrayList<String> insightsList = DbAbfragen.gibAusgabenFuerZeitraumMitKategorienamen(usr.getName(), startDat, endDat);
			String[] rueckgabeArray = new String[insightsList.size()/2];

			int array_counter = 0;


			for(int i = 0; i < insightsList.size(); i+=2){
				rueckgabeArray[array_counter] = insightsList.get(i) + " : " + insightsList.get(i+1) + "€";
				array_counter++;
			}

			return rueckgabeArray;
		}
		return null;
	}

	/*
	 * Diese Methode formatiert die Ausgaben aus der Datenbank in ein passendes Format für die GUI
	 */
	public static String[] getAlleAusgaben() {
		if (!admGemeldet) {
			ArrayList<String> ausgabenListe = DbAbfragen.gibAusgaben(usr.getName());
			String[] ausgabenArray = new String[(ausgabenListe.size() / 7) + 1];

			System.out.println("inside get alle ausgeben");

			// counter für bestimmte Stellen
			int id_counter = 0;
			int bezeichnungs_counter = 1;
			int kategorieBezeichnung_counter = 4;
			int betrag_counter = 5;
			int datum_counter = 6;
			int arrayCounter = 0;

			//schleife Formatiert die Strings aus der ausgabenListe um und fügt sie in Array ein
			for (int i = 0; i < ausgabenListe.size(); i++) {
				if(i == id_counter){
					ausgabenArray[arrayCounter] = "Ausgaben ID: " + ausgabenListe.get(i) + "; ";
					id_counter += 7;
				} else if(i == bezeichnungs_counter){
					ausgabenArray[arrayCounter] += "Bezeichnung: " + ausgabenListe.get(i) + "; ";
					bezeichnungs_counter += 7;
				} else if(i == kategorieBezeichnung_counter){
					ausgabenArray[arrayCounter] += "Kategorie: " + ausgabenListe.get(i) + "; ";
					kategorieBezeichnung_counter += 7;
				} else if(i == betrag_counter){
					ausgabenArray[arrayCounter] += "Betrag: " + ausgabenListe.get(i) + "€; ";
					betrag_counter += 7;
				} else if(i == datum_counter){
					ausgabenArray[arrayCounter] += "Datum: " + ausgabenListe.get(i);
					datum_counter += 7;
					arrayCounter++; // neue Zeile in Array
				}
			}
			return ausgabenArray;
		} else {
			return null;
		}
	}
	
	public static void ausgabeAnlegen(String kateg, String date, String betrag, String titel) {
		int x = DbAbfragen.gibIDderKategorie(kateg, usr.getName());
			DbAbfragen.neueAusgabe(titel, usr.getName(), x, Float.parseFloat(betrag), date);
	}
	
	public static void ausgabeAendern(int ausID, String kateg, String date, String betrag, String titel) {
		
		int katAlt = DbAbfragen.gibIDderKategorieNachAusgabe(ausID);
		int katNeu = DbAbfragen.gibIDderKategorie(kateg, usr.getName());
			if (katAlt == katNeu) {
				
				DbAbfragen.aendereAusgabeKategorieBleibt(ausID, titel, Float.parseFloat(betrag), date);
				
			}
			
			else
			{			
				DbAbfragen.aendereAusgabe(ausID, titel, katNeu, Float.parseFloat(betrag), date);
			}
	}

	public static void exitProgram() {
        DbAbfragen.schliesseVerbindung();
    }
}
