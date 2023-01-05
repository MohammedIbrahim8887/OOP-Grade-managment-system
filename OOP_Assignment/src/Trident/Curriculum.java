package Trident;

import java.util.Scanner;

// this class is imported in all the impls
public class Curriculum {
    // these below are all the departments courses and students of the curriculum
    // they are  accessed in Imp classes by importing this class (check on the top of all imp classes)
    public static Department[] departments = new Department[10];
    public static Course[] courses = new Course[100];
    public static Student[] students = new Student[1000];

    public static Scanner input = new Scanner(System.in);

    // these below are used to access the impl classes from the main class
    // they are taken to them main class via import
    public static Course_Impl courseAccess = new Course_Impl();
    public static Department_Impl departmentAccess = new Department_Impl();
    public static Student_Impl studentAccess = new Student_Impl();

}
