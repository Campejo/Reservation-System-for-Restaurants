package com.myproject.model;

import java.util.Scanner;

public class Login {

    private String username = "admin";
    private String password = "pwd123";
    Scanner scanner = new Scanner(System.in);

    public void acessSystem() {
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        if ((username.contentEquals(this.username)) && (password.contentEquals(this.password))) {
            Menu menu = new Menu();
            menu.menu();
        } else {
            throw new RuntimeException("Username or password are incorrect");
        }
    }


}
