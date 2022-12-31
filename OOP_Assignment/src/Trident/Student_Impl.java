package Trident;

import java.util.ArrayList;
import java.util.Arrays;

import static Trident.Curriculum.*;

public class Student_Impl extends BasicFunctions {//extended to use all the basic functions that are common to all impls

    public void addStudent() {
        System.out.println("Enter Student Department Id");
        int Did = input.nextInt();
        //glitch here for some reason
        //makes you inter student department Id twice
        if (departmentLocation(Did) == -1) {//changed this by removing the old depExists function
            System.out.println("No such Departments exist!!");
            return;
        }
        int Sdid = input.nextInt();
        System.out.println("Enter Student ID: ");
        input.nextLine();
        String sid = input.nextLine().toUpperCase();
        System.out.println("Enter Student First Name: ");
        String FName = input.nextLine().toUpperCase();
        System.out.println("Enter Student Father Name: ");
        String MName = input.nextLine().toUpperCase();
        System.out.println("Enter Student Grandfather Name");
        String LName = input.nextLine().toUpperCase();
        students[noOfStudents] = new Student(Sdid, sid, FName, MName, LName);
        //after inputting all te data for the first course courses[0] it will ++ by one down below
        //so that when the next entry is imputed it will be in courses[1]
        // this loop below is to add all the courses in the student's department to course taken
        for (int i = 0; i < noOfCourses; i++) {
            if (Did == courses[i].DID) {
                int noCoursesByStudent = students[noOfStudents].noOfCoursesTaken;
                // check class student to understand this more
                students[noOfStudents].coursesTaken[noCoursesByStudent] = new CourseTaken(courses[i]);
                students[noOfStudents].noOfCoursesTaken++;
            }
        }
        noOfStudents++;
    }

    public void addGrade() {
        input.nextLine();
        System.out.println("Enter Student ID:");
        String value = input.nextLine().toUpperCase();
        int studentsIndex = studentLocation(value);

        if (studentsIndex == -1) {
            System.out.println("Student does not exist!!!");
            return;
        }
        System.out.println("Enter course ID: ");
        value = input.nextLine().trim().toUpperCase();

        if (courseLocation(value, students[studentsIndex].SDID) == -1) {
            System.out.println("Course does not exist for this student!!!");
            return;
        }
        else {
            System.out.println("Enter grade for course: ");
            value = input.nextLine().trim();
            ArrayList<String> possibleGrades = new ArrayList<>(
                    Arrays.asList("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"));
            if (!possibleGrades.contains(value)) {//checks if it's a valid input
                System.out.println("Incorrect Input!!!");
                return;
            } else {
                System.out.println("Added grade successfully!!!");
            }

        }

    }

    //TODO: MAKE THE UPDATE PARTS FOR STUDENT
    public void updateStudentGrade() {

    }

    public void updateStudent() {
        input.nextLine();
        System.out.println("Enter Student ID:");
        String Sid = input.nextLine().toUpperCase();
        int location = studentLocation(Sid);
        if (location == -1) {
            System.out.println("Student Does not exist!!!");
        } else {
            System.out.println("Enter Student First Name: ");
            String value = input.nextLine().toUpperCase();
            students[location].setFName(value);
            System.out.println("Enter Student Middle Name: ");
            value = input.nextLine().toUpperCase();
            students[location].setMName(value);
            System.out.println("Enter Student Last Name: ");
            value = input.nextLine().toUpperCase();
            students[location].setLName(value);
            System.out.println("Details successfully updated");
        }
    }

    public void displayStudent() {

        if (noOfStudents == 0) {
            System.out.println("No Records Available");
        } else {
            System.out.println("Here is the list of all Students");
            int i = 0;
            while (i < noOfStudents) {
                System.out.println(students[i].SID.trim() + "\t" + students[i].FName.trim() + "\t" + students[i].MName.trim() + "\t"
                        + students[i].LName.trim() + "\t" + students[i].SDID);
                i++;
            }
            stopOrContinue();
        }
    }

    public void deleteStudent() {
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        input.nextLine();
        System.out.println("Enter a student ID:");
        String SID = input.nextLine();
        int location = studentLocation(SID);
        if (location == -1) {
            System.out.println("Student with ID \"" + SID + "\" doesn't exist.");
            return;
        }
        for (int i = location; i < noOfStudents - 1; i++) {//ma-she-ga-sheg
            students[i] = students[i + 1];
        }
        noOfStudents--;
        System.out.println("Student successfully Deleted");
        stopOrContinue();
    }
}
