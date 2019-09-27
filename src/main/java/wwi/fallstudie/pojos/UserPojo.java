package wwi.fallstudie.pojos;

public class UserPojo {
	private int userId;
	private char name;
	private char passwort;
	private int funktion;

	/**
	 * 
	 */
	public UserPojo(int userId, char name, char passwort, int funktion) {
		this.userId = userId;
		this.name = name;
		this.passwort = passwort;
		this.funktion = funktion;
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
	char getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	void setName(char name) {
		this.name = name;
	}

	/**
	 * @return the passwort
	 */
	char getPasswort() {
		return passwort;
	}

	/**
	 * @param passwort the passwort to set
	 */
	void setPasswort(char passwort) {
		this.passwort = passwort;
	}

	/**
	 * @return the funktion
	 */
	int getFunktion() {
		return funktion;
	}

	/**
	 * @param funktion the funktion to set
	 */
	void setFunktion(int funktion) {
		this.funktion = funktion;
	}

}
