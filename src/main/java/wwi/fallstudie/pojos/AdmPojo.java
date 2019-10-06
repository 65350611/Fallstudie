package wwi.fallstudie.pojos;

public class AdmPojo extends UserPojo {

	private boolean admin;

	public AdmPojo(int userId, String name) {
		super(userId, name);
		this.admin = true;

	}

	public boolean getAdmin() {
		return admin;
	}
}
