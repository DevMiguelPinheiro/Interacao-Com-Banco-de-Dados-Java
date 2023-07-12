package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Main {

	public static void main(String[] args) throws DbException {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			
			// retornar 
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM department");

			while (rs.next()) {
				System.out.println(rs.getInt("Id") + "," + (rs.getString("Name")));

			}
			DB.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}// fim da main

}
