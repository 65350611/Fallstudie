package wwi.fallstudie.database;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

import backend.Anmeldung;
import backend.Logik;

public class testNutzer {

	public static void main(String[] args) throws SQLException {
		
		Date sqlDate = new java.sql.Date(System.currentTimeMillis());	//empfangenes Datum muss evtl auf ein java.sql.Date übertragen werden
		
		DbAbfragen.baueVerbindungAuf();
		
		//Anmeldung.anmelden("tester3", "666");
		//System.out.println(DbAbfragen.neuerNutzer(1, "1111", "tester4"));
		//System.out.println(Logik.istAdmin());
		//System.out.println(DbAbfragen.neueAusgabe("testAusgabe17", "Jonny", 1, 17f, sqlDate));
		//System.out.println(DbAbfragen.loescheNutzer("tester3"));
		//System.out.println(DbAbfragen.aenderePasswort("Nico", "floflo"));
		//System.out.println(DbAbfragen.neueKategorie("testKat6"));
		//System.out.println(DbAbfragen.gibAusgabenFuerZeitraum("Jonny", "2015-10-12", "2015-10-13"));
		//System.out.println(DbAbfragen.gibAusgabenFuerKategorie("Jonny", 3));
		//System.out.println(DbAbfragen.loescheAusgabe("tester", 17));
		//System.out.println(DbAbfragen.loescheKategorie("Flo", 3));
		//System.out.println(DbAbfragen.aendereAusgabe("testAusgabeXXX", 2, 121212f, sqlDate, "Jonny", 12));
		//System.out.println(DbAbfragen.aendereKategorieDerAusgabenAufStandard("Flo", 3));
		//System.out.println(DbAbfragen.neueKategorie("Wait"));
		//System.out.println(DbAbfragen.gibKategorienDesUsers("tester"));
		System.out.println(DbAbfragen.gibAusgaben("Jonny"));
		//System.out.println(DbAbfragen.gibAusgabenFuerKategorie("tester", 2));
		//System.out.println(DbAbfragen.gibRolle("Flo"));
		//System.out.println(DbAbfragen.loescheAusgabenUndNutzer("123"));
		//System.out.println(DbAbfragen.gibPasswort("Nico"));
		//System.out.println(DbAbfragen.gibNutzer());
		//System.out.println(DbAbfragen.gibKategorienamen("Jonny"));
	}
	
}