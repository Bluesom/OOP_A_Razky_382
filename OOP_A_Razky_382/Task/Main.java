import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin();
        Student student = new Student();

        System.out.println("Choose Login:");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.print("Enter your choice (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1) {
            admin.loginAdmin();
        } else if(choice == 2){
            student.loginStudent();
        } else {
            System.out.println("Please enter 1 or 2");
        }

        scanner.close();
    }
}