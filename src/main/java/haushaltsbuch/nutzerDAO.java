package haushaltsbuch;

import java.util.*;

public interface nutzerDAO {
	nutzer getUser();
	Set<nutzer> getAllUsers();
	nutzer getUserByUserNameAndPassword();
	boolean insertUser();
	boolean updateUser();
	boolean deleteUser();
}


