package no.hvl.data102.adt;

import del1.Film;
import del1.Sjanger;

public interface FILMarkivADT {
	// Bruk gjerne javadoc her
	 // i stedet for vanlige
	 // kommentarlinjer som her
	
	// Returnere en tabell av Filmer
	 Film[] hentFilmTabell();
	 
	// Legger til en ny Film
	 boolean leggTilFilm(Film nyFilm);
	 
	// Sletter en Film hvis den fins
	 boolean slettFilm(int filmnr);
	 
	 // Søker og henter Filmer med en gitt delstreng
	 Film[] soekTittel(String delstreng);
	 
	 // Søker og henter produsenter med en gitt delstreng
	 Film[] soekProdusent(String delstreng);
	 
	 // Henter antall Filmer for en gitt sjanger
	 int antall (Sjanger sjanger);
	
	 // Returnerer antall Filmer
	 int antall();
	}//interface 