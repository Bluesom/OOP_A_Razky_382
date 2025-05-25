package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;
import java.util.Scanner;

public class Admin extends User implements AdminActions {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayAppMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    manageItems();
                    break;
                case 2: 
                    manageUsers();
                    break;
                case 0: 
                    System.out.println("Logout...");
                    break;
                default: 
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 0);
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println(">> Tidak ada barang yang dilaporkan. <<");
            return;
        }

        System.out.println(">> Daftar Barang <<");
        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
            System.out.println(i + ". " + LoginSystem.reportedItems.get(i));
        }

        System.out.print("Masukkan indeks barang yang ingin ditandai sebagai 'Claimed': ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            Item item = LoginSystem.reportedItems.get(index);
            item.setStatus("Claimed");
            System.out.println(">> Barang berhasil ditandai sebagai telah diambil.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(">> Indeks tidak valid.");
        } catch (NumberFormatException e) {
            System.out.println(">> Input harus berupa angka.");
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.print("Pilih: ");
        String pilih = scanner.nextLine();

        if (pilih.equals("1")) {
            System.out.print("Masukkan nama mahasiswa: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String pass = scanner.nextLine();
            Student newStudent = new Student(nama, pass);
            LoginSystem.userList.add(newStudent);
            System.out.println(">> Mahasiswa berhasil ditambahkan.");
        } else if (pilih.equals("2")) {
            System.out.print("Masukkan nama mahasiswa yang akan dihapus: ");
            String nama = scanner.nextLine();
            boolean found = false;

            for (int i = 0; i < LoginSystem.userList.size(); i++) {
                User user = LoginSystem.userList.get(i);
                if (user instanceof Student && user.getUsername().equals(nama)) {
                    LoginSystem.userList.remove(i);
                    System.out.println(">> Mahasiswa berhasil dihapus.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(">> Mahasiswa tidak ditemukan.");
            }
        } else {
            System.out.println(">> Pilihan tidak valid.");
        }
    }
}