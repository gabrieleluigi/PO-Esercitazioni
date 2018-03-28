import grandedistribuzione.*;

/**
 * Classe con un main di esempio.
 */
public class Esempio {

	public static void main(String[] args) {
		
		String nomeCasaMadre = "IKEA";
		String indirizzoCasaMadre = "Amager Strandvej 390, 2770 Kastrup, Denmark";
		String numeroTelefonoCasaMadre = "004532626880";
		String sitoWebCasaMadre = "www.ikea.com";
		
		CasaMadre casaMadre = new CasaMadre(nomeCasaMadre, indirizzoCasaMadre, numeroTelefonoCasaMadre, sitoWebCasaMadre);
		
		System.out.println("Creata casa madre " 
		+ casaMadre.getNome() + " con indirizzo "+casaMadre.getIndirizzo()+" numero di telefono "+casaMadre.getNumeroTelefono()+ " e sito Web "+casaMadre.getSitoWeb());
		
		int nA = casaMadre.aggiungiNegozio("Torino Collegno", "Viale Svezia 10 - 10093 Collegno (TO)", 100);
		int nB = casaMadre.aggiungiNegozio("Milano San Giuliano", "Via Po 3 Fraz. Sesto Ulteriano - 20098 San Giuliano Milanese (MI)", 500);
		int nC = casaMadre.aggiungiNegozio("Roma Anagnina", "Via Fattoria Rampa 35 - 00173 Roma (RM)", 800);
		
		System.out.println();
		System.out.println("Codici negozi aggiunti: ");
		System.out.println(nA);
		System.out.println(nB);
		System.out.println(nC);

		System.out.println();
		System.out.println("Negozio con il primo codice: " + casaMadre.negozio(nA));
		
		int pX = casaMadre.aggiungiArticolo("Vinter 2017", "Illuminazione decorativa a LED a batterie", 6.99);
		casaMadre.aggiungiArticolo("Fejka", "Pianta artificiale interno/esterno albero di Natale", 49.99);
		
		casaMadre.esponiArticoloInNegozio(nA, pX);
		casaMadre.esponiArticoloInNegozio(nB, pX);
		
		System.out.println();
		System.out.println("Elenco negozi che espongono l'articolo codice "+pX+":");
		System.out.println(casaMadre.elencoNegozi(pX));
		
		System.out.println();
		System.out.println("Elenco articoli che sono esposti in piu' di 1 negozio:");
		System.out.println(casaMadre.elencoArticoliEspostiInPiuDiTotNegozi(1));
	}
}
