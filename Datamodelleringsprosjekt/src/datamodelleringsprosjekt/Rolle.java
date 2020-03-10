package datamodelleringsprosjekt;
import java.sql.*;
import java.util.*;

public class Rolle extends DBConn {
	private String FulltNavn;
	
	public Rolle (String Navn) {
		this.FulltNavn = Navn;
	}
	
	public void GetRolle () {
		connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select Rolle from Skuespiller natural join Person where FulltNavn=" + FulltNavn);
            while (rs.next()) {
                FulltNavn =  rs.getString("FulltNavn");
                System.out.println(FulltNavn);
            }

        } catch (Exception e) {
            System.out.println("db error during select of bruker= "+e);
            return;
            }
	}
	
	
	public void refresh () {
        GetRolle ();
    }
	
	
	public static void main(String[] args) {
		Rolle test = new Rolle("Trond Vatten");
		test.GetRolle();
		System.out.println(test.FulltNavn);
		
	}

}

