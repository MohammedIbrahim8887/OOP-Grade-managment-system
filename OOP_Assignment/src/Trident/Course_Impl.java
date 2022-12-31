package Trident;


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
            while (i < noOfCourses) {
                System.out.println("Course ID: " + courses[i].CID.trim() + "\t " +
                        "Course Name: " + courses[i].CName + "\t " +
                        "Credit hour: " + courses[i].CreditHr + "\t " +
                        "Contact hour " + courses[i].ContactHr + "\t" +
                        "Lab hour: " + courses[i].LabHr + "\t" +
                        "Lecture hour: " + courses[i].LectureHr);
                i++;
            }
            stopOrContinue();
        }
    }
    public void deleteCourse() {
        // this function shifts all the items after the deleted index to the left and decreases the noOfDep by 1
        input.nextLine();
        System.out.println("Enter a Course ID:");
        String CID = input.nextLine();
        int location = courseLocation(CID);
        if (location == -1){
            System.out.println("Course with ID \""+ CID +"\" doesn't exist.");
            return;
        }
        else{

            for(int i=0;i<noOfStudents;i++){
                int did = courses[i].getDID();
                int location1 = courseLocation(CID,did);
                if(location1 != -1){
                    System.out.println("Hello world");
                    for(int j=location1;j<noOfCourses;j++){
                        students[i].coursesTaken[location1] = students[i].coursesTaken[location1+1];
                        courses[location1] = courses[location1 + 1];
                        location++;
                        noOfCourses--;
                        students[i].noOfCoursesTaken--;
                    }
                }
            }
        }

    }


}
