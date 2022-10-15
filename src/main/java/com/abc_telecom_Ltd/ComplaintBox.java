package com.abc_telecom_Ltd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.abc_telecom_Ltd.config.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class ComplaintBox {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintBox.class, args);
	}

}
