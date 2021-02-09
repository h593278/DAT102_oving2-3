package no.hvl.data102.adt;

import del1.Film;
import del1.Sjanger;

public interface FILMarkivADT {

	
	/**
	 * Returnere en tabell av Filmer
	 * @return Film tabellelen
	 */
	 Film[] hentFilmTabell();
	 
	/**
	 * Legger til en ny Film
	 * @param nyFilm som ein skal legge inn i arkiv
	 * @return true om har blir lagt inn
	 */
	 boolean leggTilFilm(Film nyFilm);
	 
	/**
	 * Sletter en Film hvis den fins
	 * @param filmnr som skal slettet
	 * @return Sant om filmen slettes
	 */
	 boolean slettFilm(int filmnr);
	 
	 /**
	  * S�ker og henter Filmer med en gitt delstreng
	  * @param delstreng som er s�keordet en skal s�ke etter i filmnavn
	  * @return tabell med filmer som inneholder s�ke tekst i filmnavn
	  */
	 Film[] soekTittel(String delstreng);
	 
	 /**
	  * S�ker og henter produsenter med en gitt delstreng
	  * @param delstreng som er s�keordet ein skal s�ke etter i produsentnavn
	  * @return tabell med filmer som inneholder s�ke tekst i produsentnavn
	  */
	 Film[] soekProdusent(String delstreng);
	 
	 /**
	  * Henter antall Filmer for en gitt sjanger
	  * @param sjanger som ein skal finne antall filmer i
	  * @return antall filmer i gitt sjanger
	  */
	 int antall (Sjanger sjanger);
	
	 /**
	  * Returnerer antall Filmer
	  * @return antall Filmer
	  */
	 int antall();
	}//interface
