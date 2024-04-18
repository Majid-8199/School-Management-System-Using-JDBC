package methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class SubjectMethods {
	Connection connection;
	Scanner sc=new Scanner(System.in);
	
	public SubjectMethods(Connection connection) {
	this.connection=connection;
	}

	public void addSubject(){
		System.out.print("Enter SubjectId: ");
		int id=sc.nextInt();
		
		System.out.print("Enter Subject: ");
		String subject=sc.next();
		String query="INSERT INTO SUBJECT (subjectId,subject) VALUES (?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, subject);
			
			int rowsInserted = ps.executeUpdate(); // Execute the update statement
	        if (rowsInserted > 0) {
	            System.out.println("Subject added successfully.");
	            System.out.println();
	        } else {
	            System.out.println("Failed to add subject.");
	            System.out.println();
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSubject() {
		System.out.print("Enter SubjectId: ");
		int id=sc.nextInt();
		
		String query="DELETE FROM SUBJECT WHERE subjectId=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			
			int rowsInserted = ps.executeUpdate(); // Execute the update statement
	        if (rowsInserted > 0) {
	            System.out.println("Subject deleted successfully.");
	            System.out.println();
	        } else {
	            System.out.println("Failed to add subject.");
	            System.out.println();
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void veiwAll() {
	    String query = "SELECT * FROM SUBJECT";

	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        System.out.println("SubjectID\tSubject");
	        while (rs.next()) {
	            int subjectId = rs.getInt("subjectId");
	            String subject = rs.getString("subject");
	            System.out.println(subjectId + "\t\t" + subject);
	        }
	        System.out.println(); // Print an empty line for better formatting
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }		
	}
}
