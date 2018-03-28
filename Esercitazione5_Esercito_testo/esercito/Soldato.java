package esercito;

public class Soldato implements Militare {
	
	private String nome;
	private String cognome;
	private String dataNascita;
	private int matricola;
	private Squadra nomeSquadra;
	private Comandante comandante;
	
	public Soldato(int matricola, String nome, String cognome, String dataNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.matricola = matricola;
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public String getCognome() {
		return cognome;
	}
	
	@Override
	public String getDataNascita() {
		return dataNascita;
	}
	
	@Override
	public int getMatricola() {
		return matricola;
	}
	
	@Override
	public String getNomeSquadra() {
		return nomeSquadra.getNomeSquadra();
	}
	
	@Override
	public Comandante getComandante() {
		return comandante;
	}

	public void setNomeSquadra(Squadra nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public void setComandante(Comandante comandante) {
		this.comandante = comandante;
	}

	@Override
	public int compareTo(Militare o) {
		return 0;
	}
	
}
