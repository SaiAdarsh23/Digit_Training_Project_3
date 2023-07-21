package com.digit.JavaProject.Course;

import java.util.Scanner;

public class CourseRegistration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Admin admin = new Admin();
		Student s = new Student();
		System.out.println("Welcome to Course Registration");
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
			}
		}
		System.out.println("Welcome ADMIN");
		admin.AddCourse();
		admin.AddProf();
		admin.AddStud();
		s.login();
	}
}
