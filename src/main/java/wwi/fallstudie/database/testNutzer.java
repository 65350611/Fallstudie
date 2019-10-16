package wwi.fallstudie.database;

import backend.Anmeldung;

public class testNutzer {

	public static void main(String[] args) {
		
		DbAbfragen.baueVerbindungAuf();
		
		//Anmeldung.anmelden("tester", "12345");
		System.out.println(DbAbfragen.gibRolle("tester"));
	}
	
}
