package it.epicode.be.segreteria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.be.segreteria.model.Corso;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Configuration
public class AppConfig {
	
	@Bean
	public SegreteriaDB segreteriaDB() {
		return new SegreteriaDB();
	}
	
	@Bean
	@Scope("prototype")
	public Studente studente() {
		return new Studente();
	}
	@Bean
	@Scope("prototype")
	public Corso corso() {
		return new Corso();
	}

}
