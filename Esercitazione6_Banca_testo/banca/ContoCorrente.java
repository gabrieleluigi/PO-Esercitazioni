package banca;

public class ContoCorrente{
	
	private int codiceConto;
	private String nomeIntestatario;
	private String cognomeIntestatario;
	private double saldo;

	public ContoCorrente(int codiceConto, String nomeIntestatario, String cognomeIntestatario, double saldo) {
		this.codiceConto = codiceConto;
		this.nomeIntestatario = nomeIntestatario;
		this.cognomeIntestatario = cognomeIntestatario;
		this.saldo = saldo;
	}

	public int getCodiceConto() {
		return codiceConto;
	}

	public String getNomeIntestatario() {
		return nomeIntestatario;
	}

	public String getCognomeIntestatario() {
		return cognomeIntestatario;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public void incrementaSaldo(Double importo) {
		saldo = saldo + importo;
	}
	
	public void decrementaSaldo(Double importo) {
		saldo = saldo - importo;
	}
}
