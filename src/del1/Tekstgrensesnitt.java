package del1;
import static java.lang.Integer.*;
import static javax.swing.JOptionPane.*;
public class Tekstgrensesnitt {
	
	public static void main(String[] args) {
		int svar = parseInt(showInputDialog("Vil du jobbe i eit "
				+ "resterande filmarkiv trykk 1, eller nytt tryk 0"));
		do {
			if (svar==1) {
				String filnamn = showInputDialog("Kva filmarkiv vil du hente fram?");
			
				Filmarkiv filmer = Fil.lesFil(filnamn);
				
				boolean Ferdig=false;
				
				while (!Ferdig) {
				int valg = parseInt(showInputDialog("1 nyfilm\n2 slett fil\n3 soke etter tittel\n"
						+ "4 søke etter produsent\n5 Antall i gitt sjanger\n6 for å skirve ut\n"
						+ "0 for å avslutte"));
				
				switch(valg) {
				  case 0:
				    Ferdig=true;
				    break;
				  case 1:
					  	int filmnr = Integer.parseInt(showInputDialog("Filmnr"));
						String produsent = showInputDialog("Produsent");
						String tittel = showInputDialog("Titttel");
						int aar = Integer.parseInt(showInputDialog("År"));
						Sjanger sjanger1 = Sjanger.finnSjanger(showInputDialog("Sjanger"));
						String filmselskap = showInputDialog("Filmselskap");

						filmer.leggTilFilm(new Film(filmnr, produsent, tittel, aar, sjanger1, filmselskap));
					  	break;
				  case 2:
					    // code block
					    break;
				  case 3:
					    // code block
					    break;
				  case 4:
					    // code block
					    break;
				  case 5:
					  	String sjanger = showInputDialog("Hvilken sjanger");
					  	System.out.println(filmer.antall(Sjanger.finnSjanger(sjanger)));
					    break;
				  case 6:
					    filmer.skrivUt();
					    break;
				  default:
				    // code block
				}
				}
				
			} else if (svar==0) {
				
				
			} else {
				svar = parseInt(showInputDialog("Venligst prøv igjenn"));
			}
		} while(svar!=0 || svar!=1);
	}
	
}
