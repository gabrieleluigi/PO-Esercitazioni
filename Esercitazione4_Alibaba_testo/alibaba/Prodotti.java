package alibaba;

public class Prodotti {
	
	private String codice;
	private String nome;
	private String descrizione;
	private String colore;
	private double prezzo;
	
	public Prodotti(String codice, String nome, String descrizione, String colore, double prezzo) {
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.colore = colore;
		this.prezzo = prezzo;
	}

	public String getCodice() {
		return codice;
	}

	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public String getColore() {
		return colore;
	}

	public double getPrezzo() {
		return prezzo;
	}
	
}
