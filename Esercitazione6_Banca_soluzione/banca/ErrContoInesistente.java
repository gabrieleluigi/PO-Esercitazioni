package banca;


@SuppressWarnings("serial")
public class ErrContoInesistente extends Exception {
	public ErrContoInesistente(){
		super("Attenzione, il conto e' inesistente");
	}
}
