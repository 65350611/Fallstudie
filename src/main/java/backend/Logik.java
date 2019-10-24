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

	public static void nutzerAnlegen(int rolle, String userName, String pwd) {
		DbAbfragen.neuerNutzer(rolle, pwd, userName);
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

	public static void pwdAendern(String pwd){
		if (admGemeldet) {
			DbAbfragen.aenderePasswort(adm.getName(), pwd);

		} else {
			DbAbfragen.aenderePasswort(usr.getName(), pwd);
		}
	}

	// PWD ändern als Admin
	public static void pwdAendern(String userName, String pwd) throws FalscheAdmPwdAendernMethodeException,
			UsrNichtGefundenException{
		if (admGemeldet && !adm.getName().contentEquals(userName)) {

			if (DbAbfragen.aenderePasswort(userName, pwd) == false) {
				throw new UsrNichtGefundenException();
			}
		} else {
			throw new FalscheAdmPwdAendernMethodeException();
		}
	}

	public static String returnPwd() {
		if (admGemeldet) {
//			return CryptoUtil.decrypt(DbAbfragen.gibPasswort(adm.getName()));
			return DbAbfragen.gibPasswort(adm.getName());
		} else {
//			return CryptoUtil.decrypt(DbAbfragen.gibPasswort(usr.getName()));
			return DbAbfragen.gibPasswort(usr.getName());
		}

	}

	public static void usrAenderePwd(String pwd) {
		DbAbfragen.aenderePasswort(usr.getName(), pwd);

	}

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
	
	public static String[] getZeitraum() {
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

	public static boolean pruefeDatum(String date) {
		return (date.length() == 10 && date.charAt(4) == '-' && date.charAt(7) == '-');
	}

	public static String[] getInsights(String startDat, String endDat) {
		if (!admGemeldet) {
			ArrayList<String> insightListKategorien = DbAbfragen.gibKategorienamenFuerZeitraum(usr.getName(), startDat,
					endDat);
			ArrayList<String> insightListAusgaben = DbAbfragen.gibAusgabenFuerZeitraum(usr.getName(), startDat, endDat);
			String[] arr = new String[insightListKategorien.size()];
			for (int i = 0; i < insightListKategorien.size(); i++) {
				arr[i] = insightListKategorien.get(i) + ": " + insightListAusgaben.get(i) + "€";
			}
			return arr;
		}
		return null;
	}

	public static String[] getAlleAusgaben() {
		if (!admGemeldet) {
			ArrayList<String> ausgabenListe = DbAbfragen.gibAusgaben(usr.getName());
			String[] ausgabenArray = new String[(ausgabenListe.size() / 7)+1];
			for (int i = 0; i < ausgabenArray.length; i++) {
				ausgabenArray[i] = " ";
			}
			ausgabenArray[0] = "   ID     Bez      Usr     IDKat    BezKat    Betrag   Datum";
			int x = 0;
			int y = 0;
			int h;
			for (int i = 1; i < ausgabenArray.length; i++) {
				h = 0;
				for (y = x; y < ausgabenListe.size(); y++) {
					if (h <= 6) {
						ausgabenArray[i] = ausgabenArray[i] + "    " + ausgabenListe.get(y);
						x++;
						h++;
					}
				}
			}
			return ausgabenArray;
		} else
			return null;
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
        //TODO schließe verbindung
    }
}
