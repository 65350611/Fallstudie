package haushaltsbuch;

import java.util.*;

public interface nutzerDAO {
	nutzer getUser();
	List<nutzer> getAllUsers();
	nutzer getUserByUserName();
	boolean insertUser(nutzer user);
	boolean updateUser(nutzer user);
	boolean deleteUser(nutzer user);
}


