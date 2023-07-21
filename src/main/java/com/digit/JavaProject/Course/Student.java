package com.digit.JavaProject.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	Scanner sc = new Scanner(System.in);
	ArrayList sid = new ArrayList();
	ArrayList s = new ArrayList();
	ArrayList selectedcourse = new ArrayList();
	ArrayList score = new ArrayList();
	
	void login() {
		System.out.println("Enter ID : ");
		String id = sc.next();
		System.out.println("Enter Name : ");
		String name = sc.next();
//		System.out.println("Enter password : ");
//		String pword = sc.next();
		for(int i=0;i<s.size();i++) {
			if(sid.get(i).equals(id) && s.get(i).equals(name)) {
				System.out.println("Login Successful.");
			}
			else {
				System.out.println("Enter correct details to login");
				login();
			}
		}
	}
	
	void getscores() {
		
	}
	
	void getmarks() {
		
	}
}
