package grandedistribuzione;

public class Negozio {

	private int codice;
	private String nome;
	private String indirizzo;
	private int numeroArticoliEsponibili;
	
	private Articolo articoliEsposti[];
	private int numArticoliEsposti;

	public Negozio(int codice, String nome, String indirizzo, int numeroArticoliEsponibili) {
		this.codice = codice;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numeroArticoliEsponibili = numeroArticoliEsponibili;
		articoliEsposti = new Articolo[numeroArticoliEsponibili];
		numArticoliEsposti = 0;
	}

	// Metodi getter
	
	public int getCodice() {
		return codice;
	}

	public String getNome() {
		return nome;
	}

	public String getInidrizzo() {
		return indirizzo;
	}

	public int getNumeroArticoliEsponibili() {
		return numeroArticoliEsponibili;
	}

	// Delega, l'oggetto si stampa / si descrive
	
	public String toString() {
		return codice+" "+nome+" "+indirizzo+" "+numeroArticoliEsponibili;
	}
	
	// Delega, chi meglio dell'Negozio sa esporre, elencare, determinare il numero, ecc.
	
	public void esponiArticolo(Articolo a) {
		if(numArticoliEsposti==numeroArticoliEsponibili)
			return; // Numero massimo articoli esponibili raggiunto
		for(int i=0;i<numArticoliEsposti;i++)
			if(articoliEsposti[i].getCodice() == a.getCodice())
				return; // Articolo già esposto
		// Se è possibile esporre
		System.out.println("Esporto articolo: "+a.getCodice()+" in negozio "+this.getNome());
		articoliEsposti[numArticoliEsposti] = a;
		numArticoliEsposti++; // Incremento il contatore che uso per inserire
	}
	
	public String elencoArticoli() {
		String s = "";
		for(int i=0;i<numArticoliEsposti;i++) {
			s+=articoliEsposti[i];
			if(i!=numArticoliEsposti-1)
				s+="\n";
		}
		return s;
	}

	public int numeroArticoli(){
		return numArticoliEsposti;
	}


}
