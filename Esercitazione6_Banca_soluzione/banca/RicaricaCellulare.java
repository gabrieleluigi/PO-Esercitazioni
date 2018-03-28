package banca;

public class RicaricaCellulare extends Transazione {

	String numeroCellulare;
	
	public RicaricaCellulare(int codiceTransazione, ContoCorrente origine,
			Double importo, String data, String numeroCellulare) {
		super(codiceTransazione, origine, importo, data);
		this.numeroCellulare = numeroCellulare;
		// movimento i soldi
		super.registraTransazioni();
	}

	public String stampa() {
		return super.getCodiceTransazione()+ " "+this.numeroCellulare+ " "+super.getImporto()+
				" "+super.getData();
	}
}
