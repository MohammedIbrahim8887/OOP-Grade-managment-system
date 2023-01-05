package Trident;

import static Trident.Curriculum.*;

public class BasicFunctions {// has common search functions used by impl classes
    public int departmentLocation(int id){// basic linear search that returns -1 if id ain't found
        for (int j = 0; j < Department.noOfDepartments; j++){
            if (id == departments[j].DID){
                return j;
            }
        }
        return -1;
    }
    public int studentLocation(String id){//same as the above
        for (int j = 0; j < Student.noOfStudents; j++){
            if (id.equals(students[j].SID)){ // == wasn't working so I used equals
                return j;
            }
        }
        return -1;
    }
    public int courseLocation(String id){
        //looks for course
        for (int j = 0; j < Course.noOfCourses; j++){
            if (id.equals(courses[j].CID)){//if the student is in the same department as the course
                return j;
            }
        }
        return -1;
    }
    public int courseLocation(String id, int Sdid){
        //same as the above two but only looks for courses that are in the same department as the student
        for (int j = 0; j < Course.noOfCourses; j++){
            if (id.equals(courses[j].CID) && courses[j].DID == Sdid){//if the student is in the same department as the course
                return j;
            }
        }
        return -1;
    }
    public void stopOrContinue(){// do we really need this
        do{
            System.out.println("Would you like to go back to the main menu? (Y/N)");
            input.nextLine();//Needed for some reason
            String choice = input.nextLine().toUpperCase();
            switch (choice) {
                case "Y" : {
                    return;
                }
                case "N" : System.exit(0);
                           break;
                default : System.out.println("Enter a valid choice");
                          break;
            }
        }while (true);
    }
}
