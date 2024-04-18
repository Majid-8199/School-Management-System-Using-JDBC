package methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherMethods {
	Connection connection;
	Scanner sc=new Scanner(System.in);
	
	public TeacherMethods(Connection connection) {
	this.connection=connection;
	}
	
	public void addTeacher(){
		System.out.print("Enter TeacherId: ");
		int id=sc.nextInt();
		System.out.print("Enter First Name: ");
		String firstName=sc.next();
		System.out.print("Enter Last Name: ");
		String lastName=sc.next();
		System.out.print("Enter Subject: ");
		String subject=sc.next();
		
		String query="INSERT INTO TEACHER (teacherId, firstName, lastName, subject) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, subject);
			
			int rowsInserted = ps.executeUpdate(); // Execute the update statement
	        if (rowsInserted > 0) {
	            System.out.println("Teacher added successfully.");
	            System.out.println();
	        } else {
	            System.out.println("Failed to add teacher.");
	            System.out.println();
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTeacher() {
		System.out.print("Enter TeacherId: ");
		int id=sc.nextInt();
		System.out.print("Enter First Name: ");
		String firstName=sc.next();
		System.out.print("Enter Last Name: ");
		String lastName=sc.next();
		System.out.print("Enter Subject: ");
		String subject=sc.next();
		
		String query = "UPDATE TEACHER SET firstName = ?, lastName = ?, subject = ? WHERE teacherId = ?";
	    
	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, firstName);
	        ps.setString(2, lastName);
	        ps.setString(3, subject);
	        ps.setInt(4, id);
	        
	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Teacher updated successfully.");
	        } else {
	            System.out.println("Failed to update teacher. Teacher with ID " + id + " not found.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteTeacher() {
		System.out.print("Enter TeacherId: ");
		int id=sc.nextInt();
		
		String query="DELETE FROM TEACHER WHERE teacherId=?";
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
		String query = "SELECT * FROM TEACHER";

	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        System.out.println("TeacherID\tFirstName\tLastName\tSubject");
	        while (rs.next()) {
	            int teacherId = rs.getInt("teacherId");
	            String firstName = rs.getString("firstName");
	            String lastName = rs.getString("lastName");
	            String subject = rs.getString("subject");
	            System.out.println(teacherId + "\t\t" + firstName + "\t\t" + lastName +"\t\t" + subject);
	        }
	        System.out.println(); // Print an empty line for better formatting
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
		}
	}
}
