package com.praktikum.main;

import com.praktikum.models.Item;
import com.praktikum.users.*;
import java.util.*;

public class LoginSystem {
    public static List<Item> reportedItems = new ArrayList<>();
    public static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("admin", "admin123");
        Student mhs = new Student("Razky", "382");
        userList.add(admin);
        userList.add(mhs);

        while (true) {
            System.out.println("\nLogin sebagai:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Program selesai. Sampai jumpa!");
                break;
            }

            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            User currentUser = null;

            for (User user : userList) {
                if ((choice == 1 && user instanceof Admin) || (choice == 2 && user instanceof Student)) {
                    if (user.login(username, password)) {
                        currentUser = user;
                        break;
                    }
                }
            }

            if (currentUser != null) {
                System.out.println("Login berhasil!\n");
                currentUser.displayAppMenu(scanner);
            } else {
                System.out.println("Login gagal. Username atau password salah.");
            }
        }

        scanner.close();
    }
}
