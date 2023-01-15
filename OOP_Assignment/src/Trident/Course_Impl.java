package Trident;


import java.util.Objects;

import static Trident.Curriculum.*;

public class Course_Impl extends BasicFunctions {//extended to use all the basic functions that are common to all impls
    public void addCourse(){
        input.nextLine();
        System.out.println("Enter Department ID");
        String Did = input.nextLine();
        if(departmentLocation(Did) == -1){ // calls the function below that uses a basic linear search
            System.out.println("No Such Department Exists!!!");
            return;
        }
        int location = departmentLocation(Did);
        System.out.println("You have Selected" + " " + departments[location].getDName() + " " + departments[location].getDID());
        System.out.println("Enter number of courses you want to add.");
        int num = input.nextInt() + Course.getNoOfCourses();
        //the loop starts at the noOf departments
        //if this is the first entry i = 0
        for (int j = Course.getNoOfCourses(); j<num; j++) {
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
            if (lab + lec != contactHr) {
                System.out.println("Lab hour and Lecture are not equal. Fill out everything out again :)");
                return;
            }
            courses[Course.getNoOfCourses()] = new Course(cid, creditHr, contactHr, lab, lec, cName, Did);
            //after inputting all the data for the first course courses[0] it will ++ by one down below
            //so that when the next entry is imputed it will be in courses[1]
            // this loop below is to update all the students in the department take the new course
            for (int i = 0; i < Student.getNoOfStudents(); i++) {
                if (Objects.equals(Did, students[i].getSDID())) {
                    int noCoursesByStudent = students[i].getNoOfCoursesTaken();
                    students[i].setCoursesTaken(new CourseTaken(courses[Course.getNoOfCourses()]), noCoursesByStudent);
                    students[i].setNoOfCoursesTaken(students[i].getNoOfCoursesTaken() + 1);
                }
            }
            Course.setNoOfCourses( Course.getNoOfCourses() + 1);
        }
    }
    public void updateCourse() {
        input.nextLine();
        System.out.println("Enter course ID:");
        String Cid = input.nextLine().toUpperCase();
        int location = courseLocation(Cid);
        if(location == -1){
            System.out.println("Course not found!!!");
            return;
        }
        System.out.println("Enter Course Name:");
        String cName = input.nextLine().toUpperCase();
        System.out.println("Enter Credit hour:");
        int creditHr = input.nextInt();
        System.out.println("Enter Contact hour:");
        int contactHr = input.nextInt();
        System.out.println("Enter Lecture hour:");
        int LecHr = input.nextInt();
        System.out.println("Enter Lab hour:");
        int LabHr = input.nextInt();
        System.out.println("Details Successfully Changed");
        courses[location] = new Course(Cid, creditHr, contactHr, LabHr, LecHr, cName, courses[location].getDID());
        changeCourseTaken(location,'u');
    }
    public void displayCourse(){
        if (Course.getNoOfCourses() == 0) {
            System.out.println("No Records Available");
        }
        else {
            System.out.println("Here is the list of all Courses");
            int i = 0;
            System.out.println(
                    "Course ID\t" + "Course Name\t" + "Credit hour\t" + "Contact hour\t" +
                    "Lab hour\t" + "Lecture hour\t" + "Department Id\t"
            );
            while (i < Course.getNoOfCourses()) {
                System.out.println(
                        courses[i].getCID() + "\t " + courses[i].getCName() + "\t " +
                        courses[i].getCreditHr() + "\t " + courses[i].getContactHr() + "\t" +
                        courses[i].getLabHr() + "\t" + courses[i].getLectureHr() + "\t" + courses[i].getDID()
                );
                i++;
            }
            stopOrContinue();
        }
    }
    public void deleteCourseForm() {
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        input.nextLine();
        System.out.println("Enter a Course ID:");
        String CID = input.nextLine().toUpperCase();
        int location = courseLocation(CID);
        if (location == -1){
            System.out.println("Course with ID \""+ CID +"\" doesn't exist.");
            return;
        }
        changeCourseTaken(location,'d');
        deleteCourse(location);
        stopOrContinue();
    }
    public void changeCourseTaken(int ci, char action){// used for updating and deleting course taken of every student
        for(int i=0;i<Student.getNoOfStudents();i++){// iterating through the students, deleting the course taken
            if (!Objects.equals(courses[ci].getDID(), students[i].getSDID())){
                //if the student is not in the same department as the course
                continue;
            }
            for (int j = 0; j<students[i].getNoOfCoursesTaken(); j++){// iterating through the course taken by the student
                if (!Objects.equals(courses[ci].getCID(), students[i].getCoursesTaken()[j].getCID())){
                    //if the course taken is not the same the course we want to delete
                    continue;
                }
                if (action == 'u')
                    updateCourseTaken(j,i,ci);
                else
                    deleteCourseTaken(j,i);
                break;// if it already found and deleted the course taken
            }
        }
    }
    public void updateCourseTaken(int cti, int si, int ci){// used for updating course only
        CourseTaken ct =new CourseTaken(courses[ci], students[si].getCoursesTaken()[cti].getGradeLetter());
        students[si].setCoursesTaken(ct,cti);
    }
    public void deleteCourseTaken(int cti, int si){
        for (int k = cti; k < students[si].getNoOfCoursesTaken() - 1; k++){// ma-she-ga-she-g the course taken
            students[si].setCoursesTaken(students[si].getCoursesTaken()[k+1],k);
        }
        students[si].setNoOfCoursesTaken(students[si].getNoOfCoursesTaken() - 1 );
    }
    public void deleteCourse(int ci){// used for deleting course here and in department implementation
        String cid = courses[ci].getCID();
        for (int i=ci; i<Course.getNoOfCourses() - 1;i++){
            courses[i] = courses[i+1];
        }
        Course.setNoOfCourses(Course.getNoOfCourses() - 1);
        System.out.println("Course with ID \""+ cid +"\" deleted.");
    }

}
