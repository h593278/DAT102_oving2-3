package del2;

import del1.Film;
import del1.Sjanger;
import no.hvl.data102.adt.FILMarkivADT;

public class Filmarkiv2 implements FILMarkivADT{
	private LinearNode<Film> start;
	private int antall;
	
	@Override
	public Film[] hentFilmTabell() {
		Film[] filmer=new Film[antall];
		
		LinearNode<Film> neste = start;
		for (int i=0; i<antall && neste!=null; i++) {
			filmer[i]=neste.getElement();
			neste=neste.getNeste();			
		}
		return filmer;
	}
	 
	 @Override
	 public boolean leggTilFilm(Film nyFilm) {
		 LinearNode<Film> nynode = new LinearNode<>(nyFilm);
		 nynode.setNeste(start);
		 start=nynode;
		 antall++;
		 return true;
	 }
	 
	 @Override
	 public boolean slettFilm(int filmnr) {
		LinearNode<Film> neste = start;
		LinearNode<Film> forrige = start;
		//Kjekke om det finnes nokre element i lista
		if (neste==null) {
			return false;
		}
		//Vist det er det første elemente
		if(neste.getElement().getFilmnr()==filmnr) {
			neste=neste.getNeste();
			antall--;
			return true;
		} else {
			neste=neste.getNeste();	//Her blir neste og forrige ulike
			for (int i=1; i<antall && neste!=null; i++) {
				if (neste.getElement().getFilmnr()==filmnr) {
					//Kjekke om det er det siste elemente
					if (neste.getNeste()==null) {
						neste=null;
						return true;
					}
					forrige.setNeste(neste.getNeste());
					antall--;
					return true;
				}
				forrige=neste;
				neste=neste.getNeste();
			}
		}
		return false;
	 }
	 
	 @Override
	 public Film[] soekTittel(String delstreng) {
		Film[] filmer= new Film[antall];
		LinearNode<Film> neste = start;
		int pos=0;
		
		for (int i=0; i<antall; i++) {
			if (neste.getElement().getTittel().contains(delstreng)) {
				filmer[pos]=neste.getElement();
				pos++;
			}
			neste=neste.getNeste();
		}
		return trimTab(filmer, pos);
	 }
	 
	 @Override
	 public Film[] soekProdusent(String delstreng) {
		Film[] filmer= new Film[antall];
		LinearNode<Film> neste = start;
		int pos=0;
		
		for (int i=0; i<antall; i++) {
			if (neste.getElement().getProdusent().contains(delstreng)) {
				filmer[pos]=neste.getElement();
				pos++;
			}
			neste=neste.getNeste();
		}
		return trimTab(filmer, pos);
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
	 @Override
	 public int antall (Sjanger sjanger) {
		LinearNode<Film> neste = start;
		int antalFilmer=0;
			
			for (int i=0; i<antall; i++) {
				if (neste.getElement().getSjanger()==sjanger) {
					antalFilmer++;
				}
				neste=neste.getNeste();
			}
			return antalFilmer;
		 }
	
	 @Override
	 public int antall() {
		 return antall;
	 }
}
