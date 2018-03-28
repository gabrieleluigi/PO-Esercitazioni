package banca;

public class Transazione {
	
	private int codiceTransazione;
	private ContoCorrente origine;
	private Double importo;
	private String data;
	
	public Transazione(int codiceTransazione, ContoCorrente origine, Double importo, String data) {
		this.codiceTransazione = codiceTransazione;
		this.origine = origine;
		this.importo = importo;
		this.data = data;
	}

	public int getCodiceTransazione() {
		return codiceTransazione;
	}

	public ContoCorrente getOrigine() {
		return origine;
	}

	public Double getImporto() {
		return importo;
	}

	public String getData() {
		return data;
	}

}
