package backend;

import haushaltsbuch.ausgaben;
import haushaltsbuch.dbConnector;
import wwi.fallstudie.pojos.AdmPojo;
import wwi.fallstudie.pojos.UserPojo;

public class Logik {
	private static UserPojo usr;
	private static AdmPojo adm;
	private static boolean admGemeldet;
	static final dbConnector con = new dbConnector();
	private Logik() {

	}
	public void ausgabenAnzeigen() {
		
		ausgaben ag = con.zeigeAusgaben(usr.getName());
		
		
	}
	
	
	public static void admMelden(String name) {
		adm = new AdmPojo(name);
		admGemeldet=true;
	}
	
	public static void usrMelden(String name) {
		usr = new UserPojo(name);
		admGemeldet=false;
	}

	public void userErstellen(int userId, String name, String psw) {
//		TODO: Rücksprache mit Flo wie ein Nutzer erstellt werden soll.
	}

	public static boolean istAdmin() {
		return admGemeldet;
	}
}
