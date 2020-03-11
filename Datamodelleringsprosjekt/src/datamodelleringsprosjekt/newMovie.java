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



/* 
package datamodelleringsprosjekt;
import java.sql.*;
import java.util.*;

public class Person extends DBConn {
	private int PersonID;
	private String FulltNavn;
	private int Fodt�r;
	private String F�dtLand;
	
	public Person (int PersonID) {
		this.PersonID = PersonID;
	}
	
	public int getPersonID() {
		return PersonID;
	}
	
	public void initialize () {
		connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select FulltNavn, F�dsels�r, F�dselsland from Person where PersonID=" + PersonID);
            while (rs.next()) {
                FulltNavn =  rs.getString("FulltNavn");
                F�dt�r = rs.getInt("F�dsels�r");
                F�dtLand = rs.getString("F�dselsland");
            }

        } catch (Exception e) {
            System.out.println("db error during select of bruker= "+e);
            return;
            }
	}
	
	
	public void refresh () {
        initialize ();
    }
	
	
	public static void main(String[] args) {
		Person test = new Person(2);
		System.out.println(test.getPersonID());
		test.initialize();
		System.out.println(test.FulltNavn);
		System.out.println(test.F�dtLand);
	}

}
*/
