package haushaltsbuch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
/*TODO von Nico @Flo: fix fehler damit der Build wieder läuft. Brauchst du die Main klasse wirklich?
public class nutzerImpl implements nutzerDAO {

	public static void main(String[] args)
    {
    }
    
	private nutzerTest extractUserFromResultSet(ResultSet rs) throws SQLException {
    		nutzerTest user = new nutzerTest();
    	    user.setPersnr( rs.getInt("persnr") );
    	    user.setNachname( rs.getString("nachname") );
    	    user.setVorname( rs.getString("vorname") );
    	    user.setGehalt( rs.getFloat("gehalt") );
    	    return user;
    	}
    
    public nutzerTest getUser(int persnr) 
	{
    Connection connection = conntest.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mitarbeiter3 WHERE persnr=" + persnr);
            if(rs.next())
            {
            	return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return null;
}
    public List<nutzerTest> getAllUsers() {
       // Connector connector = new Connector();
        Connection connection = conntest.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mitarbeiter3");
            List<nutzerTest> users = (List<nutzerTest>) new HashSet<nutzerTest>();
            while(rs.next())
            {
            	nutzerTest user = extractUserFromResultSet(rs);
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return null;
}
    public boolean insertUser(nutzerTest user) {
       // Connector connector = new Connector();
        Connection connection = conntest.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?)");
            ps.setString(1, user.getNachname());
            ps.setString(2, user.getVorname());
            ps.setFloat(3, user.getGehalt());
            int i = ps.executeUpdate();
          if(i == 1) {
            return true;
          }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

	@Override
	public nutzerTest getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public nutzerTest getUserByUserNachname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(nutzerTest nutzerTest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(nutzerTest nutzerTest) {
		// TODO Auto-generated method stub
		return false;
	}
}
*/
