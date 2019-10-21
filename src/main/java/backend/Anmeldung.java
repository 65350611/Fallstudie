package backend;

import wwi.fallstudie.database.DbAbfragen;

public interface Anmeldung {

	public static void anmelden(String userName, String pwd) throws Exception {
		
		
		if ( pwd.contentEquals(DbAbfragen.gibPasswort(userName).toString())){
						
			if (DbAbfragen.gibRolle(userName)== 1) { 
				Logik.admMelden(userName);
			} else {
				Logik.usrMelden(userName);
			}
		}else
		{
			throw new Exception();
		}
		
		
	}

}