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
			String plassering = "C:\\Users\\Elev\\Documents\\1-Informasjonsteknologi\\Eclipse\\DAT102 øving2\\src\\del1\\";
			PrintWriter skriver = new PrintWriter(plassering+filnavn);

			skriver.println(filmer.antall());
			//System.out.println("a");

			for (int i = 0; i < filmer.antall(); i++) {
				//System.out.println(filmer.antall());

				Film film = filmer.hentFilmTabell()[i];
				skriver.print(film.getFilmnr()+"#");
				skriver.print(film.getProdusent()+"#");
				skriver.print(film.getTittel()+"#");
				skriver.print(film.getAar()+"#");
				skriver.print(film.getSjanger()+"#");
				skriver.println(film.getFilmselskap());
				//System.out.println("b");
			}
			skriver.close();
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
		
		System.out.println("Leser fil");
		
		int antall = 0; 
		antall = Integer.parseInt(leser.readLine());
		Filmarkiv filmer = new Filmarkiv(antall);	//oppretter filmarkivet
		
		for (int i=0; i<antall; i++) {
			//while(leser.hasNext()) {
				
	            String post = leser.readLine();
	            
                String[] felt = post.split(SKILLE);

				int filmnr = Integer.parseInt(felt[0]);
				String produsent = felt[1];

				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				Sjanger sjanger = Sjanger.finnSjanger(felt[4]);
				String filmselskap = felt[5];

				boolean lagtTil = filmer.leggTilFilm(new Film(filmnr, produsent, tittel, aar, sjanger, filmselskap));
				System.out.println("Blir han lagt til? " + lagtTil);
				System.out.println("antall elemeter " + filmer.antall());


			//}
		}
		leser.close();
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
