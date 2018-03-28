package grandedistribuzione;

//import java.util.Arrays;

public class Articolo {
	
	private int codice;
	private String nome;
	private String descrizione;
	private double prezzo;
	
	private Negozio articoliInNegozio[];
	private int numeroNegozi;
	
	public Articolo(int codice, String nome, String descrizione, double prezzo) {
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		
		this.articoliInNegozio = new Negozio[20];
		this.numeroNegozi = 0;
	}

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
	public Negozio[] getArticoliInNegozio() {
		return articoliInNegozio;
	}
	public int getNumeroNegozi() {
		return numeroNegozi;
	}

	public String toString() {
		return codice + " " + nome + " " + descrizione + " " + prezzo; 
	}
	
	public void esponiInNegozio(Negozio n) {
		articoliInNegozio[numeroNegozi] = n;
		//System.out.print("Visualizza negozi in cui e' esporto l'articolo: ");
		//System.out.println(Arrays.toString(articoliInNegozio));
		numeroNegozi++;
	}
	
}
