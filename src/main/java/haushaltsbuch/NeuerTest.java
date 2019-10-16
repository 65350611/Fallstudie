package haushaltsbuch;

import backend.Anmeldung;
import backend.Logik;

public class NeuerTest {

	public static void main(String[] args) {
		
		NeuerDBTest.baueVerbindungAuf();
		
		public nutzer getName() {
		    try {
		        Statement stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM nutzer WHERE name=" + name);
		        if(rs.next())
		        {
		            return extractUserFromResultSet(rs);
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    return null;
		}
	}
	
}
