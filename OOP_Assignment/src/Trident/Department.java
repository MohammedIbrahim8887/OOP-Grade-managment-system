package Trident;

public class Department {

    int DID;
    int AccYear;
    String DName;
    public static int noOfDepartments = 0;//moved here from curriculum
    public int getDID() {
        return DID;
    }

    public Department(int DID, int AccYear, String DName){
        this.DID = DID;
        this.AccYear = AccYear;
        this.DName = DName;
    }
}
