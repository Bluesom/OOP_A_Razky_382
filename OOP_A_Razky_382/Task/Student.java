import java.util.Scanner;

public class Student extends User {

    public Student(String name, String studentID) {
        super(name, studentID);
    }

    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String inputName = scanner.nextLine();
        System.out.print("Enter your Student ID: ");
        String inputID = scanner.nextLine();

        return getName().equalsIgnoreCase(inputName) && getStudentID().equals(inputID);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Login Successful!\n");
        super.displayInfo();
    }
}
