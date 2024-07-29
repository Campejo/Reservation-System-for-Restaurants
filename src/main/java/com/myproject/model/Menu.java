package com.myproject.model;

import java.util.Scanner;

public class Menu {
    Restaurant restaurant = new Restaurant();
    protected void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean showMenu = true;



        while (showMenu) {
            System.out.println("1 - To do a reservation");
            System.out.println("2 - To view the reservations");
            System.out.println("3 - To update a reservation");
            System.out.println("4 - To cancel a reservation");
            System.out.println("5 - Exit the menu");
            String inputStr = scanner.nextLine();
            switch (inputStr) {
                case "1":
                    System.out.println("Client Name: ");
                    String clientName = scanner.nextLine();
                    System.out.println("Persons: ");
                    int persons = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Date and Hour:\n(example: 18/09/2022 18:30)");
                    String newDate = scanner.nextLine();
                    System.out.println("Desk number: ");
                    Long deskNumber = scanner.nextLong();
                    scanner.nextLine();
                    restaurant.reserve(clientName, persons, newDate, deskNumber);
                    System.out.println("Reserved!");
                    break;

                case "2":
                    System.out.println(restaurant.seeReserves());
                    break;

                case "3":
                    System.out.println("Reserve ID: ");
                    Long reserveId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("New reserve: ");
                    String newReserveDate = scanner.nextLine();
                    restaurant.changeReserve(reserveId, newReserveDate);
                    System.out.println("Updated!");
                    break;

                case "4":
                    System.out.println("Reserve ID: ");
                    Long reserveIdToCancel = scanner.nextLong();
                    scanner.nextLine();
                    restaurant.cancelReserve(reserveIdToCancel);
                    System.out.println("Canceled!");
                    break;

                case "5":
                    showMenu = false;
                    break;
            }
        }
    }
}
