package del1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 

public class Fil {

	// private static final String SKILLE = null;

	public static void skrivTilFil(String filnavn, Filmarkiv filmer) {
		try {

			PrintWriter skriver = new PrintWriter(filnavn);

			skriver.println(filmer.antall());

			for (int i = 0; i < filmer.antall(); i++) {
				Film film = filmer.hentFilmTabell()[i];
				skriver.print(film.getFilmnr()+"#");
				skriver.print(film.getProdusent()+"#");
				skriver.print(film.getTittel()+"#");
				skriver.print(film.getAar()+"#");
				skriver.print(film.getSjanger()+"#");
				skriver.println(film.getFilmselskap());
			}

		} catch (FileNotFoundException e) {
			System.out.println("Fil ikkje fonnet");			
		}
	}
//	20#Walt Disney#Askepott#1950#Fantasy#Warner Bros

	public static Filmarkiv lesFil(String filnavn) {
		try {
		final String SKILLE = "#";
		Scanner leser = new Scanner(new File(filnavn));
		
		int antall = Integer.parseInt(leser.nextLine());
		Filmarkiv filmer = new Filmarkiv(antall);	//oppretter filmarkivet
		
		for (int i=0; i<antall; i++) {
			while(leser.hasNext()) {
				//System.out.println(leser.next(SKILLE));
				int filmnr = Integer.parseInt(leser.next(SKILLE));
				String produsent = leser.next(SKILLE);
				String tittel = leser.next(SKILLE);
				int aar = Integer.parseInt(leser.next(SKILLE));
				Sjanger sjanger = Sjanger.finnSjanger(leser.next(SKILLE));
				String filmselskap = leser.next(SKILLE);

				filmer.leggTilFilm(new Film(filmnr, produsent, tittel, aar, sjanger, filmselskap));
			}
		}
		return filmer;
		
		} catch (FileNotFoundException e) {
			System.out.println("Fil ikkje fonnet");
			return null;
		}
	}
}
