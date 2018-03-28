package banca;

public class Bonifico extends Transazione{
	
	private ContoCorrente destinazione;
	
	public Bonifico(int codiceTransazione, ContoCorrente origine,
			Double importo, String data, ContoCorrente destinazione) {
		super(codiceTransazione, origine, importo, data);
		this.destinazione = destinazione;
		
		// movimento i soldi
		registraTransazioni();
	}
	
	public void registraTransazioni(){
		// ho una transazione in uscita sull'origine
		super.getOrigine().registraTransazioneInUscita(this);
		
		// ho una transazione in entrata sulla destinazione
		destinazione.registraTransazioneInEntrata(this);
	}
	
	public String stampa() {
		return super.getCodiceTransazione()+ " "+this.destinazione.getCodiceConto()+ " "+super.getImporto()+
				" "+super.getData();
	}


}
