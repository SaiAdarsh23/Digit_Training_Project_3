package com.digit.JavaProject.Course;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseRegistration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Admin admin = new Admin();
		Professor p = new Professor();
		Student s = new Student();
		System.out.println("Welcome to Course Registration");
		int count = 0;
		boolean login = false;
		while(login==false) {
			System.out.println("Enter Username : ");
			String uname = sc.next();
			System.out.println("Enter Password : ");
			String pword = sc.next();
			login = admin.login(uname, pword);
			if(login==false) {
				System.out.println("Wrong details.");
				System.out.println("Pease try again with correct details.");
				count++;
			}
			if(count==2 && login==false) {
				System.out.println("If you enter wrong details you will be logged out");
			}
			if(count==3 && login==false) {
				System.exit(0);
			}
		}
		System.out.println("\nWelcome ADMIN");
		System.out.println("You can start allocation");
		System.out.println("NOTE : If a name contain more than a word then use _ between words");
		admin.Allocation();
		admin.AddCourse();
		admin.AddProf();
		admin.AddStud();
		admin.Allocation();
		p.login();
		s.login();
		while(true) {
			System.out.println("\nSelect one of the options from the following : (Integer input)\n1. Admin\n2. Professor\n3. Student\n4. Exit");
			try {
				int m = sc.nextInt();
				if(m==1) {
					login = false;
					while(login==false) {
						System.out.println("Enter Username : ");
						String uname = sc.next();
						System.out.println("Enter Password : ");
						String pword = sc.next();
						login = admin.login(uname, pword);
						if(login==false) {
							System.out.println("Wrong details.");
							System.out.println("Pease try again with correct details.");
							count++;
						}
						if(count==2 && login==false) {
							System.out.println("If you enter wrong details you will be logged out");
						}
						if(count==3 && login==false) {
							System.exit(0);
						}
					}
					while(true) {
						System.out.println("\nSelect one of the options from the following : (Integer input)\n1. Add Course\n2. Add Professor\n3. Add Student\n4. Allocation\n5. All Professors \n6. All Students\n7. Course completed Students\n8. Exit");
						int n = sc.nextInt();
						if(n==1) {
							admin.AddCourse();
						}
						else if(n==2) {
							admin.AddProf();
						}
						else if(n==3) {
							admin.AddStud();
						}
						else if(n==4) {
							admin.Allocation();
						}
						else if(n==5) {
							admin.getprofessor();
						}
						else if(n==6) {
							admin.getstudent();
						}
						else if(n==7) {
							admin.details();
						}
						else if(n==8) {
							break;
						}
						else {
							System.out.println("Select option from 1 to 8 only");
						}
					}
				}
				else if(m==2) {
					p.login();
				}
				else if(m==3) {
					s.login();
				}
				else if(m==4) {
					System.out.println("Exiting....\nExit");
					System.exit(0);
				}
				else {
					System.out.println("Select option only from 1 to 4 only");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Input Mismatch. Give integer input only");
				System.exit(0);
			}
		}
	}
}
