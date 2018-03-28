package impianto;

public class Valvola extends Componente {
	
	private boolean aperta;
	
	public Valvola(String nome, String descrizione) {
		super(nome, descrizione);
	}
	
	public void setAperta(boolean aperta){
        this.aperta = aperta;
	}

	public boolean isAperta() {
		return aperta;
	}	
	
	public String toString (double portata) {
		return super.getNome()+"-"+portata+"-"+portata;
	}
	
}
