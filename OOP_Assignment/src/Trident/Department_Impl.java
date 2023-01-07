package Trident;


import java.util.Objects;

import static Trident.Curriculum.*;

public class Department_Impl extends BasicFunctions {//extended to use all the basic functions that are common to all impls
    public void addDep() {
        System.out.println("Enter number of departments");
        int num = input.nextInt() + Department.getNoOfDepartments();
        String name,Did;
        int year;
        //the loop starts at the noOf departments
        //if this is the first entry i = 0
        for (int i = Department.getNoOfDepartments(); i<num; i++){
            System.out.println("\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("\t \t \t Details for Department " + (i + 1));
            System.out.println("\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("Enter Department Name: ");
            input.nextLine();
            name = input.nextLine();
            System.out.println("Enter Department ID: ");
            Did = input.nextLine();
            if (departmentLocation(Did) != -1){
                System.out.println("Department already exists!!!!");
                return;
            }
            System.out.println("Enter Accreditation Year: ");
            year = input.nextInt();
            departments[Department.getNoOfDepartments()] = new Department(Did,year,name);
            //after inputting all te data for the first department departments[0]
            Department.setNoOfDepartments( Department.getNoOfDepartments() + 1 );
            //it will increase the noOfDepartments by one so that the next entry will
            // be inputted into  departments[1] ,,, and so on
            // the same logic applies to all the other add functions like addCourse(), addStudent,
            // addGrade is almost the same as well
        }
    }
    public void displayDep(){
        if (Department.getNoOfDepartments() == 0) {
            System.out.println("No Records Available");
            stopOrContinue();
            return;
        }
        System.out.println("Here is the list of all Departments");
        int i = 0;
        while (i < Department.getNoOfDepartments()) {
            System.out.println(departments[i].getDName() + "\t" +
                    departments[i].getDID() + "\t" + departments[i].getAccYear());
            i++;
        }
        stopOrContinue();
    }
    public void deleteDep(){
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        input.nextLine();
        System.out.println("Enter a department ID:");
        String DID = input.nextLine();
        int location = departmentLocation(DID);
        if (location == -1){
            System.out.println("Department with ID \""+DID+"\" doesn't exist.");
            stopOrContinue();
            return;
        }
        for (int i = 0; i < Student.getNoOfStudents(); i++) {//for deleting all students in the department
            if(Objects.equals(students[i].getSDID(), DID)){
                studentAccess.deleteStudent(i);
                i--;
            }
        }
        for (int i = 0; i < Course.getNoOfCourses(); i++) {//for deleting all courses in the department
            if(Objects.equals(courses[i].getDID(), DID)){
                courseAccess.deleteCourse(i);
                i--;
            }
        }
        for(int i = location; i< Department.getNoOfDepartments() -1; i++) {//ma-she-ga-sheg
            departments[i] = departments[i+1];
        }
        Department.setNoOfDepartments( Department.getNoOfDepartments() - 1 );
        System.out.println("Department " + DID + " Successfully Deleted");
        stopOrContinue();
    }
}
