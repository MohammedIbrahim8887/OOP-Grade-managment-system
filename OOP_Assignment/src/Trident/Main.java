package Trident;

import static Trident.Curriculum.*;
//TODO: make private
public class Main {
    // read class curriculum after this to understand the main logic of the code
    public static void main(String[] args) {
        int menuChoice;
        System.out.println("\t\t\t* * * * * * * * * * * * * * *");
        System.out.println("\t\t\tWelcome to HEUC Student Management System");
        System.out.println("\t\t\t* * * * * * * * * * * * * * *");
        do{
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Display");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.println("\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("Enter your choice");
            menuChoice = input.nextInt();
            switch (menuChoice) {
                case 1 : addMenu();
                         break;
                case 2 : updateMenu();
                         break;
                case 3 : displayMenu();
                         break;
                case 4 : deleteMenu();
                         break;
                case 5 : System.exit(0);
                         break;
                default: System.out.println("Enter a valid choice");
                         break;
            }
        } while(true);
    }
    public static void addMenu(){
        int choiceAdd;
        do {
            System.out.println("1. Add Department");
            System.out.println("2. Add Course");
            System.out.println("3. Add Student");
            System.out.println("4. Add Grade");
            System.out.println("\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("Enter your choice");
            choiceAdd = input.nextInt();
            switch (choiceAdd) {
                case 1 : departmentAccess.addDep();
                         break;

                case 2 : courseAccess.addCourse();
                         break;

                case 3 : studentAccess.addStudent();
                         break;

                case 4 : studentAccess.updateStudentGrade();
                         break;

                default : System.out.println("Enter a valid choice");
                         break;
            }
        } while (choiceAdd > 4);
    }
    public static void updateMenu() {
        int choiceUpdate;
        do{
            System.out.println("1. Update Student Grade");
            System.out.println("2. Update Course Info");
            System.out.println("3. Update Student Personal Info");
            System.out.println("\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("Enter your choice");
            choiceUpdate = input.nextInt();
            switch (choiceUpdate) {
                case 1:
                    studentAccess.updateStudentGrade();
                    return;
                case 2:
                    courseAccess.updateCourse();
                    return;
                case 3:
                    studentAccess.updateStudent();
                    return;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        } while(true);

    }
    public static void displayMenu() {
        int choiceDisplay;
        do{
            System.out.println("1. Display All Departments");
            System.out.println("2. Display Course List");
            System.out.println("3. Display Student List");
            System.out.println("4. Display Student Info");
            System.out.println("\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("Enter your choice");
            choiceDisplay = input.nextInt();
            switch (choiceDisplay) {
                case 1 : departmentAccess.displayDep();
                         break;
                case 2 : courseAccess.displayCourse();
                         break;
                case 3 : studentAccess.displayStudent();
                         break;
                case 4 : studentAccess.calculateGPA();
                        break;
                default : System.out.println("Enter a valid choice");
                         break;
            }
        }while(choiceDisplay>4);
    }
    public static void deleteMenu(){
        int choiceDelete;
        do {
            System.out.print("\033[H\033[2J");
            System.out.println("1. Delete Department");
            System.out.println("2. Delete Course");
            System.out.println("3. Delete Student");
            System.out.println("\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("Enter your choice");
            choiceDelete = input.nextInt();
            switch (choiceDelete) {
                case 1 : departmentAccess.deleteDep();
                         break;

                case 2 : courseAccess.deleteCourseForm();
                         break;

                case 3 : studentAccess.deleteStudentForm();
                         break;

                default :
                    System.out.println("Enter a valid choice");

            }
        }while(choiceDelete>3);
    }
}
