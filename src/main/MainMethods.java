package main;

import java.sql.Connection;
import java.util.Scanner;

import dbconnnection.DBConnection;
import methods.StudentMethods;
import methods.SubjectMethods;
import methods.TeacherMethods;

public class MainMethods {
	Scanner sc=new Scanner(System.in);
	Connection connection=new DBConnection().getConnection();
	TeacherMethods teacherMethods=new TeacherMethods(connection);
	StudentMethods studentMethods=new StudentMethods(connection);
	SubjectMethods subjectMethods=new SubjectMethods(connection);
	
	public void studentManagement() {
		int choice;
		
		do {
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Add Marks");
			System.out.println("5. Update Marks");
			System.out.println("6. View all Student");
			System.out.println("0. Go Back");
			System.out.print("Enter your choice: ");
			choice=sc.nextInt();
			System.out.println();
		
			switch(choice) {
				case 1: studentMethods.addStudent();
						break;
						
				case 2: studentMethods.updateStudent();
					break;
					
				case 3: studentMethods.deleteStudent();
					break;
			
				case 4: studentMethods.addMarks();
					break;
					
				case 5: studentMethods.updateMarks();
					break;
				
				case 6: studentMethods.veiwAll();
					break;
		
				case 0: break;
			
				default: System.out.println("Invalid Choice");
			}
		}while(choice!=0);
	}
	
	public void teacherManagement() {
		int choice;
		
		do {
			System.out.println("1. Add Teacher");
			System.out.println("2. Update Teacher");
			System.out.println("3. Delete Teacher");
			System.out.println("4. View all Teachers");
			System.out.println("0. Go Back");
			System.out.print("Enter your choice: ");
			choice=sc.nextInt();
			System.out.println();
			
			switch(choice) {
				case 1: teacherMethods.addTeacher();
					System.out.println("Teacher added");
					break;

				case 2: teacherMethods.updateTeacher();
					break;
					
				case 3: teacherMethods.deleteTeacher();
					break;
			
				case 4: teacherMethods.veiwAll();
					break;
		
				case 0: break;
				
				default: System.out.println("Invalid Choice");
			}
		}while(choice!=0);
	}
	
	public void subjectManagement() {
		int choice;
		do {
			System.out.println("1. Add Subject");
			System.out.println("2. Delete Subject");
			System.out.println("3. View all Subjects");
			System.out.println("0. Go Back");
			System.out.print("Enter your choice: ");
			choice=sc.nextInt();
			System.out.println();
		
			switch(choice) {
				case 1: subjectMethods.addSubject();
					break;
					
				case 2: subjectMethods.deleteSubject();
					break;
			
				case 3: subjectMethods.veiwAll();
					break;
		
				case 0: break;
			
				default: System.out.println("Invalid Choice");
			}
		}while(choice!=0);	
	}
}
