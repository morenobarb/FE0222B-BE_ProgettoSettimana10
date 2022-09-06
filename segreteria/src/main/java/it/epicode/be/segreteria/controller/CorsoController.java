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

@Controller
public class CorsoController {
	@Autowired
	ApplicationContext ctx;
	
	public SegreteriaDB getSegreteriaDB() {
		return ctx.getBean(SegreteriaDB.class);
		
	}
	
	
	@GetMapping("/stampacorsi")
	public ModelAndView stampaCorsi() {
		ModelAndView modelAndView = new ModelAndView("corsiview","corsi",getSegreteriaDB().getAllCorsi());
		return modelAndView;
	}
	
	@GetMapping("/eliminacorso/{codice}")
	public ModelAndView eliminaCorso(@PathVariable("codice") String matricola ) {
		getSegreteriaDB().cancellaCorso(matricola);
		return new ModelAndView("corsiview","corsi",getSegreteriaDB().getAllCorsi());
		
	}
	@GetMapping("/corsi/inserisciform")
	public ModelAndView inserisciFormCorso(Corso corso) {
		return new ModelAndView("aggiungicorso","corsi",getSegreteriaDB().getAllCorsi());

		
	 }

	@PostMapping("/corsi/inserisci")
	public ModelAndView inserisciCorso(Corso corso,BindingResult result,Model model) {	
		getSegreteriaDB().aggiungiCorso(corso);
		ModelAndView modelAndView = new ModelAndView("corsiview","corsi",getSegreteriaDB().getAllCorsi());
		return modelAndView;
	}

}
