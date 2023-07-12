package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Deletar {
	Connection conn = null;
	PreparedStatement st = null;
	
	public void deletarDados() throws DbException {
		try {
			conn = DB.getConnection();
	
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?");

			st.setInt(1, 5);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
