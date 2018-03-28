package banca;

public class Bonifico extends Transazione {

	private ContoCorrente destinazione;

	public Bonifico(int codiceTransazione, ContoCorrente origine, Double importo, String data,
			ContoCorrente destinazione) {
		super(codiceTransazione, origine, importo, data);
		this.destinazione = destinazione;
	}

	public ContoCorrente getDestinazione() {
		return destinazione;
	}
	
	public String toString() {
		return super.getCodiceTransazione()+" "+super.getOrigine().getCodiceConto()+" "+destinazione.getCodiceConto()+" "+super.getImporto()+" "+super.getData();
	}

}
