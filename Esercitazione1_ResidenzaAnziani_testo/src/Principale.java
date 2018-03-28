import residenza.Residenza;

public class Principale {

	public static void main(String[] args) {
		
		Residenza r = new Residenza();
		r.setNome("Senior Residence");
		r.setIndirizzo("Via Giovanni Servais 80, Torino");
		
		String nomeResidenza = r.getNome();
		String indirizzoResidenza = r.getIndirizzo();
		System.out.println("Creata residenza " + nomeResidenza+ " con sede in "+indirizzoResidenza);
		System.out.println();
		
		r.aggiungiOspite("Marco","Verdi","19200630");
		r.aggiungiOspite("Luca","Rossi", "19321028");
		r.aggiungiOspite("Martina","Blu", "19380226");
		r.aggiungiOspite("Giovanna","Gialli", "19270101");
		
		String primoOspite = r.primo();
		System.out.println("primo() --> " + primoOspite);
		System.out.println();

		String ultimoOspite = r.ultimo();
		System.out.println("ultimo() --> " + ultimoOspite);
		System.out.println();
		
		primoOspite = r.ospite(1); 
		System.out.println("ospite(1) --> " + primoOspite);
		System.out.println("ospite(2) --> " + r.ospite(2));
		System.out.println("ospite(3) --> " + r.ospite(3));
		System.out.println("ospite(4) --> " + r.ospite(4));
		System.out.println();
		
		System.out.println("Elenco:");
		System.out.println(r.elenco());
		System.out.println();
	}
}









