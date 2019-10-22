package backend;

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

	public static void pwdAendern(String pwd) {
		if (admGemeldet) {
			DbAbfragen.aenderePasswort(adm.getName(), pwd);

		} else {
			DbAbfragen.aenderePasswort(usr.getName(), pwd);
		}
	}

	// PWD ändern als Admin
	public static void pwdAendern(String userName, String pwd)
			throws FalscheAdmPwdAendernMethodeException, UsrNichtGefundenException {
		if (admGemeldet && !adm.getName().contentEquals(userName)) {

			if (DbAbfragen.aenderePasswort(userName, pwd) == 0) {
				throw new UsrNichtGefundenException();
			}
		} else {
			throw new FalscheAdmPwdAendernMethodeException();
		}
	}

	public static String returnPwd() {
		if (admGemeldet) {
			return DbAbfragen.gibPasswort(adm.getName());
		} else {
			return DbAbfragen.gibPasswort(usr.getName());
		}

	}

	public static void usrAenderePwd(String pwd) {
		DbAbfragen.aenderePasswort(usr.getName(), pwd);

	}

	public static String[] getAusgabenArray() {

		return null;
	}
}
