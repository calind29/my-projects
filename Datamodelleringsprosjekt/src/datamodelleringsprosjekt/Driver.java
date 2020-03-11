package datamodelleringsprosjekt;

import java.sql.*;
import java.util.Scanner;
public class Driver {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no:3306/calind_imdb", "calind_root", "root");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Excecute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from Media");
					
			//4. Process the result set
			/*while (myRs.next()) {
				System.out.println(myRs.getString("Tittel") + ", " + myRs.getString("Utgivelsesår"));
			}
			*/
			//5: Hva ønsker du å gjøre?
			Scanner myScann = new Scanner(System.in);
			System.out.println("What do you wish to do, answer with number 1 to 5: "
					+ "\n 1 - Find all the roles an actor has played."
					+ "\n 2 - Find what movies a given actor has played in. "
					+ "\n 3 - Find the company who has made the most movies in a giveen genre"
					+ "\n 4 - Add a new movie with director, screenwriter, actor and everything else. "
					+ "\n 5 - Add a new review of an episode in a serie.");
			
			int todo = myScann.nextInt();
			
			//Finn navnet på alle rollene en gitt skuespiller har.
			if (todo == 1) {
				try {
					Scanner myScanner = new Scanner(System.in);
					System.out.println("Enter actor: ");
					String fulltNavn = myScanner.nextLine();
					String query = "select Rolle, Tittel from Skuespiller natural join Person natural join Media where FulltNavn = '" + fulltNavn + "'";
					
					ResultSet r1 = myStmt.executeQuery(query);
					if (!r1.next()) {
						myStmt.executeQuery("feil");
					}
					System.out.println("Roles " + fulltNavn + " has played:");
					System.out.println(r1.getString("Rolle") + ", in the movie: " + r1.getString("Tittel"));
					while (r1.next()) {
						System.out.println(r1.getString("Rolle") + ", in the movie: " + r1.getString("Tittel"));
					}
					myScanner.close();
				}
				catch (Exception e) {
					System.out.println("This person doesn't have any roles or is not a person.");
				}
			}
			
			//Finn hvilke filmer som en gitt skuespiller opptrer i.
			else if (todo == 2) {
				try {
					Scanner myScanner = new Scanner(System.in);
					System.out.println("Enter actor: ");
					String fulltNavn = myScanner.nextLine();
					String query = "select Rolle, Tittel from Skuespiller natural join Person natural join Media where FulltNavn = '" + fulltNavn + "'";
					
					ResultSet r1 = myStmt.executeQuery(query);
					if (!r1.next()) {
						myStmt.executeQuery("feil");
					}
					System.out.println("Movies " + fulltNavn + " has appeared in:");
					System.out.println(r1.getString("Tittel") + ", as: " + r1.getString("Rolle"));
					while (r1.next()) {
						System.out.println(r1.getString("Tittel") + ", as: " + r1.getString("Rolle"));
					}
					myScanner.close();
				}
				catch (Exception e) {
					System.out.println("This person doesn't appear in any movies or is not a person.");
				}
			}
			
			//Trond pr�ver litt p� oppgave 4:
			else if (todo == 6) {
				try {
					Scanner myScanner = new Scanner(System.in);
					
					System.out.println("Enter title: ");
					String title = myScanner.nextLine();
					
					System.out.println("Enter movie length: ");
					String length = myScanner.nextLine();
					
					System.out.println("Enter release year: ");
					String year = myScanner.nextLine();
					
					System.out.println("Enter release date (YYYYMMDD)");
					String date = myScanner.nextLine();
					
					System.out.println("Enter movie description: ");
					String description = myScanner.nextLine();
					
					System.out.println("Originally for TV, Cinema or Streaming? ");
					String form = myScanner.nextLine();
					
					System.out.println("Released on video? True/False: ");
					String vid = myScanner.nextLine();
					
					ResultSet r2 = myStmt.executeQuery("select * from Media");
					int counter = 1;
					
					while(r2.next()) {
						counter+=1;
					}
					
					String query = "insert into Media (MediaID, Tittel, Lengde, Utgivelses�r, Lanseringsdato, Beskrivelse, Form, Utgitt) values (" + counter + ", '"
							+ title + "', " + length + ", " + year + ", " + date + ", '" + description + "', '" + form + "', " + vid + ")";
					
					
					myStmt.executeUpdate(query);
					System.out.println("Filmen ble lagt til!");
					
					
					
					myScanner.close();
					
				}
				catch (Exception e) {
					System.out.println("An error has occured, please try again. " + e);
				}
			}
			
			//Finne hvilke filmselskap som lager flest filmer innen hver sjanger.
			else if (todo == 3) {
				try {
					
				}
				catch (Exception e) {
					System.out.println("Error " + e);
				}

				
			}
			
			//Sette inn en ny film med regissør, manusforfatter, skuespiller og det som hører med.
			else if (todo == 4) {
				try {
					Scanner myScn = new Scanner(System.in);
					
					System.out.println("Enter Title, length of movie, Release year, Release date, Description, Form, Published, Actor, Role, Director, writer: ");
					String t = myScn.nextLine();
					String l = myScn.nextLine();
					String RY = myScn.nextLine();
					String RD = myScn.nextLine();
					String d = myScn.nextLine();
					String f = myScn.nextLine();
					String p = myScn.nextLine();
					String actor = myScn.nextLine();
					String role = myScn.nextLine();
					String director = myScn.nextLine();
					String writer = myScn.nextLine();
					
					ResultSet myRs3 = myStmt.executeQuery("select * from Media");
					int mediaCounter = 1;
					
					while(myRs3.next()) {
						mediaCounter+=1;
					}					
	
					String sq = "insert into Media" + "(MediaID, Tittel, Lengde, Utgivelsesår, Lanseringsdato, Beskrivelse, Form, Utgitt)" + " values ('"+mediaCounter+"','"+t+"','"+l+"','"+RY+"','"+RD+"','"+d+"','"+f+"','"+p+"')";
					
					ResultSet myRs4 = myStmt.executeQuery("select * from Person");
					int personCounter = 1;
					int directorCounter = 1;
					int writerCounter = 1;
					int c = 1;
					
					while(myRs4.next()) {
						personCounter+=1;
						directorCounter+=1;
						writerCounter+=1;
						c+=1;
						
						if (actor.equals(myRs4.getString("FulltNavn"))) {
							personCounter = myRs4.getInt("PersonID");
						}
						
						if (director.equals(myRs4.getString("FulltNavn"))) {
							directorCounter = myRs4.getInt("PersonID");
						}
						
						if (writer.equals(myRs4.getString("FulltNavn"))) {
							writerCounter = myRs4.getInt("PersonID");
						}
					}
					
					if (personCounter == c || directorCounter == c || writerCounter == c) {
						System.out.println("Enter birth year, birth country: ");
						String by = myScn.nextLine();
						String bc = myScn.nextLine();
						String sq1 = "insert into Person" + "(PersonID, FulltNavn, Fødselsår, Fødselsland)" + " values ('"+personCounter+"', '"+actor+"', '"+by+"','"+bc+"')";
						myStmt.executeUpdate(sq1);
					}
					
					String sq2 = "insert into Skuespiller" + "(MediaID, PersonID, Rolle)" + " values ('"+mediaCounter+"','"+personCounter+"','"+role+"')";
					String sq3 = "insert into Regissor" + "(MediaID, PersonID)" + " values ('"+mediaCounter+"','"+directorCounter+"')";
					String sq4 = "insert into Manusforfatter" + "(MediaID, PersonID)" + " values ('"+mediaCounter+"','"+writerCounter+"')";
					
					myStmt.executeUpdate(sq);
					myStmt.executeUpdate(sq2);
					myStmt.executeUpdate(sq3);
					myStmt.executeUpdate(sq4);
					
					System.out.println("Insert complete");
					myScn.close();
					
					}
				catch (Exception e) {
					System.out.println("Couldn't add movie " + e);
				}
			}
			
			//Sette inn en ny anmeldelse av en episode av en serie.
			else if (todo == 5) {
				try {
					
				}
				catch (Exception e) {
					System.out.println("Error " + e);
				}
				
			}
			
			else {
				System.out.println("Invalid entry");
			}
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
