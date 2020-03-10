package datamodelleringsprosjekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class newMovie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no:3306/calind_imdb", "calind_root", "root");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Excecute SQL query
			Scanner myScn = new Scanner(System.in);
			
			System.out.println("Enter Title, length of movie, Release year, Release date, Description, Form, Published:");
			String t = myScn.nextLine();
			String l = myScn.nextLine();
			String RY = myScn.nextLine();
			String RD = myScn.nextLine();
			String d = myScn.nextLine();
			String f = myScn.nextLine();
			String p = myScn.nextLine();
			
			ResultSet myRs = myStmt.executeQuery("select * from Media");
			int counter = 1;
			
			while(myRs.next()) {
				counter+=1;
				
			}
			
			
			
			
			String sq1 = "insert into Media" + "(MediaID, Tittel, Lengde, Utgivelsesår, Lanseringsdato, Beskrivelse, Form, Utgitt)" + " values ('"+counter+"','"+t+"','"+l+"','"+RY+"','"+RD+"','"+d+"','"+f+"','"+p+"')";
			
			myStmt.executeUpdate(sq1);
			
			System.out.println("Insert complete");

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
