package azienda;

@SuppressWarnings("serial")
public class ErrLavoratoreInesistente extends Exception {
	public ErrLavoratoreInesistente(){
		super("Attenzione, il lavoratore e' inesistente");
	}
}
