package del1;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.File;
import java.io.IOException;

public class Tekstgrensesnitt {
	
	public static void main(String[] args) {
		int svar = parseInt(showInputDialog("Vil du jobbe i eit "
				+ "resterande filmarkiv trykk 1, eller nytt tryk 0"));
		do {
			if (svar==1) {
				String filnamn = showInputDialog("Kva filmarkiv vil du hente fram?");
			
				Filmarkiv filmer = Fil.lesFil(filnamn);
				
				valgFunksjoner(filmer, filnamn);
				
			} else if (svar==0) {
				try {
				File myObj = new File("C:\\Users\\Elev\\Documents\\1-Informasjonsteknologi\\Eclipse\\DAT102 øving2\\src\\del1\\"+showInputDialog("Nytt Fil Navn?"));
				
				if (myObj.createNewFile()) {
			        System.out.println("File created: " + myObj.getName());
			        Filmarkiv arkiv = new Filmarkiv(parseInt(showInputDialog("Antall filmer")));
			        valgFunksjoner(arkiv , myObj.getName());
			      } else {
			        System.out.println("File already exists.");
			      }
				} catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				}
				
				
			} else {
				svar = parseInt(showInputDialog("Venligst prøv igjenn"));
			}
		} while(svar!=0 && svar!=1);
	}
	
	public static void valgFunksjoner (Filmarkiv filmer, String filnamn){
		boolean Ferdig=false;
		
		while (!Ferdig) {
		int valg = parseInt(showInputDialog("1 nyfilm\n2 slett fil\n3 soke etter tittel\n"
				+ "4 søke etter produsent\n5 Antall filmer i ein gitt sjanger\n6 for å skirve ut\n"
				+ "0 for å avslutte"));
		
		switch(valg) {
		  case 0:
		    Ferdig=true;
		    Fil.skrivTilFil(filnamn, filmer);
		    break;
		  case 1:
			  	int filmnr = Integer.parseInt(showInputDialog("Filmnr"));
				String produsent = showInputDialog("Produsent");
				String tittel = showInputDialog("Titttel");
				int aar = Integer.parseInt(showInputDialog("År"));
				Sjanger sjanger1 = Sjanger.finnSjanger(showInputDialog("Sjanger"));
				String filmselskap = showInputDialog("Filmselskap");

				boolean ok = filmer.leggTilFilm(new Film(filmnr, produsent, tittel, aar, sjanger1, filmselskap));
				if (ok)
			    	showMessageDialog(null, "Filen blei lagt til");
			    else
			    	showMessageDialog(null, "Filen blei ikkje lagt til");					  	break;
		  case 2:
			    boolean slettet = filmer.slettFilm(Integer.parseInt(showInputDialog("Nummer på filmen du vil slette")));
			    if (slettet)
			    	showMessageDialog(null, "Filen blei sletta");
			    else
			    	showMessageDialog(null, "Filen blei ikkje sletta");
			    
			    break;
		  case 3:
			    Film[] samling = filmer.soekTittel(showInputDialog("Søk på Tittel med søkeord"));
			    String svarSokeTittel =""; 
			    for (int i=0; i<samling.length; i++) {
			    	svarSokeTittel+=samling[i].toString()+"\n";
			    }
			    showMessageDialog(null, "Svar resultat på søkeordet ditt\n"+ svarSokeTittel);
			    break;
		  case 4:
			  	Film[] samling2 = filmer.soekProdusent(showInputDialog("Søk på Produsent med søkeord"));
			    String svarSokeProdusent =""; 
			    for (int i=0; i<samling2.length; i++) {
			    	svarSokeProdusent+=samling2[i].toString()+"\n";
			    }
			    showMessageDialog(null, "Svar resultat på søkeordet ditt\n"+ svarSokeProdusent);
			    break;
		  case 5:
			  	String sjanger = showInputDialog("Hvilken sjanger");
			  	showMessageDialog(null, filmer.antall(Sjanger.finnSjanger(sjanger)));
			    break;
		  case 6:
			    showMessageDialog(null, filmer.skrivUt());
			    break;
		  default:
			    showMessageDialog(null, "Ikkje greit");
		}
		}
	}
	
}
