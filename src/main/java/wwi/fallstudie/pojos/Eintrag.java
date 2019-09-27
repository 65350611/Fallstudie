package wwi.fallstudie.pojos;

import java.sql.Time;
import java.util.Date;

public class Eintrag {
	private char titel;
	private KategoriePojo kategorie;
	private Date datum;
	private Time uhrzeit;
	private char bemerkung;
	private int buchId;

	/**
	 * 
	 */
	public Eintrag(char titel, KategoriePojo kategorie, Date datum, Time uhrzeit, char bemerkung, int buchId) {
		this.titel = titel;
		this.kategorie = kategorie;
		this.datum = datum;
		this.uhrzeit = uhrzeit;
		this.bemerkung = bemerkung;
		this.buchId = buchId;

	}

	/**
	 * @return the titel
	 */
	char getTitel() {
		return titel;
	}

	/**
	 * @param titel the titel to set
	 */
	void setTitel(char titel) {
		this.titel = titel;
	}

	/**
	 * @return the kategorie
	 */
	KategoriePojo getKategorie() {
		return kategorie;
	}

	/**
	 * @param kategorie the kategorie to set
	 */
	void setKategorie(KategoriePojo kategorie) {
		this.kategorie = kategorie;
	}

	/**
	 * @return the datum
	 */
	Date getDatum() {
		return datum;
	}

	/**
	 * @param datum the datum to set
	 */
	void setDatum(Date datum) {
		this.datum = datum;
	}

	/**
	 * @return the uhrzeit
	 */
	Time getUhrzeit() {
		return uhrzeit;
	}

	/**
	 * @param uhrzeit the uhrzeit to set
	 */
	void setUhrzeit(Time uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	/**
	 * @return the bemerkung
	 */
	char getBemerkung() {
		return bemerkung;
	}

	/**
	 * @param bemerkung the bemerkung to set
	 */
	void setBemerkung(char bemerkung) {
		this.bemerkung = bemerkung;
	}

	/**
	 * @return the buchId
	 */
	int getBuchId() {
		return buchId;
	}

	/**
	 * @param buchId the buchId to set
	 */
	void setBuchId(int buchId) {
		this.buchId = buchId;
	}

}
