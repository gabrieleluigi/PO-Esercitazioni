import grandedistribuzione.*;

//import java.util.Arrays;

public class Esempio {

	public static void main(String[] args) {
		
		String nomeCasaMadre = "IKEA";
		String indirizzoCasaMadre = "Danimarca";
		String numeroTelefonoCasaMadre = "004532";
		String sitoWebCasaMadre = "www.ikea.com";
		
		CasaMadre casaMadre = new CasaMadre(nomeCasaMadre, indirizzoCasaMadre, numeroTelefonoCasaMadre, sitoWebCasaMadre);
		
		System.out.println("Creata casa madre " + casaMadre.getNome() + " con indirizzo "+casaMadre.getIndirizzo()+" numero di telefono "+casaMadre.getNumeroTelefono()+ " e sito Web "+casaMadre.getSitoWeb());
		
		int nA = casaMadre.aggiungiNegozio("Collegno", "Viale Svezia 10", 100);
		int nB = casaMadre.aggiungiNegozio("Milano San Giuliano", "Via Po 3", 500);
		int nC = casaMadre.aggiungiNegozio("Roma Anagnina", "Via Fattoria Rampa 35", 800);
		
		System.out.println();
		System.out.println("Codici negozi aggiunti: ");
		System.out.println(nA);
		System.out.println(nB);
		System.out.println(nC);
		
		System.out.println();
		System.out.println("Negozio con il primo codice: " + casaMadre.negozio(nA));
		System.out.println("Negozio non presente nel database: " + casaMadre.negozio(36));
		System.out.println("Negozio piu' grande: " + casaMadre.negozioPiuGrande());
		
		int pX = casaMadre.aggiungiArticolo("Vinter 2017", "Illuminazione decorativa a LED a batterie", 6.99);
		int pY = casaMadre.aggiungiArticolo("Fejka", "Pianta artificiale interno/esterno albero di Natale", 49.99);
		int pZ = casaMadre.aggiungiArticolo("Poang", "Poltrona da interno", 99.99);
		
		System.out.println("Articolo non presente nel database: " + casaMadre.articolo(105));
		
		System.out.println("Articolo piu' economico: " + casaMadre.articoloPiuEconomico());
		
		//casaMadre.printArray();
		
		System.out.println();
		System.out.println("Espongo: " +pX+ " in " +nA);
		casaMadre.esponiArticoloInNegozio(nA, pX);
		System.out.println("Espongo di nuovo: " +pX+ " in " +nA);
		casaMadre.esponiArticoloInNegozio(nA, pX);
		System.out.println("Espongo: " +pX+ " in " +nB);
		casaMadre.esponiArticoloInNegozio(nB, pX);
		System.out.println("Espongo: " +pY+ " in " +nB);
		casaMadre.esponiArticoloInNegozio(nB, pY);
		System.out.println("Espongo: " +pZ+ " in " +nB);
		casaMadre.esponiArticoloInNegozio(nB, pZ);
		System.out.println("Espongo: " +pZ+ " in " +nA);
		casaMadre.esponiArticoloInNegozio(nA, pZ);
		System.out.println("Espongo: " +pX+ " in " +nC);
		casaMadre.esponiArticoloInNegozio(nC, pX);
		System.out.println("Espongo di nuovo: " +pX+ " in " +nC);
		casaMadre.esponiArticoloInNegozio(nC, pX);
		
		System.out.println();
		System.out.print("Numero articoli in negozio "+nA+":");
		System.out.println(casaMadre.numeroArticoli(nA));
		System.out.print("Numero articoli in negozio "+nB+":");
		System.out.println(casaMadre.numeroArticoli(nB));
		System.out.print("Numero articoli in negozio "+nC+":");
		System.out.println(casaMadre.numeroArticoli(nC));
		System.out.print("Numero articoli in negozio 239:");
		System.out.println(casaMadre.numeroArticoli(239));
		
		System.out.println();
		System.out.print("Numeri negozi che vendono "+pX+":");
		System.out.println(casaMadre.numeroNegozi(pX));
		System.out.print("Numeri negozi che vendono "+pY+":");
		System.out.println(casaMadre.numeroNegozi(pY));
		System.out.print("Numeri negozi che vendono "+pZ+":");
		System.out.println(casaMadre.numeroNegozi(pZ));
		System.out.print("Numeri negozi che vendono 239:");
		System.out.println(casaMadre.numeroNegozi(239));
		
		System.out.println();
		System.out.println("Elenco negozi che espongono l'articolo codice "+pX+":");
		System.out.print(casaMadre.elencoNegozi(pX));
		System.out.println("Elenco negozi che espongono l'articolo codice "+pY+":");
		System.out.print(casaMadre.elencoNegozi(pY));
		System.out.println("Elenco negozi che espongono l'articolo codice "+pZ+":");
		System.out.print(casaMadre.elencoNegozi(pZ));
		System.out.println("Elenco negozi che espongono l'articolo codice 239:");
		System.out.print(casaMadre.elencoNegozi(239));
		
		System.out.println();
		System.out.println("Elenco articoli esposti nel negozio "+nA+":");
		System.out.print(casaMadre.elencoArticoli(nA));
		System.out.println("Elenco articoli esposti nel negozio "+nB+":");
		System.out.print(casaMadre.elencoArticoli(nB));
		System.out.println("Elenco articoli esposti nel negozio "+nC+":");
		System.out.print(casaMadre.elencoArticoli(nC));
		System.out.println("Elenco articoli esposti nel negozio 239:");
		System.out.print(casaMadre.elencoArticoli(239));
		
		System.out.println();
		System.out.println("Elenco negozi che espongono piu' di 2 articoli:");
		System.out.print(casaMadre.elencoNegoziCheEspongonoPiuDiTotArticoli(2));
		System.out.println("ACapo");
		System.out.println();
		System.out.println("Elenco articoli che sono esposti in piu' di 2 negozio:");
		System.out.print(casaMadre.elencoArticoliEspostiInPiuDiTotNegozi(2));
		System.out.println("ACapo");
		}
}
