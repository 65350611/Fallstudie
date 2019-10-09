package haushaltsbuch;

public class nutzerDemo {
	public static void main(String[] args) {
	      nutzerDAO nutzerDAO = new nutzerImpl();
	      
	      for (nutzerTest nutzerTest : nutzerDAO.getAllUsers()) {
		         System.out.println(nutzerTest.getNachname());
		      }
	      //update student
	    //  nutzerTest nutzerTest = nutzerDAO.getAllUsers().getUserByUserNachname(0);
	      //nutzerTest.setNachname("Michael");
	      //nutzerDAO.updateUser(nutzerTest);

	      nutzerDAO.getUser();
	      System.out.println(nutzerTest.getNachname());
}
}
