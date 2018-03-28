package banca;


@SuppressWarnings("serial")
public class ErrContoScoperto extends Exception {
	public ErrContoScoperto(){
		super("Attenzione, il conto e' scoperto");
	}
}
