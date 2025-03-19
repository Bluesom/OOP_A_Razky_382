import java.util.Scanner;

public class Student {
    String name, nim;
    Scanner scanner = new Scanner(System.in);

    public void loginStudent() {
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.print("Enter your NIM: ");
        nim = scanner.nextLine();

        if(nim.equals("202410370110382") && name.equals("Razky")) {
            System.out.println("Login Successful");
            displayInfo();
        } else {
            System.out.println("Login Failed");
        }
    }

    public void displayInfo() {
        System.out.println("\nName: " + name);
        System.out.println("NIM: " + nim);
        System.out.println();
    }
}