package com.taswiksri.employeedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.taswiksri.employeedata.db.entity")
public class EmployeeDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDataApplication.class, args);
	}

}
