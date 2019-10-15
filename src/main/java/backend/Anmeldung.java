package backend;

public interface Anmeldung {

	public static void anmelden(int userId, String userName, boolean admin) {	//Integer userID, String name, Integer userRole
		if (admin) {	//if (userRole == 1) {
			Logik.admMelden(userId, userName);
		} else {
			Logik.usrMelden(userId, userName);

		}
	}
}
