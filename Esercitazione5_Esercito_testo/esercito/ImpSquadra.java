package esercito;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ImpSquadra implements Squadra{

	private String nome;
	private List<Militare> militari;
	
	public ImpSquadra(String nome) {
		this.nome = nome;
		this.militari = new LinkedList<Militare>();
	}
	
	public void aggiungiMilitare(Militare m){
		militari.add(m);
	}
	
	public void eliminaMilitare(Militare m){
		militari.remove(m);
	}

	@Override
	public String getNomeSquadra() {
		return nome;
	}

	@Override
	public Collection<Militare> getComponenti() {
		return militari;
	}
}
