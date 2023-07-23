package com.digit.JavaProject.Course;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Professor {
	public static ArrayList pid = new ArrayList();
	public static ArrayList p = new ArrayList();
	public static ArrayList teach = new ArrayList();
	public static ArrayList sid = new ArrayList();
	public static ArrayList pdet = new ArrayList(); 
	Scanner sc = new Scanner(System.in);
	Student s = new Student();
	
	void login() {
		System.out.println();
		System.out.println("Professor Login");
		System.out.println("Enter ID : ");
		String id = sc.next();
		System.out.println("Enter Name : ");
		String name = sc.next();
		int c = 0;
		for(int i=0;i<p.size();i++) {
			if(pid.get(i).equals(id) && p.get(i).equals(name.replace("_", " "))) {
				System.out.println("Login Successful");
				if(pdet.get(i).equals(" ")) {
					System.out.println("Complete your Profile");
					pdetails(i);
				}
				else {
					c++;
				}
				System.out.println("Registered Stusents : ");
				for(int j=0;j<s.s.size();j++) {
					if(s.pid.get(j).equals(pid.get(i))) {
						System.out.println(s.s.get(j));
					}
				}
				if(c==0) {
					gradeStudent(i);
				}
			}
		}
	}
	
	void gradeStudent(int i) {
		System.out.println("Grade Stusents : ");
		for(int j=0;j<s.s.size();j++) {
			if(s.pid.get(j).equals(pid.get(i))) {
				System.out.println("Enter score for "+s.s.get(j)+" : ");
				String score = sc.next();
				s.score.set(j, score);
			}
		}
	}
	
	void pdetails(int i) {
		try {
			String pdetails = "ID         : "+pid.get(i)+"\n"+"Name       : "+p.get(i)+"\n";
			System.out.println("Enter your details : ");
			System.out.println("Age : (Integer input)");
			int age = sc.nextInt();
			pdetails = pdetails + "Age        : "+age+"\n";
			System.out.println("City : ");
			String city = sc.next();
			pdetails = pdetails + "City       : "+city.replace("_", " ")+"\n"+"Course     : "+teach.get(i);
			System.out.println("Years of Experience : (Integer input)");
			int yoe = sc.nextInt();
			pdetails = pdetails + "\nExperience : "+yoe+" years\n";
			pdet.set(i, pdetails);
			System.out.println("Your profile completed");
		}
		catch(InputMismatchException e1) {
			System.out.println("Input Mismatch. Give integer input only");
			System.exit(0);
		}
	}
}
