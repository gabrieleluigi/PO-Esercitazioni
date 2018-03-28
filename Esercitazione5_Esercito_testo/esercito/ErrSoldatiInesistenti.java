package esercito;

@SuppressWarnings("serial")
public class ErrSoldatiInesistenti extends Exception {
	public ErrSoldatiInesistenti(){
		super("Attenzione, il soldato e' inesistente");
	}
}
