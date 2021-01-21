package del1;

import packageno.hvl.data102.adt.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT{
	private Film[] filmer;
	private int antall;
	
	//konnstruktør
	public Filmarkiv (int n) {
		filmer = new Film[n];
	}
	
	// Returnere en tabell av Filmer
	 public Film[] hentFilmTabell() {
		 return trimTab(filmer, antall);
	 }
	
	// Legger til en ny Film
	public boolean leggTilFilm(Film nyFilm) {

		for(int i=0; i<antall; i++) {

			if (filmer[i].getFilmnr() == nyFilm.getFilmnr()) {
				return false;
				
			}

		}
		if (antall<filmer.length) {

			filmer[antall]=nyFilm;
			antall++;

			return true;
		}
		return false;
	}
	
	// Sletter en Film hvis den fins 
	public boolean slettFilm(int filmnr) {
		for(int i=0; i<=antall; i++) {
			if (filmer[i].getFilmnr() == filmnr) {
				
				antall--;
				filmer[i]=filmer[antall];
				filmer[antall]=null;
				return true;
				}
			}
		return false;
	}
	 // Søker og henter Filmer med en gitt delstreng
	public Film[] soekTittel(String delstreng) {
		
		Film[] filmtab2 = new Film[antall];
		int n=0;
		
		for (int i=0; i<filmer.length; i++) {
			if (filmer[i].getTittel().contains(delstreng)) {
				filmtab2[n]=filmer[i];
				n++;	
			}
		}
		return trimTab(filmtab2, n);
	
		
		
	}
	
	//trimmer
	public Film[] trimTab(Film[] tab, int n) { // n er antall elementer
		 Film[] filmtab2 = new Film[n];
		 int i = 0;
		 while (i < n) {
			 filmtab2[i] = tab[i];
			 i++;
		 }//while
		 return filmtab2;
		}
	
	 // Søker og henter produsenter med en gitt delstreng
	 public Film[] soekProdusent(String delstreng) {
		 Film[] filmtab2 = new Film[antall];
			int n=0;
			
			for (int i=0; i<filmer.length; i++) {
				if (filmer[i].getProdusent().contains(delstreng)) {
					filmtab2[n]=filmer[i];
					n++;	
				}
			}
			return trimTab(filmtab2, n);
	 }
	
	 // Henter antall Filmer for en gitt sjanger
	 public int antall (Sjanger sjanger) {
		 Film[] filmtab2 = new Film[antall];
			int n=0;
			
			for (int i=0; i<filmer.length; i++) {
				if (filmer[i].getSjanger() == sjanger) {
					filmtab2[n]=filmer[i];
					n++;	
				}
			}

			return n;
	 }
	
	 // Returnerer antall Filmer
	 public int antall() {
		 return antall;
	 }
	 
	 public void skrivUt() {
		 for (int i=0; i<antall; i++) {
			 System.out.println(filmer[i].toString());
		 }
	 }
	
}
