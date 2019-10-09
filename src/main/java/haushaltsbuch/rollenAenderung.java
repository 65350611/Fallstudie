package haushaltsbuch;

import java.sql.*;

public class rollenAenderung {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public rollenAenderung() {

	}

	private Connection getConnection() throws SQLException {
		Connection con;
		con = dbConnector.DriverManager.getConnection();
		return con;
	}

	public void add(rollen rollen) {
		try {
			String queryString = "INSERT INTO rollen(roleID, roleLabel) VALUES(?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, rollen.getRoleID());
			ptmt.setString(2, rollen.getRoleLabel());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void update(rollen rollen) {

		try {
			String queryString = "UPDATE rollen SET roleLabel=? WHERE roleID=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, rollen.getRoleLabel());
			ptmt.setInt(2, rollen.getRoleID());
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void delete(int roleID) {

		try {
			String queryString = "DELETE FROM rollen WHERE roleID=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, roleID);
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void findAll() {
		try {
			String queryString = "SELECT * FROM rollen";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("roleID " + resultSet.getInt("roleID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
