package Trident;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        int location = departmentLocation(Did);
        System.out.println("You Have Selected" + " " + departments[location].DName + " " + departments[location].DID);
        System.out.println("Enter number of courses you want to Add.");
        int num = input.nextInt() + Student.noOfStudents;
        //the loop starts at the noOf departments
        //if this is the first entry i = 0
        for (int j = Student.noOfStudents; j<num; j++) {
            input.nextLine();
            System.out.println("Enter Student ID: ");
            String sid = input.nextLine().toUpperCase();
            System.out.println("Enter Student First Name: ");
            String FName = input.nextLine().toUpperCase();
            System.out.println("Enter Student Father Name: ");
            String MName = input.nextLine().toUpperCase();
            System.out.println("Enter Student Grandfather Name");
            String LName = input.nextLine().toUpperCase();
            students[Student.noOfStudents] = new Student(Did, sid, FName, MName, LName);
            //after inputting all te data for the first course courses[0] it will ++ by one down below
            //so that when the next entry is imputed it will be in courses[1]
            // this loop below is to add all the courses in the student's department to course taken
            for (int i = 0; i < Course.noOfCourses; i++) {
                if (Did == courses[i].DID) {
                    int noCoursesByStudent = students[Student.noOfStudents].noOfCoursesTaken;
                    // check class student to understand this more
                    students[Student.noOfStudents].coursesTaken[noCoursesByStudent] = new CourseTaken(courses[i]);
                    students[Student.noOfStudents].noOfCoursesTaken++;
                }
            }
            Student.noOfStudents++;
        }
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
        if (Student.noOfStudents == 0) {
            System.out.println("No Records Available");
            return;
        }
        System.out.println("Here is the list of all Students");
        int i = 0;
        while (i < Student.noOfStudents) {
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
        for (int i = si; i < Student.noOfStudents-1; i++) {//ma-she-ga-sheg
            students[i] = students[i+1];
        }
        Student.noOfStudents--;
        System.out.println("Student \"" + id + "\" successfully Deleted");
    }
    public void calculateGPA() {
        input.nextLine();
        System.out.println("Enter a student ID:");
        String SID = input.nextLine().toUpperCase();
        int location = studentLocation(SID);
        if (location == -1) {
            System.out.println("Student with ID \"" + SID + "\" doesn't exist.");
            return;
        }
        System.out.println("Name: " + students[location].FName +" "+ students[location].MName +" "+ students[location].LName);
        System.out.println("ID: " + students[location].SDID);
        System.out.println("Department: " + students[location].SDID);
        System.out.println("Number of course taken by student: " + students[location].noOfCoursesTaken);
        System.out.println("Course Information");
        System.out.println("Name\tID\tCredit Hour\tGrade");
        Map<String, Double> gradeToGpaMap = new HashMap<>();
        gradeToGpaMap.put("A+", 4.0);
        gradeToGpaMap.put("A", 4.0);
        gradeToGpaMap.put("A-", 3.75);
        gradeToGpaMap.put("B+", 3.5);
        gradeToGpaMap.put("B", 3.25);
        gradeToGpaMap.put("B-", 3.0);
        gradeToGpaMap.put("C+", 2.75);
        gradeToGpaMap.put("C", 2.5);
        gradeToGpaMap.put("C-", 2.0);
        gradeToGpaMap.put("D", 1.0);
        gradeToGpaMap.put("F", 0.0);
        double gpa = 0;
        double totalCreditHr = 0;
        for(int i = 0; i < students[location].noOfCoursesTaken; i++){
            System.out.println(
                    students[location].coursesTaken[i].CName + "\t" + students[location].coursesTaken[i].CID + "\t" +
                    students[location].coursesTaken[i].CreditHr + "\t" + students[location].coursesTaken[i].GradeLetter
            );
            totalCreditHr += students[location].coursesTaken[i].CreditHr;
            gpa += gradeToGpaMap.get(students[location].coursesTaken[i].GradeLetter) * students[location].coursesTaken[i].CreditHr;
        }
        gpa /= totalCreditHr;
        System.out.println("The Gpa of this student is: " + gpa);
        stopOrContinue();
    }
}
