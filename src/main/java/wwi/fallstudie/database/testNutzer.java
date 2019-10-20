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
		System.out.println(DbAbfragen.neueAusgabe("testAusgabe17", "tester", 1, 17f, sqlDate));
		//System.out.println(DbAbfragen.loescheNutzer("tester4"));
		//System.out.println(DbAbfragen.aenderePasswort("Flo", "floflo"));
		//System.out.println(DbAbfragen.neueKategorie("testKat6"));
		//System.out.println(DbAbfragen.gibAusgabenFuerZeitraum("tester", "2019-09-01", "2019-09-30"));
	}
	
}