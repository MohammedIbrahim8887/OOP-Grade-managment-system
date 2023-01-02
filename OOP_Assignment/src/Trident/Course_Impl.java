package Trident;


import java.util.Objects;

import static Trident.Curriculum.*;

public class Course_Impl extends BasicFunctions {//extended to use all the basic functions that are common to all impls
    public void addCourse(){
        System.out.println("Enter Department ID");
        int Did = input.nextInt();
        if(departmentLocation(Did) == -1){ // calls the function below that uses a basic linear search
            System.out.println("No Such Department Exists!!!");
            return;
        }
        int location = departmentLocation(Did);
        System.out.println("You Have Selected" + " " + departments[location].DName + " " + departments[location].DID);
        System.out.println("Enter Course ID: ");
        input.nextLine();
        String cid = input.nextLine().toUpperCase();
        System.out.println("Enter Course Name");
        String cName = input.nextLine().toUpperCase();
        System.out.println("Enter Credit hour");
        int creditHr = input.nextInt();
        System.out.println("Enter Contact hour");
        int contactHr = input.nextInt();
        System.out.println("Enter Lab hour");
        int lab = input.nextInt();
        System.out.println("Enter Lecture hour");
        int lec = input.nextInt();
        if(lab + lec != contactHr){
            System.out.println("Lab hour and Lecture are not equal. Fill out everything out again :)");
            return;
        }
        courses[noOfCourses] = new Course(cid,creditHr,contactHr,lab,lec,cName,Did);
        //after inputting all te data for the first course courses[0] it will ++ by one down below
        //so that when the next entry is imputed it will be in courses[1]
        // this loop below is to update all the students in the department take the new course
        for (int i = 0; i<noOfStudents; i++){
            if (Did == students[i].SDID) {
                int noCoursesByStudent = students[i].noOfCoursesTaken;
                students[i].coursesTaken[noCoursesByStudent] = new CourseTaken(courses[noOfCourses]);
                students[i].noOfCoursesTaken++;
            }
        }
        noOfCourses++;
    }
    public void updateCourse() {
        input.nextLine();
        System.out.println("Enter course ID:");
        String Cid = input.nextLine().toUpperCase();
        int location = courseLocation(Cid);
        if(location == -1){
            System.out.println("Course not found!!!");
        }
        else{
            System.out.println("Enter Course Name:");
            String cName = input.nextLine().toUpperCase();
            courses[location].setCName(cName);
            System.out.println("Enter Credit hour:");
            int creditHr = input.nextInt();
            courses[location].setCreditHr(creditHr);
            System.out.println("Enter Contact hour:");
            int contacthr = input.nextInt();
            courses[location].setContactHr(contacthr);
            System.out.println("Enter Lecture hour:");
            int LecHr = input.nextInt();
            courses[location].setLectureHr(LecHr);
            System.out.println("Enter Lab hour:");
            int LabHr = input.nextInt();
            courses[location].setLabHr(LabHr);
            System.out.println("Details Successfully Changed");
        }

    }
    public void displayCourse(){
        if (noOfCourses == 0) {
            System.out.println("No Records Available");
        }
        else {
            System.out.println("Here is the list of all Courses");
            int i = 0;
            System.out.println(
                    "Course ID\t" + "Course Name\t" + "Credit hour\t" + "Contact hour\t" +
                    "Lab hour\t" + "Lecture hour\t" + "Department Id\t"
            );
            while (i < noOfCourses) {
                System.out.println(
                        courses[i].CID + "\t " + courses[i].CName + "\t " +
                        courses[i].CreditHr + "\t " + courses[i].ContactHr + "\t" +
                        courses[i].LabHr + "\t" + courses[i].LectureHr + "\t" + courses[i].DID
                );
                i++;
            }
            stopOrContinue();
        }
    }
    public void deleteCourseForm() {
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        input.nextLine().toUpperCase();
        System.out.println("Enter a Course ID:");
        String CID = input.nextLine();
        int location = courseLocation(CID);
        if (location == -1){
            System.out.println("Course with ID \""+ CID +"\" doesn't exist.");
            return;
        }
        deleteCourseTaken(location);
        deleteCourse(location);
        stopOrContinue();
    }
    public void deleteCourseTaken(int ci){// used for deleting course only
        System.out.println("\tlevel 1");
        for(int i=0;i<noOfStudents;i++){// iterating through the students, deleting the course taken
            System.out.println("\t\t" + i + "student");
            if (courses[ci].DID != students[i].SDID){
                //if the student is not in the same department as the course
                continue;
            }
            System.out.println("\t\t" + i + "student is in same department");
            for (int j = 0; j<students[i].noOfCoursesTaken; j++){// iterating through the course taken by the student
                System.out.println("\t\t\t" + j + "course taken");
                if (!Objects.equals(courses[ci].CID, students[i].coursesTaken[j].CID)){
                    //if the course taken is not the same the course we want to delete
                    continue;
                }
                System.out.println("\t\t\t" + j + "course taken is target");
                for (int k = j; k<students[i].noOfCoursesTaken - 1; k++){// ma-she-ga-she-g the course taken
                    students[i].coursesTaken[k] = students[i].coursesTaken[k+1];
                }
                System.out.println("\t\t\t" + j + "suffled and done");
                students[i].noOfCoursesTaken--;
                break;// if it already found and deleted the course taken
            }
        }
    }
    public void deleteCourse(int ci){// used for deleting course here and in department implementation
        String cid = courses[ci].CID;
        for (int i=ci; i<noOfCourses - 1;i++){
            courses[i] = courses[i+1];
        }
        noOfCourses--;
        System.out.println("Course with ID \""+ cid +"\" deleted.");
    }

}
