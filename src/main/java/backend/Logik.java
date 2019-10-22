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

	public static void deleteUserMitAusgaben(String userName) throws AdmKannSichNichtSelberLoeschenException {
		if (admGemeldet) {
			if ((!adm.getName().contentEquals(userName.toString()))) {
				DbAbfragen.loescheAusgabenUndNutzer(userName);
			} else {
				throw new AdmKannSichNichtSelberLoeschenException();
			}
		}
	}

	public static void pwdAendern(String pwd) throws InvalidKeyException, NoSuchAlgorithmException,
			InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException,
			UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
		if (admGemeldet) {
			DbAbfragen.aenderePasswort(adm.getName(), CryptoUtil.encrypt(pwd));

		} else {
			DbAbfragen.aenderePasswort(usr.getName(), CryptoUtil.encrypt(pwd));
		}
	}

	// PWD ändern als Admin
	public static void pwdAendern(String userName, String pwd) throws FalscheAdmPwdAendernMethodeException,
			UsrNichtGefundenException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException {
		if (admGemeldet && !adm.getName().contentEquals(userName)) {

			if (DbAbfragen.aenderePasswort(userName, CryptoUtil.encrypt(pwd)) == 0) {
				throw new UsrNichtGefundenException();
			}
		} else {
			throw new FalscheAdmPwdAendernMethodeException();
		}
	}

	public static String returnPwd() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, IOException {
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

	}

	public static void kategorieLoeschen(String kateg) {

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
			String[] ausgabenArray = new String[ausgabenListe.size()];
			for (int i = 0; i < ausgabenListe.size(); i++) {
				for (int y=0; y <=7; y++) {
				if (y != 3) {
					ausgabenArray[i] = ausgabenArray[i] + " " + ausgabenListe.get(y);
				}}
			}
			return ausgabenArray;
		} else
			return null;
	}
}
