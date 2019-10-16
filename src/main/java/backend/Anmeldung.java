package backend;

import wwi.fallstudie.database.DbAbfragen;

public interface Anmeldung {

	public static void anmelden(String userName, String pwd) {
		if ( pwd.contentEquals(DbAbfragen.gibPasswort(userName).toString())){
			
			
			if (DbAbfragen.gibRolle(userName)== 1) { 
				Logik.admMelden(userId, userName);
			} else {
				Logik.usrMelden(userId, userName);
			}
		}
		
	}

}