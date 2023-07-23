package com.digit.JavaProject.Course;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
	Scanner sc = new Scanner(System.in);
	public static ArrayList sid = new ArrayList();
	public static ArrayList s = new ArrayList();
	public static ArrayList selectedcourse = new ArrayList();
	public static ArrayList pid = new ArrayList();
	public static ArrayList score = new ArrayList();
	public static ArrayList sdet = new ArrayList();
	
	void login() {
		System.out.println();
		System.out.println("Student Login");
		System.out.println("Enter ID : ");
		String id = sc.next();
		System.out.println("Enter Name : ");
		String name = sc.next();
		for(int i=0;i<s.size();i++) {
			if(sid.get(i).equals(id) && s.get(i).equals(name.replace("_", " "))) {
				System.out.println("Login Successful");
				if(sdet.get(i).equals(" ")) {
					System.out.println("Complete your Profile");
					sdetails(i);
				}
				getscores(i);
				getmarkscard(i);
				System.out.println("Score        : "+score.get(i)+"/100");
				if(!(score.get(i).equals("Not Graded yet."))){
					System.out.println("Course completed with "+score.get(i)+"%.");
				}
			}
		}
	}
	
	void getscores(int i) {
		System.out.println("\nScore : "+score.get(i)+"/100");
	}
	
	void getmarkscard(int i) {
		System.out.println("\nMarks card : ");
		System.out.println(sdet.get(i));
	}
	
	void sdetails(int i) {
		try {
			String pdetails = "ID           : "+sid.get(i)+"\n"+"Name         : "+s.get(i)+"\n";
			System.out.println("Enter your details : ");
			System.out.println("Age : (Integer input)");
			int age = sc.nextInt();
			pdetails = pdetails + "Age          : "+age+"\n";
			System.out.println("City : ");
			String city = sc.next();
			System.out.println("Rate your knowledg in "+selectedcourse.get(i)+" out of 10 : (Integer input)");
			int k = sc.nextInt();
			pdetails = pdetails + "City         : "+city.replace("_", " ")+"\nCourse ID    : "+Course.cid.get(i)+"\nCourse Name  : "+selectedcourse.get(i)+"\nKnowledge    : "+k+"/10\n";
			pdetails = pdetails + "Professor ID : "+Professor.pid.get(i)+"\nProfessor    : "+Professor.p.get(i);
			sdet.set(i, pdetails);
			System.out.println("Your profile completed");
		}
		catch(InputMismatchException e1) {
			System.out.println("Input Mismatch. Give integer input only");
			System.exit(0);
		}
	}
}
