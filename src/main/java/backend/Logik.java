package backend;

import haushaltsbuch.ausgaben;
import haushaltsbuch.dbConnector;
import wwi.fallstudie.pojos.AdmPojo;
import wwi.fallstudie.pojos.UserPojo;

public class Logik {
	private static UserPojo usr;
	private static AdmPojo adm;
	static final dbConnector con = new dbConnector();
	private Logik() {

	}
	public void ausgabenAnzeigen() {
		
		ausgaben ag = con.zeigeAusgaben(usr.getName());
		
		
	}
	
	
	public static void admMelden(int userId, String name) {
		adm = new AdmPojo(userId, name);
	}

	public static void usrMelden(int userId, String name) {
		usr = new UserPojo(userId, name);
	}

	public void userErstellen(int userId, String name, String psw) {
//		TODO: Rücksprache mit Flo wie ein Nutzer erstellt werden soll.
	}

}
