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
        System.out.println("Enter Student ID: ");
        input.nextLine();
        String sid = input.nextLine().toUpperCase();
        System.out.println("Enter Student First Name: ");
        String FName = input.nextLine().toUpperCase();
        System.out.println("Enter Student Father Name: ");
        String MName = input.nextLine().toUpperCase();
        System.out.println("Enter Student Grandfather Name");
        String LName = input.nextLine().toUpperCase();
        students[noOfStudents] = new Student(Did, sid, FName, MName, LName);
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
    public void updateStudentGrade() {
        input.nextLine();
        System.out.println("Enter Student ID:");
        String value = input.nextLine().toUpperCase();
        int si = studentLocation(value);//stands for student Index
        if (si == -1) {
            System.out.println("Student does not exist!!!");
            return;
        }
        System.out.println("Course Stack of Student " + students[si].FName);
        System.out.println("Id\tName\tCredit Hour\t Contact Hour\t Current Grade");
        for(int i = 0; i<students[si].noOfCoursesTaken; i++){
            System.out.println(
                    students[si].coursesTaken[i].CID + "\t" + students[si].coursesTaken[i].CName + "\t" +
                    students[si].coursesTaken[i].CreditHr + "\t" + students[si].coursesTaken[i].ContactHr + "\t" +
                    students[si].coursesTaken[i].GradeLetter
            );
        }
        System.out.println("Enter course ID: ");
        value = input.nextLine().trim().toUpperCase();
        int cl = courseLocation(value, students[si].SDID);
        if (cl == -1) {
            System.out.println("Course does not exist for this student!!!");
            return;
        }
        System.out.println("Enter grade for course: ");
        value = input.nextLine().trim().toUpperCase();
        ArrayList<String> possibleGrades = new ArrayList<>(
                Arrays.asList("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"));
        if (!possibleGrades.contains(value)) {//checks if it's a valid input
            System.out.println("Incorrect Input!!!");
            return;
        }
        //the line below adds specific grades for the student at student index
        // for the course taken at cl
        students[si].coursesTaken[cl].GradeLetter = value;
        System.out.println("Added grade successfully!!!");
    }

    public void updateStudent() {
        input.nextLine();
        System.out.println("Enter Student ID:");
        String Sid = input.nextLine().toUpperCase();
        int location = studentLocation(Sid);
        if (location == -1) {
            System.out.println("Student Does not exist!!!");
            return;
        }
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

    public void displayStudent() {
        if (noOfStudents == 0) {
            System.out.println("No Records Available");
            return;
        }
        System.out.println("Here is the list of all Students");
        int i = 0;
        while (i < noOfStudents) {
            System.out.println(students[i].SID.trim() + "\t" + students[i].FName.trim() + "\t" + students[i].MName.trim()
                    + "\t" + students[i].LName.trim() + "\t" + students[i].SDID);
            i++;
        }
        stopOrContinue();
    }

    public void deleteStudentForm() {
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        input.nextLine();
        System.out.println("Enter a student ID:");
        String SID = input.nextLine();
        int location = studentLocation(SID);
        if (location == -1) {
            System.out.println("Student with ID \"" + SID + "\" doesn't exist.");
            return;
        }
        deleteStudent(location);
        stopOrContinue();
    }
    public void deleteStudent(int si) {
        String id = students[si].SID;
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        for (int i = si; i < noOfStudents-1; i++) {//ma-she-ga-sheg
            students[i] = students[i+1];
        }
        noOfStudents--;
        System.out.println("Student \"" + id + "\" successfully Deleted");
    }
}
