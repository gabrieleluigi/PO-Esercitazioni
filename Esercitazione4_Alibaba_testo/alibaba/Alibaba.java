package alibaba;

import java.util.LinkedList;
import java.util.List;

public class Alibaba {
	
	private List<Prodotti> p;
	private List<CarteDiCredito> c;
	private Negozi[] n;
	private final int MAX_NEGOZI = 500;
	private int PROSSIMO_NEGOZIO = 0;
	
	/**
	* Costruttore di Alibaba
    */
	public Alibaba() {
		p = new LinkedList<Prodotti>();
		c = new LinkedList<CarteDiCredito>();
		n = new Negozi[MAX_NEGOZI];
	}

	/**
	 * Aggiunge un prodotto al sistema 
	 * @param codice
	 * @param nome
	 * @param descrizione
	 * @param colore
	 * @param prezzo
	 */
	public void aggiungiProdotto(String codice, String nome, String descrizione, String colore, double prezzo) {
		p.add(new Prodotti(codice, nome, descrizione, colore, prezzo));
	}
  
	/**
	 * Restituisce il nome di un prodotto, dato il suo codice
	 * @param codice 
	 * @return modello del prodotto, altrimenti null
	 */
	public String getNome(String codice) {
		
		Prodotti ptemp = cercaProdotti(codice);
		
		if (ptemp != null)
			return ptemp.getNome();
		return null;
	}

	/**
	 * Restituisce la descrizione di un prodotto, dato il suo codice
	 * @param codice 
	 * @return descrizione se trova il prodotto, altrimenti null
	 */
	public String getDescrizione(String codice) {
		
		Prodotti ptemp = cercaProdotti(codice);
		
		if (ptemp != null)
			return ptemp.getDescrizione();
		return null;
	}

	/**
	 * Restituisce il colore di un prodotto, dato il suo codice
	 * @param codice 
	 * @return colore se trova il prodotto, altrimenti null
	 */
	public String getColore(String codice) {
		
		Prodotti ptemp = cercaProdotti(codice);
		
		if (ptemp != null)
			return ptemp.getColore();
		return null;
	}

	/**
	 * Restituisce il prezzo di un prodotto, dato il suo codice
	 * @param codice 
	 * @return prezzo se trova il prodotto, altrimenti null
	 */
	public Double getPrezzo(String codice) {
		
		Prodotti ptemp = cercaProdotti(codice);
		
		if(ptemp != null)
			return ptemp.getPrezzo();
		return null;
	}

	/**
	 * Crea una nuova carta di credito
	 * @param codice il codice della carta di credito
	 * @param credito il credito presente sulla carta di credito
	 */
	public void creaCartaDiCredito(int codice, double credito) {
		
		CarteDiCredito ctemp = cercaCarteDiCredito(codice);
		
		if(ctemp == null)
			c.add(new CarteDiCredito(codice,credito));
		else
			ctemp.incrementaCredito(credito);
	}

	/**
	 * Restituisce il credito corrispondente ad una carta di credito
	 * @param codice il codice della carta di credito
	 */
	public double getCredito(int codice) {
		
		CarteDiCredito ctemp = cercaCarteDiCredito(codice);
		
		if(ctemp != null)
			return ctemp.getCredito();
		return 0.0;
	}

	/**
	 * Crea un nuovo negozio e lo inserisce nel sistema, solo se non si supera il 
	 * numero massimo di negozi
	 * @param codice
	 * @param nome
	 * @param indirizzo
	 * @param numeroMaxProdottiEsponibili numero massimo di unita' che il negozio puo' esporre (due prodotti con lo stesso codice contano come due unita')
	 */
	public void aggiungiNegozio(String codice, String nome, String indirizzo, int numeroMaxUnitaEsponibili) {
		if(PROSSIMO_NEGOZIO < MAX_NEGOZI) {
			n[PROSSIMO_NEGOZIO] = new Negozi(codice, nome, indirizzo, numeroMaxUnitaEsponibili);
			PROSSIMO_NEGOZIO++;
		}
	}

	/**
	 * Espone un prodotto nella vetrina virtuale di un negozio - solo se non si supera il numero massimo di unita' che il negozio puo' esporre
	 * @param codiceNegozio
	 * @param codiceProdotto
	 */
	public void esponiProdotto(String codiceNegozio, String codiceProdotto){
		
		Prodotti ptemp = cercaProdotti(codiceProdotto);
		
		if(ptemp != null) {
			Negozi ntemp = cercaNegozi(codiceNegozio);
			if(ntemp != null)
				ntemp.esponi(ptemp);
		}
	}
	
	/**
	 * Restituisce la disponibilita' di un prodotto in un negozio, oppure 0, se nessun prodotto e' presente
	 * @param codiceNegozio
	 * @param codiceProdotto
	 * @return numero di prodotti con quel codice esposti nel negozio
	 */
	public int getDisponibilita(String codiceNegozio, String codiceProdotto){
		
		Negozi ntemp = cercaNegozi(codiceNegozio);
		
		if(ntemp != null)
			return ntemp.getDisponibilita(codiceProdotto);
		return 0;
	}

	/**
	 * Restituisce la disponibilita' di una prodotto in tutti i negozi del sistema, oppure 0, se nessun prodotto e' presente
	 * @param codiceProdotto
	 * @return numero di prodotti con quel codice esposti in tutti i negozi del sistema
	 */
	public int getDisponibilita(String codiceProdotto){
		
		int disponibile = 0;
		
		for(Negozi x: n)
			if(x != null)
				disponibile += x.getDisponibilita(codiceProdotto);
		return disponibile;	
	}

	/**
	 * Acquista un prodotto, verificando le condizioni necessarie
	 * @param codiceProdotto
	 * @param codiceNegozio
	 * @param codiceCartaDiCredito
	 */
	public void acquistaProdotto(String codiceProdotto, String codiceNegozio, int codiceCartaDiCredito) {
		
		Negozi ntemp = cercaNegozi(codiceNegozio);
		CarteDiCredito ctemp = cercaCarteDiCredito(codiceCartaDiCredito);
		
		if(ntemp != null && ctemp != null) {
			Prodotti ptemp = cercaProdotti(codiceProdotto);
			if(ptemp != null && ctemp.getCredito() >= ptemp.getPrezzo()) {
				ntemp.prelevaProdotto(ptemp);
				ctemp.decrementaCredito(ptemp.getPrezzo());
			}
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	private Prodotti cercaProdotti(String codice) {
		for(Prodotti x: p)
			if(x.getCodice().compareTo(codice) == 0)
				return x;
		return null;
	}
	
	private CarteDiCredito cercaCarteDiCredito(int codice) {
		for(CarteDiCredito x: c)
			if(x.getCodice() == codice)
				return x;
		return null;
	}
	
	private Negozi cercaNegozi(String codice){
		for (Negozi x: n)
			if (x.getCodice().compareTo(codice) == 0)
				return x;
		return null;
	}
	
}