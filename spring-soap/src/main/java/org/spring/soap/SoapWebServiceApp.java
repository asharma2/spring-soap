package org.spring.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.spring.soap")
public class SoapWebServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(SoapWebServiceApp.class, args);
	}

}
