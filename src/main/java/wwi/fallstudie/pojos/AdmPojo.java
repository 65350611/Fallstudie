package wwi.fallstudie.pojos;

public class AdmPojo extends UserPojo {

	private boolean admin;

	public AdmPojo(String name) {
		super(name);
		this.admin = true;

	}

	public boolean getAdmin() {
		return admin;
	}
}
