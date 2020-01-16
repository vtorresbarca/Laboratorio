package com.wirtz.vanesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LaboratorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratorioApplication.class, args);
	}

}
