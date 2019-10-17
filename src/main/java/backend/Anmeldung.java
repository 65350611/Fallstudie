package backend;

import wwi.fallstudie.database.DbAbfragen;

public interface Anmeldung {

	public static void anmelden(String userName, String pwd) {
		
		System.out.println(pwd + "   " + DbAbfragen.gibPasswort(userName).toString());
		
		if ( pwd.contentEquals(DbAbfragen.gibPasswort(userName).toString())){
			
			
			if (DbAbfragen.gibRolle(userName)== 1) { 
				Logik.admMelden(userName);
			} else {
				Logik.usrMelden(userName);
			}
		}
		
	}

}