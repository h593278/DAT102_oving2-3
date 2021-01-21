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
		String SKILLE = "#";
		String plassering = "C:\\Users\\Elev\\Documents\\1-Informasjonsteknologi\\Eclipse\\DAT102 øving2\\src\\del1\\";
		Scanner innfil = new Scanner(new File(plassering+filnavn));
		
		BufferedReader leser = new BufferedReader(new FileReader(plassering+filnavn));
		
		System.out.println("50");
		
		int antall = 0; 
		antall = Integer.parseInt(leser.readLine());
		Filmarkiv filmer = new Filmarkiv(antall);	//oppretter filmarkivet
		
		for (int i=0; i<antall; i++) {
			//while(leser.hasNext()) {
				System.out.println("28");
				
	            String post = leser.readLine();
	            
                String[] felt = post.split(SKILLE);

				int filmnr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				System.out.println("Produsent: " + produsent);

				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				Sjanger sjanger = Sjanger.finnSjanger(felt[4]);
				String filmselskap = felt[5];

				boolean lagtTil = filmer.leggTilFilm(new Film(filmnr, produsent, tittel, aar, sjanger, filmselskap));
				System.out.println(lagtTil);
			//}
		}
		return filmer;
		
		} catch (FileNotFoundException e) {
			System.out.println("Fil ikkje fonnet");
			return null;
			
		} catch (IOException e) {
			System.out.println("Fil ikkje fonnet");
			return null;
		}
	}
}
