import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount account1 = new BankAccount("202410370110382", "Razky", 0);
        BankAccount account2 = new BankAccount("202410370110337", "Anantha", 0);

        account1.displayInfo();
        account2.displayInfo();

        account1.depositMoney(0);
        account2.depositMoney(0);

        account1.withdrawMoney(0);
        account2.withdrawMoney(0);

        account1.displayInfo();
        account2.displayInfo();

        scanner.close();
    }
}
