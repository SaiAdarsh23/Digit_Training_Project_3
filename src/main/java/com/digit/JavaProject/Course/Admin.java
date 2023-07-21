package com.digit.JavaProject.Course;

import java.util.Scanner;

public class Admin {
	
	Scanner sc = new Scanner(System.in);
	Course c = new Course();
	Professor p = new Professor();
	Student s = new Student();
	
	boolean login(String username, String password) {
		String uname = "Admin";
		String pword = "Welcome@123";
		if(uname.equals(username) && pword.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void AddCourse() {
		System.out.println("Enter number of courses :");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter Course "+(i+1));
			String course = sc.next();
			c.c.add(course);
			c.cid.add("C"+(i+1));
		}
		System.out.print("Courses IDs:");
		System.out.println(c.cid);
		System.out.print("Courses :");
		System.out.println(c.c);
	}
	
	void AddProf() {
		System.out.println("Enter number of professors :");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter Professor "+(i+1));
			String prof = sc.next();
			p.p.add(prof);
			p.pid.add("P"+(i+1));
			System.out.println("Select course name from the following :");
			System.out.println(c.c);
			String course = sc.next();
			p.teach.add(course);
		}
		System.out.print("Professors IDs:");
		System.out.println(p.pid);
		System.out.print("Professors :");
		System.out.println(p.p);
		System.out.print("Selected course :");
		System.out.println(p.teach);
	}
	
	void AddStud() {
		System.out.println("Enter number of students :");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter Student "+(i+1));
			String stu = sc.next();
			s.s.add(stu);
			s.sid.add("S"+(i+1));
			System.out.println("Select course name from the following :");
			System.out.println(c.c);
			String course = sc.next();
			s.selectedcourse.add(course);
		}
		System.out.print("Students IDs:");
		System.out.println(s.sid);
		System.out.print("Students :");
		System.out.println(s.s);
		System.out.print("Selected course :");
		System.out.println(s.selectedcourse);
	}
	
}
