package wwi.fallstudie.database;

import java.sql.SQLException;

public class testNutzer {

	public static void main(String[] args) throws SQLException {		
		
		DbAbfragen.baueVerbindungAuf();
		
		//1: SELECT Statements - Abfragen
		
		//System.out.println(DbAbfragen.gibRolle("Flo"));
		//System.out.println(DbAbfragen.gibNutzer());
		
		//System.out.println(DbAbfragen.gibIDderKategorie("Sonstiges", "Frodo"));
		//System.out.println(DbAbfragen.gibKategorienamenFuerZeitraum("Frodo", "2000-01-01", "2020-01-01"));
		//System.out.println(DbAbfragen.gibKategorienDesUsers("tester"));
		
		//System.out.println(DbAbfragen.gibAusgaben("Jonny"));
		//System.out.println(DbAbfragen.gibAusgabenFuerZeitraumMit("Frodo", "2000-01-01", "2020-01-01"));
		//System.out.println(DbAbfragen.gibAusgabenFuerKategorie("Jonny", 3));
		//System.out.println(DbAbfragen.gibAusgabenMitKategorienamen("Frodo"));
		
		//2: CREATE Statements - neue Einträge anlegen
				
		//System.out.println(DbAbfragen.neuerNutzer(1, "1111", "tester4"));
		//System.out.println(DbAbfragen.neueKategorie("testKat6"));
		//System.out.println(DbAbfragen.neueAusgabe("testAusgabe17", "Uni", 1, 17f, "2015-10-12"));
		
		//3: UPDATE Statements - Einträge ändern
		
		//System.out.println(DbAbfragen.aenderePasswort("Sauron", "niconico"));
		//System.out.println(DbAbfragen.aendereKategorieDerAusgabenAufSonstige("tester2", 40));
		//System.out.println(DbAbfragen.aendereKategorieDerAusgaben("Urlaub", "tester2", 26));
		//System.out.println(DbAbfragen.aendereAusgabe("testAusgabe", 2, 121212f, sqlDate, "Jonny", 12));
		//System.out.println(DbAbfragen.aendereKategorieDerAusgabenAufNeu("Auto", "tester2", 3));
		
		//4: DELETE Statements - Einträge löschen
		
		//System.out.println(DbAbfragen.loescheKategorie("Flo", 3));
		//System.out.println(DbAbfragen.loescheNutzer("tester3"));
		//System.out.println(DbAbfragen.loescheAusgabe("tester", 17));
		//System.out.println(DbAbfragen.loescheAusgabenUndNutzer("123"));
	}
	
}