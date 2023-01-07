package Trident;

public class Department {
    private final String DID;
    private final int AccYear;
    private final String DName;
    private static int noOfDepartments = 0;//moved here from curriculum
    public String getDID() {
        return DID;
    }
    public int getAccYear() {
        return AccYear;
    }
    public String getDName() {
        return DName;
    }
    public static int getNoOfDepartments() {
        return noOfDepartments;
    }
    public static void setNoOfDepartments(int no) {
        noOfDepartments = no;
    }

    public Department(String DID, int AccYear, String DName){
        this.DID = DID;
        this.AccYear = AccYear;
        this.DName = DName;
    }
}
