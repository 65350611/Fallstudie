package backend;

public interface Anmeldung {

	public static void anmelden(String userName, String pwd) {

		if (admin == 1) { 
			Logik.admMelden(userId, userName);
		} else {
			Logik.usrMelden(userId, userName);

		}
	}
}
