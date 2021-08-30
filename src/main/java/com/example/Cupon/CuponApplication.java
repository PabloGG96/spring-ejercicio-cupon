package com.example.Cupon;

import edu.emory.mathcs.backport.java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableSwagger2
@SpringBootApplication
public class CuponApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuponApplication.class, args);
	}

}
