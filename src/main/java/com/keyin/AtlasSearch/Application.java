package com.keyin.AtlasSearch;


import com.keyin.AtlasSearch.Controller.AuthenticationController;
import com.keyin.AtlasSearch.Controller.LocationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource({"classpath:application.properties"})
@SpringBootApplication()
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
