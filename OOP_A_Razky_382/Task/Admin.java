import java.util.Scanner;

public class Admin {
    String username, password;
    Scanner scanner = new Scanner(System.in);

    public void loginAdmin() {
        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        if(password.equals("password123") && username.equals("admin123")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }
}