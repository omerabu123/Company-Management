package com.companyManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.companyManagment.service.IEmployeeServiceImpl;

@SpringBootApplication
public class CompanyManagmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(CompanyManagmentApplication.class, args);
	}

}
