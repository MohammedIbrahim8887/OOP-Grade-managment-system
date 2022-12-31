package Trident;

public class Department {
    int DID;
    int AccYear;
    String DName;

    public int getDID() {
        return DID;
    }

    public Department(int DID, int AccYear, String DName){
        this.DID = DID;
        this.AccYear = AccYear;
        this.DName = DName;
    }
}
