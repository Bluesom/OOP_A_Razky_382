import java.util.Scanner;

public class Task{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String username, password, nama, nim;

        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan Pilihan (1-2): ");
        int choice = scan.nextInt();
        scan.nextLine();

        if(choice == 1) {
            System.out.print("Masukkan Username: ");
            username = scan.next();
            System.out.print("Masukkan Password: ");
            password = scan.next();
                if(username.equals("Admin382") && password.equals("Password382")) {
                    System.out.println("Login Admin berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
        } else if (choice == 2) {
            System.out.print("Masukkan Nama: ");
            nama = scan.nextLine();
            System.out.print("Masukkan NIM: ");
            nim = scan.nextLine();
                if(nama.equals("Razky Ganendya Capriawan") && nim.equals("202410370110382")) {
                    System.out.println("Login Mahasiswa berhasil!");
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        scan.close();
    }
}