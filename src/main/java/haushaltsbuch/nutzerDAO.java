package haushaltsbuch;

import java.util.*;

public interface nutzerDAO {
	nutzer getUser();
	List<nutzer> getAllUsers();
	nutzer getUserByUserNachname();
	boolean insertUser(nutzer nutzer);
	boolean updateUser(nutzer nutzer);
	boolean deleteUser(nutzer nutzer);
}


