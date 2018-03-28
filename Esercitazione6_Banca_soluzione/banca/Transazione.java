package banca;

public class Transazione {
	
	private int codiceTransazione;
	private ContoCorrente origine;
	private Double importo;
	private String data;
	
	public Transazione(int codiceTransazione, ContoCorrente origine,
			Double importo, String data) {
		this.codiceTransazione = codiceTransazione;
		this.origine = origine;
		this.importo = importo;
		this.data = data;
	}
	
	public void registraTransazioni(){
		// ho una transazione in uscita sull'origine
		origine.registraTransazioneInUscita(this);
	}

	public int getCodiceTransazione() {
		return codiceTransazione;
	}

	public Double getImporto() {
		return importo;
	}

	public ContoCorrente getOrigine() {
		return origine;
	}

	public String getData() {
		return data;
	}

	public String stampa() {
		return "";
	}
}
