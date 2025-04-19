import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("admin123", "password123");
        Student student = new Student("Razky", "202410370110382");

        while (true) {
            System.out.println("\n=== Login Menu ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                if (!admin.login()) {
                    System.out.println("Admin login failed. Try again.");
                }
            } else if (choice == 2) {
                if (!student.login()) {
                    System.out.println("Student login failed. Try again.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1-3.");
            }
        }

        scanner.close();
    }
}
