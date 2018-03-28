package azienda;

@SuppressWarnings("serial")
public class ErrResponsabileInesistente extends Exception {
	public ErrResponsabileInesistente(){
		super("Attenzione, il responsabile e' inesistente");
	}
}
