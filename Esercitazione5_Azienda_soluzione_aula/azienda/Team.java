package azienda;

import java.util.LinkedList;
import java.util.List;

public class Team {

	private String nome;
	private List<Lavoratore> lavoratori;
	
	public Team(String nome) {
		this.nome = nome;
		this.lavoratori = new LinkedList<Lavoratore>();
	}

	public void aggiungiLavoratore(Lavoratore l){
		lavoratori.add(l);
	}
	
	public void eliminaLavoratore(Lavoratore l){
		lavoratori.remove(l);
	}

	public String getNome() {
		return nome;
	}
	
	
	
	
	
	
}
