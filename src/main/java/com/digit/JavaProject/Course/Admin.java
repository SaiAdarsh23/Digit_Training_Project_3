package com.digit.JavaProject.Course;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
	
	Scanner sc = new Scanner(System.in);
	Course c = new Course();
	Professor p = new Professor();
	Student s = new Student();
	Exceptions e = new Exceptions();
	
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
		try {
			System.out.println("Enter number of courses : (Integer input)");
			int n = sc.nextInt();
			for(int i=0;i<n;i++) {
				System.out.println("Enter Course "+(i+1));
				String course = sc.next();
				c.c.add(course.replace("_", " "));
				c.cid.add("c"+c.c.size());
			}
			System.out.print("Courses IDs:");
			System.out.println(c.cid);
			System.out.print("Courses :");
			System.out.println(c.c);
		}
		catch(InputMismatchException e1) {
			System.out.println("Input Mismatch. Give integer input only");
			System.exit(0);
		}
	}
	
	void AddProf() {
		try {
			System.out.println("Enter number of professors : (Integer input)");
			int n = sc.nextInt();
			for(int i=0;i<n;i++) {
				System.out.println("Enter Professor "+(i+1));
				p.pdet.add(" ");
				String prof = sc.next();
				p.p.add(prof.replace("_", " "));
				p.pid.add("p"+p.p.size());
				System.out.println("Select course name from the following :");
				System.out.println(c.c);
				String course = sc.next();
				try {
					if(!(c.c.contains(course.replace("_", " ")))){
						System.out.println(e.coursenotfound());
						throw e;
					}
				}
				catch (Exception e1) {
					System.out.println("If you select wrong option then you will be logged out.");
					course = sc.next();
					if (!(c.c.contains(course.replace("_", " ")))) {
						System.exit(0);
					}
				}
				p.teach.add(course.replace("_", " "));
			}
			System.out.print("Professors IDs:");
			System.out.println(p.pid);
			System.out.print("Professors :");
			System.out.println(p.p);
			System.out.print("Selected course :");
			System.out.println(p.teach);
		}
		catch(InputMismatchException e1) {
			System.out.println("Input Mismatch. Give integer input only");
			System.exit(0);
		}
	}
	
	void AddStud() {
		try {
			System.out.println("Enter number of students : (Integer input)");
			int n = sc.nextInt();
			for(int i=0;i<n;i++) {
				System.out.println("Enter Student "+(i+1));
				s.score.add("Not Graded yet.");
				s.sdet.add(" ");
				String stu = sc.next();
				s.s.add(stu.replace("_", " "));
				s.sid.add("s"+s.s.size());
				//Student course
				System.out.println("Select course name from the following :");
				System.out.println(c.c);
				String course = sc.next();
				try {
					if(!(c.c.contains(course.replace("_", " ")))){
						System.out.println(e.coursenotfound());
						throw e;
					}
				}
				catch (Exception e1) {
					System.out.println("If you select wrong option then you will be logged out.");
					course = sc.next();
					if (!(c.c.contains(course.replace("_", " ")))) {
						System.exit(0);
					}
				}
				s.selectedcourse.add(course.replace("_", " "));
				//Student professor
				System.out.println("Select professor ID from the following :");
				for(int j=0;j<p.p.size();j++) {
					if(p.teach.get(j).equals(course.replace("_", " "))) {
						System.out.println(p.pid.get(j)+"  "+p.p.get(j));
					}
				}
				String pid = sc.next();
				try {
					if(!(p.pid.contains(pid))){
						System.out.println(e.professornotfound());
						throw e;
					}
				}
				catch (Exception e1) {
					System.out.println("If you select wrong option then you will be logged out.");
					pid = sc.next();
					if (!(p.pid.contains(pid))) {
						System.exit(0);
					}
				}
				s.pid.add(pid);
			}
			System.out.print("Students IDs:");
			System.out.println(s.sid);
			System.out.print("Students :");
			System.out.println(s.s);
			System.out.print("Selected course :");
			System.out.println(s.selectedcourse);
			System.out.print("Selected professor :");
			System.out.println(s.pid);
		}
		catch(InputMismatchException e1) {
			System.out.println("Input Mismatch. Give integer input only");
			System.exit(0);
		}
	}
	
	void Allocation() {
		System.out.println();
		System.out.println("Allocation : ");
		System.out.println();
		for(int i=0;i<c.c.size();i++) {
			int pcount = 1;
			System.out.println("Course "+(i+1)+" : "+c.c.get(i));
			System.out.println();

			for(int j=0;j<p.p.size();j++) {
				if(p.teach.get(j).equals(c.c.get(i))) {
					System.out.println("Professor "+pcount+" allocated for "+c.c.get(i)+" :");
					System.out.println(p.pid.get(j)+"  "+p.p.get(j));
					
					System.out.println("Students registered under "+p.p.get(j)+" :");
					for(int k=0;k<s.s.size();k++) {
						if(s.pid.get(k).equals(p.pid.get(j))) {
							System.out.println(s.sid.get(k)+"  "+s.s.get(k));
						}
					}
					System.out.println();
					pcount++;
				}
			}
		}
	}
	
	void getprofessor() {
		for(int i=0;i<p.p.size();i++) {
			System.out.println("\nProfessor "+(i+1));
			System.out.println(p.pdet.get(i));
		}
	}
	
	void getstudent() {
		for(int i=0;i<s.s.size();i++) {
			System.out.println("\nStudent "+(i+1));
			System.out.println(s.sdet.get(i));
		}
	}
	
	void details() {
		System.out.println("\nCourse completed 100% with score 100");
		System.out.println("ID           : 6491           ID           : 0195           ID           : 0209\nName         : Adarsh         Name         : Soujanya       Name         : Yogesh\nAge          : 21             Age          : 21             Age          : 21\nCity         : Guntur         City         : Hyderabad      City         : Gurugram");
		System.out.println("Course Id    : C1             Course Id    : C1             Course Id    : C1\nCourse Name  : Java           Course Name  : Java           Course Name  : Java\nProfessor ID : Digit01        Professor ID : Digit01        Professor ID : Digit01\nProfessor    : Bheemesh       Professor    : Bheemesh       Professor    : Bheemesh");
		System.out.println("Score        : 100            Score        : 100            Score        : 100\nPoints       : 10/10          Points       : 10/10          Points : 10/10");
	}
}
