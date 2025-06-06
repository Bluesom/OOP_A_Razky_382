package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;
import java.util.Scanner;

public class Student extends User implements MahasiswaActions {

    public Student(String username, String password) {
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
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    reportItem(scanner);
                    break;
                case 2:
                    viewReportedItems();
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
    public void reportItem(Scanner scanner) {
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        Item item = new Item(nama, deskripsi, lokasi, "Reported");
        LoginSystem.reportedItems.add(item);

        System.out.println(">> Barang berhasil dilaporkan! <<");
    }

    @Override
    public void viewReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println(">> Belum ada laporan tersedia. <<");
            return;
        }
        System.out.println(">> Daftar Laporan Barang <<");
        for (Item item : LoginSystem.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println(item);
            }
        }
    }
}