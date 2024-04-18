package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MainMethods mainmethods=new MainMethods();
		Scanner sc=new Scanner(System.in);
		int choice;
		
		do {
			System.out.println();
			System.out.println("*** ** * SCHOOL MANAGEMENT SYSTEM * ** ***");
			System.out.println("1.Student Management");
			System.out.println("2.Teacher Management");
			System.out.println("3.Subject Management");
			System.out.println("0.EXIT");
			System.out.print("Enter your choice: ");
			choice=sc.nextInt();
			System.out.println();
		
			switch(choice) {
		
			case 1: mainmethods.studentManagement();
					break;
		
			case 2: mainmethods.teacherManagement();
					break;
			
			case 3: mainmethods.subjectManagement();
					break;
			
			case 0: break;
		
			default: System.out.println("Invalid Choice");
			}
		}while(choice!=0);
		sc.close();
	}

}
