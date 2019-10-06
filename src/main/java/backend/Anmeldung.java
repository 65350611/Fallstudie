package backend;

public interface Anmeldung {

	public static void anmelden(int userId, String name, boolean admin) {
		if (admin) {
			Logik.admMelden(userId, name);
		} else {
			Logik.usrMelden(userId, name);

		}
	}
}
