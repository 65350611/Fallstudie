package wwi.fallstudie.pojos;

public class KategoriePojo {
	private int katId;
	private char bezeichnung;

	/**
	 * 
	 */
	public KategoriePojo(int katId, char bezeichnung) {
		this.katId = katId;
		this.bezeichnung = bezeichnung;
	}

	/**
	 * @return the katId
	 */
	int getKatId() {
		return katId;
	}

	/**
	 * @param katId the katId to set
	 */
	void setKatId(int katId) {
		this.katId = katId;
	}

	/**
	 * @return the bezeichnung
	 */
	char getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * @param bezeichnung the bezeichnung to set
	 */
	void setBezeichnung(char bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

}
