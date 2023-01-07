package Trident;

import java.util.*;

import static Trident.Curriculum.*;

public class Student_Impl extends BasicFunctions {//extended to use all the basic functions that are common to all impls

    public void addStudent() {
        input.nextLine();
        System.out.println("Enter Student Department Id");
        String Did = input.nextLine();
        //glitch here for some reason
        //makes you inter student department Id twice
        if (departmentLocation(Did) == -1) {//changed this by removing the old depExists function
            System.out.println("No such Departments exist!!");
            return;
        }
        int location = departmentLocation(Did);
        System.out.println("You Have Selected" + " " + departments[location].getDName() + " " + departments[location].getDID());
        System.out.println("Enter number of students you want to Add.");
        int num = input.nextInt() + Student.getNoOfStudents();
        input.nextLine();
        //the loop starts at the noOfStudents
        //if this is the first entry i = 0
        for (int j = Student.getNoOfStudents(); j<num; j++) {

            System.out.println("Enter Student ID: ");
            String sid = input.nextLine().toUpperCase();
            System.out.println("Enter Student First Name: ");
            String FName = input.nextLine().toUpperCase();
            System.out.println("Enter Student Father Name: ");
            String MName = input.nextLine().toUpperCase();
            System.out.println("Enter Student Grandfather Name");
            String LName = input.nextLine().toUpperCase();
            students[Student.getNoOfStudents()] = new Student(Did, sid, FName, MName, LName);
            //after inputting all te data for the first course courses[0] it will ++ by one down below
            //so that when the next entry is imputed it will be in courses[1]
            // this loop below is to add all the courses in the student's department to course taken
            for (int i = 0; i < Course.getNoOfCourses(); i++) {
                if (Objects.equals(Did, courses[i].getDID())) {
                    int noCoursesByStudent = students[Student.getNoOfStudents()].getNoOfCoursesTaken();
                    // check class student to understand this more
                    students[Student.getNoOfStudents()].setCoursesTaken(new CourseTaken(courses[i]), noCoursesByStudent);
                    students[Student.getNoOfStudents()].setNoOfCoursesTaken(
                            students[Student.getNoOfStudents()].getNoOfCoursesTaken() + 1
                    );
                }
            }
            Student.setNoOfStudents(Student.getNoOfStudents() + 1);
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
        System.out.println("Course Stack of Student " + students[si].getFName());
        System.out.println("Id\tName\tCredit Hour\t Contact Hour\t Current Grade");
        for(int i = 0; i<students[si].getNoOfCoursesTaken(); i++){
            System.out.println(
                    students[si].getCoursesTaken()[i].getCID() + "\t" + students[si].getCoursesTaken()[i].getCName() + "\t" +
                    students[si].getCoursesTaken()[i].getCreditHr() + "\t" + students[si].getCoursesTaken()[i].getContactHr() + "\t" +
                    students[si].getCoursesTaken()[i].getGradeLetter()
            );
        }
        System.out.println("Enter course ID: ");
        value = input.nextLine().trim().toUpperCase();
        int cl = courseLocation(value, students[si].getSDID());
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
        students[si].getCoursesTaken()[cl].setGradeLetter(value);
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
        if (Student.getNoOfStudents() == 0) {
            System.out.println("No Records Available");
            return;
        }
        System.out.println("Here is the list of all Students");
        int i = 0;
        while (i < Student.getNoOfStudents()) {
            System.out.println(
                    students[i].getSID() + "\t" + students[i].getFName() + "\t" + students[i].getMName().trim()
                    + "\t" + students[i].getLName() + "\t" + students[i].getSDID()
            );
            i++;
        }
        stopOrContinue();
    }

    public void deleteStudentForm() {
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        input.nextLine();
        System.out.println("Enter a student ID:");
        String SID = input.nextLine().toUpperCase();
        int location = studentLocation(SID);
        if (location == -1) {
            System.out.println("Student with ID \"" + SID + "\" doesn't exist.");
            return;
        }
        deleteStudent(location);
        stopOrContinue();
    }
    public void deleteStudent(int si) {
        String id = students[si].getSID();
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        for (int i = si; i < Student.getNoOfStudents()-1; i++) {//ma-she-ga-sheg
            students[i] = students[i+1];
        }
        Student.setNoOfStudents(Student.getNoOfStudents() - 1);
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
        System.out.println(
                "Name: " + students[location].getFName() +" "
                + students[location].getMName() +" "+ students[location].getLName()
        );
        System.out.println("ID: " + students[location].getSID());
        System.out.println("Department: " + students[location].getSDID());
        System.out.println("Number of course taken by student: " + students[location].getNoOfCoursesTaken());
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
        for(int i = 0; i < students[location].getNoOfCoursesTaken(); i++){//a loop for summing up all the individual course gpa
            System.out.println(
                    students[location].getCoursesTaken()[i].getCName() + "\t" + students[location].getCoursesTaken()[i].getCID() + "\t" +
                    students[location].getCoursesTaken()[i].getCreditHr() + "\t" + students[location].getCoursesTaken()[i].getGradeLetter()
            );
            totalCreditHr += students[location].getCoursesTaken()[i].getCreditHr();
            double grade = gradeToGpaMap.get(students[location].getCoursesTaken()[i].getGradeLetter());
            gpa += grade * students[location].getCoursesTaken()[i].getCreditHr();
        }
        gpa /= totalCreditHr;
        System.out.println("The Gpa of this student is: " + gpa);
        stopOrContinue();
    }
}
