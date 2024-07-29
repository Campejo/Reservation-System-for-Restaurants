package com.myproject.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Restaurant {

    private List<RestaurantReservation> restaurantReservesList = new ArrayList<>();

    protected void reserve(String clientName, int persons, String dateAndHour, Long deskNumber) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateAndHour, formatter);
        Iterator<RestaurantReservation> iterator = restaurantReservesList.iterator();
        if (restaurantReservesList.isEmpty()) {
            RestaurantReservation reservation = new RestaurantReservation(deskNumber, clientName, dateTime, persons);
            reservation.setChecked(true);
            restaurantReservesList.add(reservation);
        }else {
            while(iterator.hasNext()) {
                RestaurantReservation res = iterator.next();
                if (!res.getId().equals(deskNumber)) {
                    RestaurantReservation reservation = new RestaurantReservation(deskNumber, clientName, dateTime, persons);
                    reservation.setChecked(true);
                    restaurantReservesList.add(reservation);
                    break;
                }else {
                    throw new RuntimeException("Reserve doesn't available");
                }
            }
        }

    }

    protected List<RestaurantReservation> seeReserves() {
        return restaurantReservesList;
    }

    protected void changeReserve(Long reserveId, String newDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime changedDateTime = LocalDateTime.parse(newDateTime, formatter);
        if (!restaurantReservesList.isEmpty()) {
            Iterator<RestaurantReservation> iterator = restaurantReservesList.iterator();
            while(iterator.hasNext()) {
                RestaurantReservation reserve = iterator.next();
                if (Objects.equals(reserveId, reserve.getId())) {
                    reserve.setDateTime(changedDateTime);
                    break;
                }
            }
        }
    }

    protected void cancelReserve(Long reserveId) {
        Scanner scanner = new Scanner(System.in);
        if (restaurantReservesList.isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        Iterator<RestaurantReservation> iterator = restaurantReservesList.iterator();
        while(iterator.hasNext()) {
            RestaurantReservation reserve = iterator.next();
            if (Objects.equals(reserveId, reserve.getId())) {
                System.out.println(iterator);
                System.out.println("Are you sure that you want cancel the reserve: " + iterator + " ?");
                System.out.println("Digit (yes) to confirm.");
                String scanToConfirm = scanner.nextLine();
                if (scanToConfirm.equalsIgnoreCase("yes")) {
                    iterator.remove();
                }else {
                    System.out.println("Operation was canceled.");
                }
                break;
            }
        }
    }
}
