package wwi.fallstudie.pojos;

public class UserPojo {
	private int userId;
	private String name;
	private boolean angemeldet;
	

	public UserPojo(int userId, String name) {
		this.userId = userId;
		this.name = name;
		this.angemeldet = true;
	}

	void unsetAngemeldet() {
		this.angemeldet = false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAngemeldet() {
		return angemeldet;
	}

	public void setAngemeldet(boolean angemeldet) {
		this.angemeldet = angemeldet;
	}

	
}
