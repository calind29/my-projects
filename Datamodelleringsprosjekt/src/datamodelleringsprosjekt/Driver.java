package datamodelleringsprosjekt;

import java.sql.*;
public class Driver {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdb", "root", "cali2901");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Excecute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from Media");
					
			//4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("Tittel") + ", " + myRs.getString(""));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
