package wwi.fallstudie.database;

import backend.Anmeldung;
import backend.Logik;

public class testNutzer {

	public static void main(String[] args) {
		
		DbAbfragen.baueVerbindungAuf();
		
		Anmeldung.anmelden("tester3", "666");
		System.out.println(DbAbfragen.gibRolle("tester3"));
		System.out.println(Logik.istAdmin());
	}
	
}
