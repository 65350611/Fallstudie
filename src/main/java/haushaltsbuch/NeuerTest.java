package haushaltsbuch;

import backend.Anmeldung;
import backend.Logik;

public class NeuerTest {

	public static void main(String[] args) {
		
		NeuerDBTest.baueVerbindungAuf();

		System.out.println(NeuerDBTest.aendereKategorieDerAusgaben("Kram", "Flo", 9));
	}
	
}
