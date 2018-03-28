package azienda;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Capo extends Dipendente implements Responsabile{
	private String qualifica;
	private Map<Integer, Lavoratore> sottoposti = new 
			TreeMap<Integer, Lavoratore>();
	

	public Capo(String nome, String cognome, 
			String dataNascita, int matricola, String qualifica) {
		super(nome, cognome, dataNascita, matricola);
		this.qualifica = qualifica;		
	}

	@Override
	public String getQualifica() {
		return qualifica;
	}

	@Override
	public Collection<Lavoratore> 
	getSottopostiInOrdineDiEtaDecrescente() {
		List<Lavoratore> ltemp = new LinkedList(sottoposti.values());
		Collections.sort(ltemp);
		return ltemp;
	}

	@Override
	public Collection<Lavoratore> 
	getSottopostiOrdinatiPerMatricolaCrescente() {
		return sottoposti.values();
	}

	public void aggiungiSottoposto(Dipendente d){
		sottoposti.put(d.getMatricola(), d);
	}
	
	public void eliminaSottoposto(Dipendente d){
		sottoposti.remove(d.getMatricola());
	}
	
}
