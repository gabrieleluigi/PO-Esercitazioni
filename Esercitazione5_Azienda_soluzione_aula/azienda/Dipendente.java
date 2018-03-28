package azienda;

public class Dipendente implements Lavoratore{
	private String nome; 
	private String cognome;
	private String dataNascita;
	private int matricola;
	private Team team;
	private Responsabile responsabile;
	
	public Dipendente(String nome, String cognome, 
			String dataNascita, int matricola) {
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
	public String getNomeTeam() {
		return team.getNome();
	}

	@Override
	public Responsabile getResponsabile() {
		return responsabile;
	}

	public void assegnaATeam(Team t){
		team = t;
	}
	
	public void setResponsabile(Capo c){
		responsabile = c;
	}

	@Override
	public int compareTo(Lavoratore altro) {
		// prima per data nascita
		int diffData = this.getDataNascita().compareTo(altro.getDataNascita());
		
		if (diffData != 0)
			return diffData;
		
		// poi per cognome
		int diffCognome = this.getCognome().compareTo(altro.getCognome());
		if (diffCognome != 0)
			return diffCognome;
		
		// infine per nome
		return this.getNome().compareTo(altro.getNome());
	}
	
}
