package azienda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GestioneAzienda {
	private Map<Integer, Lavoratore> lavoratori = new TreeMap<Integer, Lavoratore>();
	private Map<Integer, Responsabile> capi = new TreeMap<Integer, Responsabile>();
	private Map<String, Team> team = new HashMap<String, Team>();
	private int matricola = 100;
	
	public int aggiungiLavoratore(String nome, String cognome, String dataNascita) {
		if (nome != null && cognome != null && dataNascita != null){
			Lavoratore l = new Dipendente(nome, cognome, dataNascita, matricola);
			lavoratori.put(matricola, l);
			//matricola++; // o matricola++; e dopo return matricola-1;
			return matricola++; // oppure return matricola ++;
		} 
		return -1;
	}
	
	public Lavoratore getLavoratore(int matricola) throws ErrLavoratoreInesistente {
		if (!lavoratori.containsKey(matricola)){
			ErrLavoratoreInesistente eccezione = new ErrLavoratoreInesistente();
		}
		return lavoratori.get(matricola);
	}

	public int aggiungiResponsabile(String nome, String cognome, String dataNascita, String qualifica) {
		if (nome != null && cognome != null && dataNascita != null && qualifica != null){
			Responsabile r = new Capo(nome, cognome, dataNascita, matricola, qualifica);
			capi.put(matricola, r);
			lavoratori.put(matricola, r);
			return matricola++;
		}		
		return -1;
	}

	public Responsabile getResponsabile(int matricola) throws ErrResponsabileInesistente {
		if (!capi.containsKey(matricola)) 
			throw new ErrResponsabileInesistente();
		return capi.get(matricola);
	}

	public void assegnaATeam(int matricola, String nomeTeam) throws ErrLavoratoreInesistente{
		Team t;
		
		if (!team.containsKey(nomeTeam)){
			t = new Team(nomeTeam);
			team.put(nomeTeam, t);
		}else
			t = team.get(nomeTeam);
		
		Dipendente d = (Dipendente) getLavoratore(matricola);
		d.assegnaATeam(t);
		t.aggiungiLavoratore(d);
	}
	
	public void assegnaResponsabile(int matricolaResponsabile, int matricolaSottoposto) throws ErrLavoratoreInesistente, 
			ErrResponsabileInesistente, ErrTeamDiverso {
		
		// 1) identifico lavoratore e responsabile
		Dipendente d = (Dipendente) getLavoratore(matricolaSottoposto);
		Capo c = (Capo) getResponsabile(matricolaResponsabile);
		
		// 2) controllo se sono nello stesso team
		if (d.getNomeTeam().compareTo(c.getNomeTeam()) != 0){
			throw new ErrTeamDiverso();
		}
		
		if (!d.equals(c)){
			d.setResponsabile(c);
			c.aggiungiSottoposto(d);
		}
		
	}

	public int caricaDati(String nomeFile) 
		throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nomeFile));
		
		String line; 
		int numLinee = 0;
		
		while ((line = in.readLine()) != null){
			int matricolaInserita = -1;
			String [] ar = line.split(";");
			
			if (ar.length == 4 && ar[0].toUpperCase().compareTo("L") == 0){
				String nome = ar[1].trim();
				String cognome = ar[2].trim();
				String data = ar[3].trim();
				
				matricolaInserita = aggiungiLavoratore(nome, cognome, data);
			}
			
			if (ar.length == 5 && ar[0].toUpperCase().compareTo("R") == 0){
				String nome = ar[1].trim();
				String cognome = ar[2].trim();
				String data = ar[3].trim();
				String qualifica = ar[4].trim();
				
				matricolaInserita = aggiungiResponsabile(nome, cognome, data, qualifica);
			}
			
			if (matricolaInserita != -1)
				numLinee++;
		}
		return numLinee;
	}
}
