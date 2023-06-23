package com.example.testspringmvc;

import org.springframework.ui.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class TestspringmvcApplication {

	public static void main(String[] args) {SpringApplication.run(TestspringmvcApplication.class, args);
	}

}
