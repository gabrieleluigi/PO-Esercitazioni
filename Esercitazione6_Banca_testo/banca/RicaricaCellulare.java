package banca;

public class RicaricaCellulare extends Transazione {
	
	private String numeroCellulare;

	public RicaricaCellulare(int codiceTransazione, ContoCorrente origine, Double importo, String data,
			String numeroCellulare) {
		super(codiceTransazione, origine, importo, data);
		this.numeroCellulare = numeroCellulare;
	}

	public String getNumeroCellulare() {
		return numeroCellulare;
	}
	
	public String toString() {
		return super.getCodiceTransazione()+" "+super.getOrigine().getCodiceConto()+" "+numeroCellulare+" "+super.getImporto()+" "+super.getData();
	}
}
