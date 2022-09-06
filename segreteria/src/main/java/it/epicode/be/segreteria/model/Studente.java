package it.epicode.be.segreteria.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studente {
	
	
	private String matricola;
	@NotEmpty(message = "Inserire il nome!")
	private String nome;
	@NotEmpty(message = "Inserire il cognome!")
	private String cognome;
	@NotNull(message = "Inserire la data di nascita!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDiNascita;
	@NotEmpty(message = "Inserire la mail!")
	private String email;
	@NotEmpty(message = "Inserire la città!")
	private String citta;
	@NotEmpty(message = "Inserire i corsi!")
	private Corso corso;

}
