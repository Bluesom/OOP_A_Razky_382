package com.praktikum.main;

import com.praktikum.users.*;
import java.util.Scanner;

public class LoginSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        System.out.println("Login sebagai:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (choice == 1) {
            Admin admin = new Admin("admin", "admin123");
            if (admin.login(username, password)) {
                currentUser = admin;
            }
        } else if (choice == 2) {
            Student mhs = new Student("Razky", "382");
            if (mhs.login(username, password)) {
                currentUser = mhs;
            }
        }

        if (currentUser != null) {
            System.out.println("Login berhasil!\n");
            currentUser.displayAppMenu(scanner);
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }
}
