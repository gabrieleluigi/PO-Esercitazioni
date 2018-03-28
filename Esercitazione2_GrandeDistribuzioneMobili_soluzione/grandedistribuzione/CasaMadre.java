package grandedistribuzione;

public class CasaMadre {

	private String nome;
	private String indirizzo;
	private String numeroTelefono;
	private String sitoWeb;
	
	private final int PRIMO_CODICE_NEGOZIO = 1;
	private Negozio negozi[]; // = new Negozio[20];
	private int prossimo_codice_negozio;

	private final int PRIMO_CODICE_ARTICOLO = 100;
	private Articolo articoli[];
	private int prossimo_codice_articolo;
	
	public CasaMadre(String nome, String indirizzo, String numeroTelefono, String sitoWeb){
		this.nome = nome;
		this.indirizzo=indirizzo;
		this.numeroTelefono = numeroTelefono;
		this.sitoWeb=sitoWeb;
		negozi = new Negozio[20]; // Creazione / inizializzazione struttura dati nel costruttore
		prossimo_codice_negozio = PRIMO_CODICE_NEGOZIO;
		articoli = new Articolo[1000];
		prossimo_codice_articolo = PRIMO_CODICE_ARTICOLO;
	}
	
	public String getNome(){
		return nome;
	}

	public String getIndirizzo(){
		return indirizzo;
	}

	public String getNumeroTelefono(){
		return numeroTelefono;
	}

	public String getSitoWeb(){
		return sitoWeb;
	}
	
	public int aggiungiNegozio(String nome, String indirizzo, int numeroArticoliEsponibili){

		// Passi per aggiungere un nuovo negozio
		
		// 1) verificare se e' possibile inserire (non si è superato il limite)
		if(prossimo_codice_negozio>20)
			return 0;
		
		// 2) determinare il codice da assegnare al negozio
		int codice = prossimo_codice_negozio;
		prossimo_codice_negozio++;

		// 3) creare un nuovo oggetto di tipo Negozio, inizializzandolo con i parametri passati
		Negozio ntemp = new Negozio(codice, nome, indirizzo, numeroArticoliEsponibili);
		
		// 4) Inserire il negozio nella struttura dati...
		
		// ... cercando la prima cella libera nell'array ...
		/*
		boolean inserito = false;
		for(int i=0;i<negozi.length;i++) {
			if(negozi[i] == null && inserito ==false) // La cella è ancora vuota
			{
				negozi[i] = ntemp;
				inserito = true;
			}
		}
		*/
		
		// ... oppure utilizzando la relazione tra indice nell'array e codice negozio
		negozi[codice-PRIMO_CODICE_NEGOZIO] = ntemp;
		
		// 5) restituire il codice assegnato al negozio
		return codice;
	}
	
	public String negozio(int codice){
		
		// Individuo il negozio con il codice passato come parametro, usando la relazione di cui sopra
		Negozio ntemp = negozi[codice-PRIMO_CODICE_NEGOZIO];
		return ntemp.toString();

		// Anche con una sola riga di codice
		// return negozi[codice-PRIMO_CODICE_NEGOZIO].toString(); 
	}
	
	public String negozioPiuGrande(){
		int valoreMassimo=-1;
		int indiceMassimo=-1;
		
		for(int i=0;i<negozi.length;i++)
			if(negozi[i]!=null) 
				if(negozi[i].getNumeroArticoliEsponibili()>valoreMassimo) {
					valoreMassimo = negozi[i].getNumeroArticoliEsponibili();
					indiceMassimo = i;
				}
		return negozi[indiceMassimo].toString();
	}
	
	public int aggiungiArticolo(String nome, String descrizione, double prezzo){

		if(this.prossimo_codice_articolo-this.PRIMO_CODICE_ARTICOLO>=1000)
			return 0;

		int codice = prossimo_codice_articolo;
		prossimo_codice_articolo++;
		
		Articolo atemp = new Articolo(codice,nome,descrizione,prezzo);
		
		articoli[codice-PRIMO_CODICE_ARTICOLO] = atemp;
		
		return codice;
	}
	
	public String articolo(int codice){
		return articoli[codice-PRIMO_CODICE_ARTICOLO].toString();
	}
	
	public String articoloPiuEconomico(){
		double valoreMinimo=Integer.MAX_VALUE;
		int indiceMinimo=-1;
		
		for(int i=0;i<articoli.length;i++)
			if(articoli[i]!=null) 
				if(articoli[i].getPrezzo()<valoreMinimo) {
					valoreMinimo = articoli[i].getPrezzo();
					indiceMinimo = i;
				}
		return articoli[indiceMinimo].toString();
	}

	public void esponiArticoloInNegozio(int codiceNegozio, int codiceArticolo){
		Negozio ntemp = negozi[codiceNegozio-PRIMO_CODICE_NEGOZIO];
		Articolo atemp = articoli[codiceArticolo-PRIMO_CODICE_ARTICOLO];
		
		// Anziché accedere direttamente agli array di articoli e negozi in Negozio e Articolo
		// utilizzo la delega, invocando opportuni metodi definito in Negozio e Articolo
		
		ntemp.esponiArticolo(atemp); // Riceve il rif. all'articolo da esporre
		atemp.esponiInNegozio(ntemp); // Riceve il rif. al negozio in cui esporre
	
	}
	
	public String elencoNegozi(int codiceArticolo){
		Articolo atemp = articoli[codiceArticolo-PRIMO_CODICE_ARTICOLO];
		return atemp.elencoNegozi(); // Utilizzo la delega, chi meglio dell'Articolo sa stampare i negozi in cui è esposto?
	}

	public String elencoArticoli(int codiceNegozio){
		Negozio ntemp = negozi[codiceNegozio-PRIMO_CODICE_NEGOZIO];
		return ntemp.elencoArticoli(); // Utilizzo la delega, chi meglio del Negozio sa stampare gli articoli in esso esposti?
	}

	public int numeroNegozi(int codiceArticolo){
		return articoli[codiceArticolo-PRIMO_CODICE_ARTICOLO].numeroNegozi();
	}

	public int numeroArticoli(int codiceNegozio){
		// Verifico che il codice passato come parametro sia valido
		if(codiceNegozio>=PRIMO_CODICE_NEGOZIO && codiceNegozio <this.prossimo_codice_negozio)
			return negozi[codiceNegozio-PRIMO_CODICE_NEGOZIO].numeroArticoli();
		else 
			return 0;
	}

	public String elencoNegoziCheEspongonoPiuDiTotArticoli(int numArticoli){
		String s = "";
		int contatore = 0;
		for(int i=1;i<this.prossimo_codice_negozio;i++)
			if(numeroArticoli(i)>=numArticoli) {
				if(contatore!=0)
					s+="\n"; // Vado a capo prima di stampare la riga (se non si tratta della prima)
				s+=negozio(i);
				contatore++;
			}
		
		return s;
	}

	public String elencoArticoliEspostiInPiuDiTotNegozi(int numNegozi){
		String s = "";
		int contatore = 0;
		for(int i=100;i<this.prossimo_codice_articolo;i++)
			if(numeroNegozi(i)>=numNegozi) {
				if(contatore!=0)
					s+="\n"; // Vado a capo prima di stampare la riga (se non si tratta della prima)
				s+=articolo(i);
				contatore++;
			}
		return s;
	}

}



