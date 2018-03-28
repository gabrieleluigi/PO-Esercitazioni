package grandedistribuzione;

//import java.util.Arrays;

public class Negozio {

	private int codice;
	private String nome;
	private String indirizzo;
	private int numeroArticoliEsponibili;
	
	private Articolo negozioEsponeArticoli[];
	private int numeroArticoli;
	
	public Negozio(int codice, String nome, String indirizzo, int numeroArticoliEsponibili) {
		this.codice = codice;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numeroArticoliEsponibili = numeroArticoliEsponibili;
		
		this.negozioEsponeArticoli = new Articolo[numeroArticoliEsponibili];
		this.numeroArticoli = 0;
	}
	
	public int getCodice() {
		return codice;
	}
	public String getNome() {
		return nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public int getNumeroArticoliEsponibili() {
		return numeroArticoliEsponibili;
	}
	public Articolo[] getNegozioEsponeArticoli() {
		return negozioEsponeArticoli;
	}
	public int getNumeroArticoli() {
		return numeroArticoli;
	}
	
	public String toString() {
		return codice + " " + nome + " " + indirizzo + " " + numeroArticoliEsponibili; 
	}
	
	public void esponeArticoli(Articolo a) {
		negozioEsponeArticoli[numeroArticoli] = a;
		//System.out.print("Visualizza articoli presenti in negozio: ");
		//System.out.println(Arrays.toString(negozioEsponeArticoli));
		numeroArticoli++;
	}
	
	public boolean checkArticoloInNegozio(int codiceArticolo) {
		for(int i=0; i < numeroArticoli; i++)
			if(negozioEsponeArticoli[i].getCodice() == codiceArticolo)
				return true;
		return false;
	}
	
}
