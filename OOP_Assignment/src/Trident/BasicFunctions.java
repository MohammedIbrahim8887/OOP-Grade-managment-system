package Trident;

import java.util.Objects;

import static Trident.Curriculum.*;

public class BasicFunctions {// has common search functions used by impl classes
    public int departmentLocation(String id){// basic linear search that returns -1 if id ain't found
        for (int j = 0; j < Department.getNoOfDepartments(); j++){
            if (Objects.equals(id, departments[j].getDID())){
                return j;
            }
        }
        return -1;
    }
    public int studentLocation(String id){//same as the above
        for (int j = 0; j < Student.getNoOfStudents(); j++){
            if (id.equals(students[j].getSID())){ // == wasn't working so I used equals
                return j;
            }
        }
        return -1;
    }
    public int courseLocation(String id){
        //looks for course
        for (int j = 0; j < Course.getNoOfCourses(); j++){
            if (id.equals(courses[j].getCID())){//if the student is in the same department as the course
                return j;
            }
        }
        return -1;
    }
    public int courseLocation(String id, String Sdid){
        //same as the above two but only looks for courses that are in the same department as the student
        for (int j = 0; j < Course.getNoOfCourses(); j++){
            if (id.equals(courses[j].getCID()) && courses[j].getDID().equals(Sdid)){//if the student is in the same department as the course
                return j;
            }
        }
        return -1;
    }
    public void stopOrContinue() {// do we really need this
        input.nextLine();
        System.out.println("Do you want to continue.(Y/N)");
        if (input.nextLine().equals("N")) {
            System.exit(0);
        }
    }
}
