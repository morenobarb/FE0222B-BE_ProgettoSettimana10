package it.epicode.be.segreteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.be.segreteria.model.Corso;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Controller
public class StudenteController {
	
	@Autowired
	ApplicationContext ctx;
	
	public SegreteriaDB getSegreteriaDB() {
		return ctx.getBean(SegreteriaDB.class);
		
	}
	
	
	
	
	@GetMapping("/stampastudenti")
	public ModelAndView stampaStudenti() {
		ModelAndView modelAndView = new ModelAndView("studentiview","studenti",getSegreteriaDB().getAllStudenti());
		return modelAndView;
	}
	
	@GetMapping("/eliminastudente/{matricola}")
	public ModelAndView eliminaStudente(@PathVariable("matricola") String matricola ) {
		getSegreteriaDB().cancellaStudente(matricola);
		return new ModelAndView("studentiview","studenti",getSegreteriaDB().getAllStudenti());
		
	}
	@GetMapping("/studenti/inserisciform")
	public ModelAndView inserisciForm(Studente studente) {
		return new ModelAndView("aggiungistudente","corsi",getSegreteriaDB().getAllCorsi());

		
	 }
	 
	

	@PostMapping("/studenti/inserisci")
	public ModelAndView inserisciStudente(Studente studente,BindingResult result,Model model) {	
		getSegreteriaDB().aggiungiStudente(studente);
		Corso c1 = new Corso("C12345", "Motori", "Ingegneria", 12);
		studente.setCorso(c1);
		ModelAndView modelAndView = new ModelAndView("studentiview","studenti",getSegreteriaDB().getAllStudenti());
		return modelAndView;
	}
	
	
}
