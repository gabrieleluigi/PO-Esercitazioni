package impianto;

public class Componente {
	
	private String nome;
	private String descrizione;
	private Componente uscita;

	public Componente(String nome, String descrizione){
		this.nome = nome;
		this.descrizione = descrizione;
	}
	
	public String getNome(){
		return nome;
	}

	public String getDescrizione(){
		return descrizione;
	}
	
	public String getClassName() {
		return getClass().getSimpleName();
	}

	public void collega(Componente componente){
		if(getClassName().compareTo("Irrigatore") != 0) 
			uscita = componente;
	}
	
	public Componente getUscita(){
		return uscita;
	}
	
	public String toString (double portata) {
		return nome+"-"+portata;
	}
}
