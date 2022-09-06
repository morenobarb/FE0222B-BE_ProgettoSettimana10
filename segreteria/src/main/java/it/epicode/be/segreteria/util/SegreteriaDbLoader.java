package it.epicode.be.segreteria.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteria.model.Corso;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Component
public class SegreteriaDbLoader implements CommandLineRunner  {

	@Autowired
	ApplicationContext ctx;
	
	
	@Override
	public void run(String... args) throws Exception {
		SegreteriaDB segreteriaDB = ctx.getBean(SegreteriaDB.class);
		valorizzaDb(segreteriaDB);
	}
	
	private void valorizzaDb(SegreteriaDB segreteriaDB) {
		Corso c1 = new Corso("C12345", "Motori", "Ingegneria", 12);
		Corso c2 = new Corso("B12345", "Tecniche per la infanzia", "Psicologia", 15);
		Corso c3 = new Corso("D12345", "SEO Google", "Scienze della Comunicazione", 10);
		Corso c4 = new Corso("A12345", "Algoritmi e strutture dati", "Informatica", 18);
		Corso c5 = new Corso("E12345", "Evasione fiscale", "Economia", 11);
		
		
		Studente s1 = new Studente("AA952","Marco","Marchi",LocalDate.parse("1999-05-22"),"marcomarchi@gmail.com","Sassari",c1);
		Studente s2 = new Studente("BB783","Fabio","De Fabi",LocalDate.parse("1991-12-12"),"fabiodefabi@gmail.com","Milano",c2);
		Studente s3 = new Studente("CC589","Matteo","De Mattei",LocalDate.parse("1995-08-10"),"matteodemattei@virgilio.it","Siracusa",c3);
		Studente s4 = new Studente("DD783","Luigi","De Luigi",LocalDate.parse("1981-12-19"),"deluigi@gmail.com","Genova",c4);
		Studente s5 = new Studente("EE123","Felice","Caccamo",LocalDate.parse("1985-08-19"),"caccamo@virgilio.it","Trieste",c5); 
		
		
		segreteriaDB.aggiungiStudente(s1);
		segreteriaDB.aggiungiStudente(s2);
		segreteriaDB.aggiungiStudente(s3);
		segreteriaDB.aggiungiStudente(s4);
		segreteriaDB.aggiungiStudente(s5);
		
	}

}
