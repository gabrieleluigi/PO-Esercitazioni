package impianto;

public class Sorgente extends Componente {
	
	private double portata;
	
	public Sorgente(String nome, String descrizione) {
		super(nome, descrizione);
	}

	public void setPortata(double portata){
        this.portata = portata;
	}

	public double getPortata() {
		return portata;
	}
	
}
