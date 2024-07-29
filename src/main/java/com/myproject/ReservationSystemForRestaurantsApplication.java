package com.myproject;

import com.myproject.model.Login;
import com.myproject.model.Restaurant;
import com.myproject.model.RestaurantReservation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ReservationSystemForRestaurantsApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ReservationSystemForRestaurantsApplication.class, args);
		Login login = new Login();
		login.acessSystem();
	}
}
