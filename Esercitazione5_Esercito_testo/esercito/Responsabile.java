package esercito;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Responsabile extends Soldato implements Comandante {
	
	private String grado;
	private List<Militare> soldati;
	
	public Responsabile(String nome, String cognome, String dataNascita, String grado, int matricola) {
		super(matricola, nome, cognome, dataNascita);
		this.grado = grado;
		this.soldati = new LinkedList<Militare>();
	}

	@Override
	public int compareTo(Militare o) {
		return 0;
	}

	@Override
	public String getGrado() {
		return grado;
	}

	@Override
	public Collection<Militare> getSoldati() throws ErrSoldatiInesistenti {
		if(soldati.size()==0) {
			throw new ErrSoldatiInesistenti();
		}
		Collections.sort(soldati, new ComparatoreDiSoldatiPerCognomeNomeDataNascita());
		return soldati;
	}

	@Override
	public Collection<Militare> getSoldatiOrdinatiPerMatricolaDecrescente() throws ErrSoldatiInesistenti { 
		if(soldati.size()==0) {
			throw new ErrSoldatiInesistenti();
		}
		Collections.sort(soldati, new ComparatoreDiSoldatiPerMatricolaDecrescente());
		return soldati;
	}
	
	public void aggiungiSoldato(Soldato s){
		soldati.add(s);
	}
	
}
