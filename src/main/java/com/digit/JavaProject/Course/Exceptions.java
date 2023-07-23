package com.digit.JavaProject.Course;

public class Exceptions extends Exception{
	public String coursenotfound() { 
		return "Please select correct course and from given options only";
	}
	public String professornotfound() { 
		return "Please select correct professor id and from given options only";
	}

}
