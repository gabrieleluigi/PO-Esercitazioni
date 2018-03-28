package impianto;

public class Sdoppiatore extends Componente {
	
	private Componente[] uscite;
	
	public Sdoppiatore(String nome, String descrizione) {
		super(nome, descrizione);
		uscite = new Componente[2];
	}
    
	public Componente[] getUscite() {
		return uscite;
    }

	public void collega(Componente componente, int uscita) {
		if(uscita == 0)
			uscite[0] = componente;
		if(uscita == 1)
			uscite[1] = componente;
	}
	
	public String toString (double portata) {
		String s = new String();
		s += super.getNome()+"-"+portata;
		portata = portata/2;
		s += "-"+portata+"-"+portata+"\n";
		if(uscite[0] != null)
			s += uscite[0].getNome()+"-"+portata+"\n";
		if(uscite[1] != null)
			s += uscite[1].getNome()+"-"+portata+"\n";
		return s;
	}
}
