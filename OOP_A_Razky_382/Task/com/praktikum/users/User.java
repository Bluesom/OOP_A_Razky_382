package com.praktikum.users;
import java.util.Scanner;

public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract boolean login(String username, String password);
    public abstract void displayAppMenu(Scanner scanner);

}
