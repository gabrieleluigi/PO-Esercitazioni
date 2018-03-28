package azienda;

public class App {

	public static void main(String[] args) throws ErrLavoratoreInesistente, ErrResponsabileInesistente, ErrTeamDiverso {
		
		GestioneAzienda ga = new GestioneAzienda();
		
		ga.aggiungiLavoratore("Mario", "Rossi", "20001212");
		
		try {
			System.out.println(ga.getLavoratore(100));
		} catch (ErrLavoratoreInesistente e) {
			e.printStackTrace();
		}
		
		
		int matricolaSottoposto = ga.aggiungiLavoratore("Luca", "Bianchi", "19901010");
		Lavoratore l = ga.getLavoratore(matricolaSottoposto);

	    int matricolaResponsabile = ga.aggiungiResponsabile("Marco", "Blu", "19800520", "caporale");
	    Responsabile r = ga.getResponsabile(matricolaResponsabile);

	    ga.assegnaATeam(matricolaSottoposto, "To001");
	    ga.assegnaATeam(matricolaResponsabile, "To001");

	    ga.assegnaResponsabile(matricolaResponsabile, matricolaSottoposto);

	}

}
