import java.util.Scanner; // Import Scanner class for user input

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input

        // Create two BankAccount objects with an initial balance of 0
        BankAccount account1 = new BankAccount("202410370110382", "Razky", 0);
        BankAccount account2 = new BankAccount("202410370110337", "Anantha", 0);

        // Display initial account information
        account1.displayInfo();
        account2.displayInfo();

        // Call depositMoney method to deposit money into the accounts
        account1.depositMoney(0);
        account2.depositMoney(0);

        // Call withdrawMoney method to withdraw money from the accounts
        account1.withdrawMoney(0);
        account2.withdrawMoney(0);

        // Display account information after transactions
        account1.displayInfo();
        account2.displayInfo();

        scanner.close(); // Close the Scanner to prevent resource leaks
    }
}