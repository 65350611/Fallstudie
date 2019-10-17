package backend;

import haushaltsbuch.ausgaben;
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

	public static void deleteUser(String userName) {
		if (admGemeldet) {
			DbAbfragen.loescheNutzer(userName);
		}
	}

	public static void pwdAendern(String pwd) {
		DbAbfragen.Ae
	}
	public static void pwdAendern(String userName, String pwd) {
		
	}

	public static String returnPwd() {
		if (admGemeldet) {
			return DbAbfragen.gibPasswort(adm.getName());
		}else {
			return DbAbfragen.gibPasswort(usr.getName());
		}
		
	}
}
