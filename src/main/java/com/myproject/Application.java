package com.myproject;

import com.myproject.model.Login;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(ReservationSystemForRestaurantsApplication.class, args);
		Login login = new Login();
		login.acessSystem();
	}
}
