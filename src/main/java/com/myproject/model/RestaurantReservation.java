package com.myproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class RestaurantReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private LocalDateTime dateTime;
    private int personsQuantity;
    private boolean checked = false;

    protected RestaurantReservation(Long id, String name, LocalDateTime dateTime, int personsQuantity) {
        this.id = id;
        this.clientName = name;
        this.dateTime = dateTime;
        this.personsQuantity = personsQuantity;
    }

    protected Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    protected String getClientName() {
        return clientName;
    }

    protected void setClientName(String clientName) {
        this.clientName = clientName;
    }

    protected LocalDateTime getDateTime() {
        return dateTime;
    }

    protected void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    protected int getPersonsQuantity() {
        return personsQuantity;
    }

    protected void setPersonsQuantity(int personsQuantity) {
        this.personsQuantity = personsQuantity;
    }

    protected boolean isChecked() {
        return checked;
    }

    protected void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Restaurant Reservation { " +
                "desk number= " + id +
                ", client name= " + clientName +
                ", date= " + dateTime.format(formatter) +
                ", persons quantity= " + personsQuantity +
                ", checked= " + checked +
                " }\n";
    }
}
