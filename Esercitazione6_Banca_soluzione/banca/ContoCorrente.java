package banca;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ContoCorrente implements Comparable<ContoCorrente>{
	private int codice;
	private String nomeIntestatario;
	private String cognomeIntestatario;
	private Double saldo;
	
	private Map<Integer, Transazione> transazioni = new HashMap<Integer, Transazione>();
	
	public ContoCorrente(int codice, String nomeIntestatario,
			String cognomeIntestatario, Double saldo) {
		this.codice = codice;
		this.nomeIntestatario = nomeIntestatario;
		this.cognomeIntestatario = cognomeIntestatario;
		this.saldo = saldo;
	}

	public int getCodiceConto() {
		return codice;
	}

	public String getNomeIntestatario() {
		return nomeIntestatario;
	}

	public String getCognomeIntestatario() {
		return cognomeIntestatario;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void registraTransazioneInUscita(Transazione t){
		transazioni.put(t.getCodiceTransazione(), t);
		saldo = saldo - t.getImporto();
	}
	
	public void registraTransazioneInEntrata(Transazione t){
		transazioni.put(t.getCodiceTransazione(), t);
		saldo = saldo + t.getImporto();
	}

	public Collection<Transazione> elencoTransazioniPerData() {
		List<Transazione> ttemp = new LinkedList<Transazione>(transazioni.values());
		Collections.sort(ttemp, new ComparatoreTransazionePerData());
		return ttemp;
	}

	public Collection<Transazione> elencoTransazioniPerTipoeImporto() {
		List<Transazione> ttemp = new LinkedList<Transazione>(transazioni.values());
		Collections.sort(ttemp, new ComparatoreTransazioniPerTipoeImporto());
		return ttemp;
	}

	public Collection<String> stampaTransazioniPerData(){
		List<String> lista = new LinkedList<String>();
		for (Transazione t : elencoTransazioniPerData())
			lista.add(t.stampa());
		return lista;
	}
	

	public Collection<String> stampaTransazioniPerTipoeImporto(){
		List<String> lista = new LinkedList<String>();
		for (Transazione t : elencoTransazioniPerTipoeImporto())
			lista.add(t.stampa());
		return lista;
		
	}

	@Override
	public int compareTo(ContoCorrente altro) {
		return - this.getSaldo().compareTo(altro.getSaldo());
	}
}
