package wwi.fallstudie.database;

import backend.Anmeldung;
import backend.Logik;

public class testNutzer {

	public static void main(String[] args) {
		
		DbAbfragen.baueVerbindungAuf();
		
		//Anmeldung.anmelden("tester3", "666");
		System.out.println(DbAbfragen.neuerNutzer(1, "1111", "tester4"));
		//System.out.println(Logik.istAdmin());
	}
	
}
