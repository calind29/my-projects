package datamodelleringsprosjekt;
import java.sql.*;
import java.util.*;

public class Person extends DBConn {
	private int PersonID;
	private String FulltNavn;
	private int FødtÅr;
	private String FødtLand;
	
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
            ResultSet rs = stmt.executeQuery("select FulltNavn, Fødselsår, Fødselsland from Person where PersonID=" + PersonID);
            while (rs.next()) {
                FulltNavn =  rs.getString("FulltNavn");
                FødtÅr = rs.getInt("Fødselsår");
                FødtLand = rs.getString("Fødselsland");
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
		System.out.println(test.FødtLand);
	}

}

