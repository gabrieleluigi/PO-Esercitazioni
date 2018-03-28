package grandedistribuzione;

public class Articolo {

	private int codice;
	private String nome;
	private String descrizione;
	private double prezzo;
	
	private Negozio negoziInCuiEsposto[];
	private int numNegoziInCuiEsposto;

	
	public Articolo(int codice, String nome, String descrizione, double prezzo) {
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		negoziInCuiEsposto = new Negozio[20];
		numNegoziInCuiEsposto = 0;
	}

	// Metodi getter
	
	public int getCodice() {
		return codice;
	}

	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	// Delega, l'oggetto si stampa / si descrive
	
	public String toString() {
		return codice+" "+nome+" "+descrizione+" "+prezzo;
	}

	// Delega, chi meglio dell'Articolo sa esporre, elencare, determinare il numero, ecc.
	
	public void esponiInNegozio(Negozio n) {
		negoziInCuiEsposto[numNegoziInCuiEsposto] = n;
		numNegoziInCuiEsposto++;
	}
	
	public String elencoNegozi() {
		String s = "";
		for(int i=0;i<numNegoziInCuiEsposto;i++) {
			s+=negoziInCuiEsposto[i];
			if(i!=numNegoziInCuiEsposto-1)
				s+="\n";
		}
		return s;
	}
	
	public int numeroNegozi(){
		return numNegoziInCuiEsposto;
	}

}
