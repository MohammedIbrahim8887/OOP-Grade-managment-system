package Trident;


import static Trident.Curriculum.*;

public class Department_Impl extends BasicFunctions {//extended to use all the basic functions that are common to all impls
    public void addDep() {
        System.out.println("Enter number of departments");
        int num = input.nextInt() + noOfDepartments;
        String name;
        int Did,year;
        //the loop starts at the noOf departments
        //if this is the first entry i = 0
        for (int i = noOfDepartments; i<num; i++){
            System.out.println("\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("\t \t \t Details for Department " + (i + 1));
            System.out.println("\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("Enter Department Name: ");
            input.nextLine();
            name = input.nextLine();
            System.out.println("Enter Department ID: ");
            Did = input.nextInt();
            if (departmentLocation(Did) != -1){
                System.out.println("Department already exists!!!!");
                return;
            }
            System.out.println("Enter Accreditation Year: ");
            year = input.nextInt();
            departments[noOfDepartments] = new Department(Did,year,name);
            //after inputting all te data for the first department departments[0]
            noOfDepartments++;
            //it will increase the noOfDepartments by one so that the next entry will
            // be inputted into  departments[1] ,,, and so on
            // the same logic applies to all the other add functions like addCourse(), addStudent,
            // addGrade is almost the same as well
        }
    }
    public void displayDep(){
        if (noOfDepartments == 0) {
            System.out.println("No Records Available");
        }
        else {
            System.out.println("Here is the list of all Departments");
            int i = 0;
            while (i < noOfDepartments) {
                System.out.println(departments[i].DName + "\t" +
                        departments[i].DID + "\t" + departments[i].AccYear);
                i++;
            }
            stopOrContinue();
        }
    }
    public void deleteDep(){
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        System.out.println("Enter a department ID:");
        int ID = input.nextInt();
        int location = departmentLocation(ID);;
        if (location == -1){
            System.out.println("Department with ID \""+ID+"\" doesn't exist.");
            return;
        }
        else{
            for(int i = location; i< noOfDepartments -1; i++) {//ma-she-ga-sheg
                if(students[i].getSDID() == ID){
                    students[i].SID = null;
                    noOfStudents--;
                }
                if(courses[i].getDID() == ID){
                    courses[i].DID = 0;
                    noOfCourses--;
                }
                departments[i]= departments[i+1];
            }

            noOfDepartments--;
            System.out.println("Department Successfully Deleted");
        }

        stopOrContinue();
    }
}
