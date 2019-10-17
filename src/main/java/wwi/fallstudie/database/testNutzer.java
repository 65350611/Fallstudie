package wwi.fallstudie.database;

import java.sql.Date;
import java.util.*;

import backend.Anmeldung;
import backend.Logik;

public class testNutzer {

	public static void main(String[] args) {
		
		Date sqlDate = new java.sql.Date(System.currentTimeMillis());	//empfangenes Datum muss evtl auf ein java.sql.Date übertragen werden
		
		DbAbfragen.baueVerbindungAuf();
		
		//Anmeldung.anmelden("tester3", "666");
		//System.out.println(DbAbfragen.neuerNutzer(1, "1111", "tester4"));
		//System.out.println(Logik.istAdmin());
		System.out.println(DbAbfragen.neueAusgabe(0, "testAusgabe14", "tester", 1, 14f, sqlDate));
		
	}
	
}
