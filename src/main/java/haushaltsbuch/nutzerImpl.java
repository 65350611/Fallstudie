package haushaltsbuch;

import java.sql.*;
import java.util.*;

public class nutzerImpl implements nutzerDAO {
    
	private nutzer extractUserFromResultSet(ResultSet rs) throws SQLException {
    		nutzer user = new nutzer();
    	    user.setUserRole( rs.getInt("userRole") );
    	    user.setName( rs.getString("name") );
    	    user.setPassword( rs.getString("password") );
    	    return user;
    	}
    
    public nutzer getUser(Integer userID) throws SQLException 
	{
    Connection con = DriverManager.getConnection(null);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(null);
            if(rs.next())
            {
            	return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return null;
}
    /*public List<nutzer> getAllUsers() {
        Connector dbConnector = new dbConnector();
        Connection con = DriverManager.getConnection(null);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mitarbeiter3");
            List<nutzer> users = (List<nutzer>) new HashSet<nutzer>();
            while(rs.next())
            {
            	nutzer user = extractUserFromResultSet(rs);
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return null;
}*/
    public boolean insertUser(nutzer user) {
       // Connector connector = new Connector();
        Connection con = DriverManager.getConnection(null);
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO nutzer (userRole, userName, password) VALUES (?, ?, ?)");
            ps.setInt(1, user.getUserRole());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
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
	public nutzer getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public nutzer getUserByUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(nutzer nutzer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(nutzer nutzer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<nutzer> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	