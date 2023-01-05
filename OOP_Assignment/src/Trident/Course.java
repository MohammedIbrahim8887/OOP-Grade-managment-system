package Trident;

public class Course {
    String CID;
    int CreditHr;
    int ContactHr;
    int LabHr;
    int LectureHr;
    String CName;
    int DID;
    public static int noOfCourses = 0;// moved here from curriculum
    public int getDID() {
        return DID;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCName() {
        return CName;
    }

    public void setContactHr(int contactHr) {
        ContactHr = contactHr;
    }

    public int getContactHr() {
        return ContactHr;
    }

    public void setCreditHr(int creditHr) {
        CreditHr = creditHr;
    }

    public int getCreditHr() {
        return CreditHr;
    }

    public void setLabHr(int labHr) {
        LabHr = labHr;
    }

    public int getLabHr() {
        return LabHr;
    }

    public void setLectureHr(int lectureHr) {
        LectureHr = lectureHr;
    }

    public int getLectureHr() {
        return LectureHr;
    }

    public Course(String CID, int CreditHr, int ContactHr, int LabHr, int LectureHr, String CName, int DID){
        this.CID = CID;
        this.CreditHr = CreditHr;
        this.ContactHr = ContactHr;
        this.LabHr = LabHr;
        this.LectureHr = LectureHr;
        this.CName = CName;
        this.DID = DID;
    }
}
