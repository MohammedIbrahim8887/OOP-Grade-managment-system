package Trident;

public class Course {
    private final String CID;
    private final int CreditHr;
    private final int ContactHr;
    private final int LabHr;
    private final int LectureHr;
    private final String CName;
    private final String DID;
    private static int noOfCourses = 0;// moved here from curriculum

    public String getCID() {
        return CID;
    }
    public String getDID() {
        return DID;
    }
    public String getCName() {
        return CName;
    }
    public int getContactHr() {
        return ContactHr;
    }
    public int getCreditHr() {
        return CreditHr;
    }
    public int getLabHr() {
        return LabHr;
    }
    public int getLectureHr() {
        return LectureHr;
    }
    public static int getNoOfCourses() {
        return noOfCourses;
    }
    public static void setNoOfCourses(int noOfCourses) {
        Course.noOfCourses = noOfCourses;
    }

    public Course(String CID, int CreditHr, int ContactHr, int LabHr, int LectureHr, String CName, String DID){
        this.CID = CID;
        this.CreditHr = CreditHr;
        this.ContactHr = ContactHr;
        this.LabHr = LabHr;
        this.LectureHr = LectureHr;
        this.CName = CName;
        this.DID = DID;
    }
}
