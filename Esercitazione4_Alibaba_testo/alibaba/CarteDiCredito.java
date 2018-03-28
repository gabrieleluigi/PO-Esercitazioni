package alibaba;

public class CarteDiCredito {
	
	private int codice;
	private double credito;
	
	public CarteDiCredito(int codice, double credito) {
		this.codice = codice;
		this.credito = credito;
	}

	public int getCodice() {
		return codice;
	}

	public double getCredito() {
		return credito;
	}
	
	public void incrementaCredito(double nuovoCredito) {
		this.credito += nuovoCredito;
	}

	public void decrementaCredito(double prezzo) {
		this.credito = this.credito - prezzo;
	}

}
