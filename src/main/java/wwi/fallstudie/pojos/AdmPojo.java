package wwi.fallstudie.pojos;

public class  AdmPojo extends UserPojo{

	private boolean admin;
	private String admkey = "test";

	public AdmPojo(int userId, String name, String passwort) {
		super(userId, name, passwort);
		this.admkey = passwort;
		
	}
	/**
	 * @return the admin
	 */
	boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 * @return
	 */
	boolean setAdmin(String passwd) {
		if (this.admkey.equals(passwd)) {
			this.admin = true;
			return true;
		} else
			return false;
	}
}
