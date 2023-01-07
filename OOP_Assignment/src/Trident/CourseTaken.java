package Trident;

public class CourseTaken extends Course {
    private String GradeLetter;

    public String getGradeLetter() {
        return GradeLetter;
    }
    public void setGradeLetter(String gradeLetter) {
        GradeLetter = gradeLetter;
    }

    public CourseTaken(Course C, String gL) {
        super(C.getCID(), C.getCreditHr(), C.getContactHr(), C.getLabHr(), C.getLectureHr(), C.getCName(), C.getDID());
        GradeLetter = gL;
    }
    public CourseTaken(Course C){
        super(C.getCID(), C.getCreditHr(), C.getContactHr(), C.getLabHr(), C.getLectureHr(), C.getCName(), C.getDID());
        GradeLetter = "F";
    }
}
