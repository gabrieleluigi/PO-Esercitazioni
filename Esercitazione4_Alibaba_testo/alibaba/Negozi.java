package alibaba;

import java.util.LinkedList;
import java.util.List;

public class Negozi {
	private String codice;
	private String nome;
	private String indirizzo;
	private int numeroMaxUnitaEsponibili;
	private List<Prodotti> listaProdotti;
	
	public Negozi(String codice, String nome, String indirizzo, int numeroMaxUnitaEsponibili) {
		this.codice = codice;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numeroMaxUnitaEsponibili = numeroMaxUnitaEsponibili;
		listaProdotti = new LinkedList<Prodotti>();
	}

	public String getCodice() {
		return codice;
	}
	
	private boolean possoEsporre() {
		if(listaProdotti.size() < numeroMaxUnitaEsponibili)
			return true;
		return false;
	}
	
	public void esponi(Prodotti ptemp) {
		if(possoEsporre())
			listaProdotti.add(ptemp);
	}

	public int getDisponibilita(String codiceProdotto) {
		
		int numeroProdotti = 0;
		
		for(Prodotti x: listaProdotti)
			if(x.getCodice().compareTo(codiceProdotto) == 0)
				numeroProdotti++;
		return numeroProdotti;
	}
	
	public Prodotti getProdotto(String codiceProdotto) {
		for(Prodotti x: listaProdotti)
			if(x.getCodice().compareTo(codiceProdotto) == 0)
				return x;
		return null;
	}
	
	public void prelevaProdotto(Prodotti p) {
		listaProdotti.remove(p);
	}
	
}
