package esercito;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GestioneEsercito {
	
	private Map<Integer, Militare> militari = new TreeMap<Integer, Militare>();
	private Map<Integer, Comandante> comandanti = new TreeMap<Integer, Comandante>();
	private Map<String, ImpSquadra> squadre = new HashMap<String, ImpSquadra>();
	
	private int matricola = 100;
	
	public int aggiungiMilitare(String nome, String cognome, String dataNascita) {
		if (nome != null && cognome != null && dataNascita != null){
			militari.put(matricola, new Soldato(matricola, nome, cognome, dataNascita));
			return matricola++;
		} 
		return -1;
	}
	
	public Militare getMilitare(int matricola){
		if(militari.containsKey(matricola))
			return militari.get(matricola);
		else
			return null;
	}

	public int aggiungiComandante(String nome, String cognome, String dataNascita, String grado) {
		if (nome != null && cognome != null && dataNascita != null && grado != null){
			Comandante c = new Responsabile(nome, cognome, dataNascita, grado, matricola);
			militari.put(matricola, c); //MOLTO PROBABILMENTE PERDO L'INFORMAZIONE SUL GRADO, E' GIUSTO FARE COSI?
			comandanti.put(matricola, c);
			return matricola++;
		}
		return -1;
	}

	public Comandante getComandante(int matricola){
		if(comandanti.containsKey(matricola))
			return comandanti.get(matricola);
		else
			return null;
	}

	public void aggiungiSquadra(String nomeSquadra){
		if(!squadre.containsKey(nomeSquadra))
			squadre.put(nomeSquadra, new ImpSquadra(nomeSquadra));
	}
	
	public Squadra getSquadra(String nomeSquadra){
		return squadre.get(nomeSquadra);
	}
	
	public void assegnaASquadra(int matricola, String nomeSquadra) {
		if(militari.containsKey(matricola) == true && squadre.containsKey(nomeSquadra) == true) {
			Soldato sl = (Soldato) getMilitare(matricola);
			ImpSquadra sq = (ImpSquadra) getSquadra(nomeSquadra);
			sl.setNomeSquadra(sq);
			sq.aggiungiMilitare(sl);
		}
	}
	
	public void assegnaComandante(int matricolaComandante, int matricolaMilitare) {
		Soldato sl = (Soldato) getMilitare(matricolaMilitare);
		Responsabile re = (Responsabile) getComandante(matricolaComandante);
		if(comandanti.containsKey(matricolaComandante) == true && militari.containsKey(matricolaMilitare) == true && sl.getMatricola() != re.getMatricola()) {
			sl.setComandante(re);
			re.aggiungiSoldato(sl);
		}
	}
  
}
