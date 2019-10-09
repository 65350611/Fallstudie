package haushaltsbuch;

import java.util.*;

public interface ausgabenDAO {
	ausgaben getExp();
	public List<ausgaben> getAllExp();
	public ausgaben getAusgaben(Integer expID);
	//ausgaben getUserByUserNachname();
	boolean insertExp(ausgaben ausgaben);
	boolean updateExp(ausgaben ausgaben);
	boolean deleteExp(ausgaben ausgaben);
}


