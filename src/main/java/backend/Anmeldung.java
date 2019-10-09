package backend;

public interface Anmeldung {

	public static void anmelden(int userId, String name, boolean admin) {	//Integer userID, String name, Integer userRole
		if (admin) {	//if (userRole == 1) {
			Logik.admMelden(userId, name);
		} else {
			Logik.usrMelden(userId, name);

		}
	}
}
