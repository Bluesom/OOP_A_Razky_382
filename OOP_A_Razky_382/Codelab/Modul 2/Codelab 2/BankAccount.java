import java.util.Scanner;

class BankAccount {
    String accountNumber, ownerName;
    double balance;
    Scanner scanner;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.scanner = new Scanner(System.in);
    }

    public void depositMoney(double amount) {
        System.out.println("Masukkan uang yang akan disetor untuk " + ownerName + ": ");
        amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println(ownerName + " menyetor Rp" + amount + ". Saldo sekarang: Rp" + balance);
        } else {
            System.out.println("Saldo tidak dapat dikurangi");
        }
    }
    
    public void withdrawMoney(double amount) {
        System.out.println("Masukkan uang yang akan ditarik untuk " + ownerName + ": ");
        amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(ownerName + " menarik Rp" + amount + ". (Berhasil) Saldo sekarang: Rp" + balance  + "\n");
        } else if (amount > balance) {
            System.out.println(ownerName + " menarik Rp" + amount + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + balance + "\n");
        }
    }

    public void displayInfo() {
        System.out.println("Nomor Rekening: " + accountNumber);
        System.out.println("Nama Pemilik: " + ownerName);
        System.out.println("Saldo: " + balance);
        System.out.println();
    }

}