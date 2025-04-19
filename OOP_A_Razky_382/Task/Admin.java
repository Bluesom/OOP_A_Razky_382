import java.util.Scanner;

public class Admin extends User {
    private String username;
    private String password;

    public Admin(String username, String password) {
        super("", "");
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter admin username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String inputPassword = scanner.nextLine();

        if (username.equals(inputUsername) && password.equals(inputPassword)) {
            displayInfo();
            showAdminMenu(scanner);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin Login Successful! Welcome back.");
    }

    private void showAdminMenu(Scanner scanner) {
        int option;
        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Change Password");
            System.out.println("2. Logout");

            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                password = newPassword;
                System.out.println("Password changed successfully!");
            } else if (option == 2) {
                System.out.println("Logging out...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        } while (option != 2);
    }
}
