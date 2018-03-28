package azienda;

@SuppressWarnings("serial")
public class ErrTeamDiverso extends Exception {
	public ErrTeamDiverso(){
		super("Attenzione, si sta cercando di assegnare un sottoposto a un responsabile che opera in un team diverso");
	}
}
