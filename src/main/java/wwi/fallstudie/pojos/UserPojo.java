package wwi.fallstudie.pojos;

public class UserPojo {
	private int userId;
	private String name;
	private String passwort;
//	private int funktion;
	private boolean angemeldet;
	

	/**
	 * 
	 */
	public UserPojo(int userId, String name, String passwort) {
		this.userId = userId;
		this.name = name;
		this.passwort = passwort;
//		this.funktion = funktion;
		this.angemeldet = false;
	}

	/**
	 * @return the userId
	 */
	int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the passwort
	 */
	String getPasswort() {
		return passwort;
	}

	/**
	 * @param passwort the passwort to set
	 */
	void setPasswort(String passwort) {
		this.passwort = passwort;
	}

//	/**
//	 * @return the funktion
//	 */
//	int getFunktion() {
//		return funktion;
//	}
//
//	/**
//	 * @param funktion the funktion to set
//	 */
//	/**
//	 * @param funktion
//	 */
//	void setFunktion(int funktion) {
//		this.funktion = funktion;
//	}

	/**
	 * @return the angemeldet
	 */
	boolean isAngemeldet() {
		return angemeldet;
	}

	/**
	 * @param angemeldet the angemeldet to set
	 */
	public boolean setAngemeldet(String passwd) {
		if (this.passwort.equals(passwd)) {
			this.angemeldet = true;
			return true;
		} else
			return false;
	}

	void unsetAngemeldet() {
		this.angemeldet = false;
	}

	
}
