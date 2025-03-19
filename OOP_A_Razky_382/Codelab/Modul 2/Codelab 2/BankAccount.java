import java.util.Scanner; // Import Scanner class for user input

// Define the BankAccount class to represent a bank account
class BankAccount {
    String accountNumber, ownerName; // Store account number and owner's name
    double balance; // Store account balance
    Scanner scanner; // Scanner for user input

    // Constructor to initialize an account with account number, owner name, and initial balance
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.scanner = new Scanner(System.in); // Create a Scanner object for input
    }

    // Method to deposit money into the account
    public void depositMoney(double amount) {
        System.out.println("Enter the amount to deposit for " + ownerName + ": ");
        amount = scanner.nextDouble(); // Get deposit amount from user input

        // Check if the deposit amount is greater than zero
        if (amount > 0) {
            balance += amount; // Add deposit amount to balance
            System.out.println(ownerName + " deposited Rp" + amount + ". Current balance: Rp" + balance);
        } else {
            System.out.println("Deposit amount must be greater than 0!"); // Display error if the amount is invalid
        }
    }

    // Method to withdraw money from the account
    public void withdrawMoney(double amount) {
        System.out.println("Enter the amount to withdraw for " + ownerName + ": ");
        amount = scanner.nextDouble(); // Get withdrawal amount from user input

        // Checking if the withdrawal amount is valid and does not exceed the balance
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Subtract the withdrawal amount from balance
            System.out.println(ownerName + " withdrew Rp" + amount + ". (Success) Current balance: Rp" + balance + "\n");
        } else if (amount > balance) {
            System.out.println(ownerName + " attempted to withdraw Rp" + amount + ". (Failed, insufficient balance) Current balance: Rp" + balance + "\n");
        }
    }

    // Method to display account information
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Owner: " + ownerName);
        System.out.println("Balance: Rp" + balance);
        System.out.println();
    }
}