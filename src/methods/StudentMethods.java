package methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentMethods {
	Connection connection;
	Scanner sc=new Scanner(System.in);
	
	public StudentMethods(Connection connection) {
	this.connection=connection;
	}
	
	public void addStudent(){
		System.out.print("Enter StudentId: ");
		int id=sc.nextInt();
		System.out.print("Enter First Name: ");
		String firstName=sc.next();
		System.out.print("Enter Last Name: ");
		String lastName=sc.next();
		System.out.print("Enter Age: ");
		int age=sc.nextInt();
		
		String query="INSERT INTO STUDENT (studentId, firstName, lastName, age) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setInt(4, age);
			
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
	
	public void updateStudent() {
		System.out.print("Enter StuudentId: ");
		int id=sc.nextInt();
		System.out.print("Enter First Name: ");
		String firstName=sc.next();
		System.out.print("Enter Last Name: ");
		String lastName=sc.next();
		System.out.print("Enter Age: ");
		int age=sc.nextInt();
		
		String query = "UPDATE STUDENT SET firstName = ?, lastName = ?, age = ? WHERE studentId = ?";
	    
	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, firstName);
	        ps.setString(2, lastName);
	        ps.setInt(3, age);
	        ps.setInt(4, id);
	        
	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Student updated successfully.");
	        } else {
	            System.out.println("Failed to update student. Student with ID " + id + " not found.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteStudent() {
		System.out.print("Enter StudentId: ");
		int id=sc.nextInt();
		
		String query="DELETE FROM STUDENT WHERE studentId=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			
			int rowsInserted = ps.executeUpdate(); // Execute the update statement
	        if (rowsInserted > 0) {
	            System.out.println("Student deleted successfully.");
	            System.out.println();
	        } else {
	            System.out.println("Failed to add student.");
	            System.out.println();
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMarks() {
		System.out.print("Enter Student ID: ");
	    int studentId = sc.nextInt();
	    System.out.print("Enter Subject: ");
	    String subject = sc.next();
	    System.out.print("Enter Marks: ");
	    double marks = sc.nextDouble();
	    
	    String query = "INSERT INTO Marks (studentId, subject, marks) VALUES (?, ?, ?)";
	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setInt(1, studentId);
	        ps.setString(2, subject);
	        ps.setDouble(3, marks);
	        
	        int rowsInserted = ps.executeUpdate();
	        
	        if (rowsInserted > 0) {
	            System.out.println("Marks added successfully.");
	        } else {
	            System.out.println("Failed to add marks.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateMarks() {
		System.out.print("Enter Student ID: ");
	    int studentId = sc.nextInt();
	    System.out.print("Enter Subject: ");
	    String subject = sc.next();
	    System.out.print("Enter New Marks: ");
	    double newMarks = sc.nextDouble();
	    
	    String query = "UPDATE Marks SET marks = ? WHERE studentId = ? AND subject = ?";
	    
	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        
	        ps.setDouble(1, newMarks);
	        ps.setInt(2, studentId);
	        ps.setString(3, subject);
	        
	        int rowsUpdated = ps.executeUpdate();
	        
	        if (rowsUpdated > 0) {
	            System.out.println("Marks updated successfully.");
	            System.out.println();
	        } else {
	            System.out.println("Failed to update marks. Student ID " + studentId + " or Subject " + subject + " not found.");
	            System.out.println();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void veiwAll() {
		String query = "SELECT student.studentId, student.firstName, student.lastName, marks.subject, marks.marks FROM student LEFT JOIN marks ON student.studentId = marks.studentId ORDER BY student.studentId ASC";
 
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
     
			System.out.println("StudentID\tFirst Name\tLast Name\tSubject\t\tMarks");
     
			while (rs.next()) {
				int studentId = rs.getInt("studentId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String subject = rs.getString("subject");
				double marks = rs.getDouble("marks");
         
				System.out.println(studentId + "\t\t" + firstName + "\t\t" + lastName + "\t\t" + subject + "\t\t" + marks);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
