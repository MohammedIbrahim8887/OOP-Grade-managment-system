package Trident;

public class Student {
    private final String SID;
    private String FName;
    private String MName;
    private String LName;
    private final String SDID;
    private static int noOfStudents = 0;//moved here from curriculum
    //the field bellow works the same as departments in curriculum
    private final CourseTaken[] coursesTaken = new CourseTaken[10];//every student has at most 10 courses
    private int noOfCoursesTaken;//to keep track of how many courses this student is already taking
    //add an object for course taken

    public CourseTaken[] getCoursesTaken() { // gets the courses taken by a student
        return coursesTaken;
    }
    public void setCoursesTaken(CourseTaken coursesTaken, int i) {
        this.coursesTaken[i] = coursesTaken;
    }
    public String getSID() {
        return SID;
    }
    public String getSDID() {
        return SDID;
    }
    public void setFName(String FName) { // To change a specific First name
        this.FName = FName;
    }
    public String getFName() { // To get value of a specific First name
        return FName;
    }
    public void setLName(String LName) { // To change a specific Last name
        this.LName = LName;
    }
    public String getLName() { // To get value of a specific Last name
        return LName;
    }
    public void setMName(String MName) { // To change a specific Middle name
        this.MName = MName;
    }
    public String getMName() { // To get value of a specific Middle name
        return MName;
    }
    public void setNoOfCoursesTaken(int noOfCoursesTaken) { // To change values of courses taken by a student
        this.noOfCoursesTaken = noOfCoursesTaken;
    }
    public int getNoOfCoursesTaken() {
        return noOfCoursesTaken;
    }
    public static int getNoOfStudents() {
        return noOfStudents;
    }
    public static void setNoOfStudents(int no) {
        noOfStudents = no;
    }

    public Student(String SDID, String SID, String FName, String MName, String LName){
        this.SID = SID;
        this.FName = FName;
        this.MName = MName;
        this.LName = LName;
        this.SDID = SDID;
        noOfCoursesTaken = 0;
    }

}