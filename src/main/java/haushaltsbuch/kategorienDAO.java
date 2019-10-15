package haushaltsbuch;

import java.util.*;

public interface kategorienDAO {
	public kategorien getCat(int catID);
	public List<kategorien> getAllCats();
	public void insertCat(kategorien kategorien);
	public void updateCat(kategorien kategorien);
	public void deleteCat(kategorien kategorien);
}