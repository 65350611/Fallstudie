package haushaltsbuch;

import java.util.*;

public class kategorienDAOimpl implements kategorienDAO {
	
	List<kategorien> kategorien;
	
	public kategorienDAOimpl() {
		
		kategorien = new ArrayList<kategorien>();
		kategorien kategorien1 = new kategorien(0, "neuerTest");
	    kategorien.add(kategorien1);
		
	}

	@Override
	public kategorien getCat(int catID) {
		return kategorien.get(catID);
	}

	@Override
	public List<kategorien> getAllCats() {
		return kategorien;
	}

	@Override
	public void insertCat(kategorien kategorien) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCat(kategorien kategorien) {
		kategorien.get(kategorien.getCatID()).setCatLabel(kategorien.getCatLabel());
	      System.out.println("Kategorien: CatID " + kategorien.getCatID() + ", updated in the database");
	}

	@Override
	public void deleteCat(kategorien kategorien) {
		kategorien.remove(kategorien.getCatID());
	      System.out.println("Kategorien: CatID " + kategorien.getCatID() + ", deleted from database");
	}
	
}