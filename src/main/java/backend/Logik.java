package backend;

import backend_exceptions.UserHatNochAusgabenException;
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

	public static void deleteUser(String userName) throws UserHatNochAusgabenException {
		if (admGemeldet) {
			if (!DbAbfragen.loescheNutzer(userName)) {
				throw new UserHatNochAusgabenException();
			}
		}

	}

	public static void deleteUserMitAusgaben(String userName) {
		if (admGemeldet) {
			if ((adm.getName().contentEquals(userName.toString()))) {
				DbAbfragen.loescheAusgabenUndNutzer(userName);
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

	public static void pwdAendern(String userName, String pwd) {

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
