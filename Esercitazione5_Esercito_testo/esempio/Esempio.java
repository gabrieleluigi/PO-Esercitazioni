package esempio;

import esercito.GestioneEsercito;

public class Esempio {

	public static void main(String[] args) {
		
		GestioneEsercito ge = new GestioneEsercito();
		
		ge.aggiungiMilitare("Luigi", "Verdi", "19960827");
		System.out.println("Militare inserito: "+ge.getMilitare(100)+": "+ge.getMilitare(100).getMatricola()+" "+ge.getMilitare(100).getNome()+" "+ge.getMilitare(100).getCognome()+" "+ge.getMilitare(100).getDataNascita());
		
		System.out.println("Risultato inserimento nullo: "+ge.aggiungiMilitare(null, "Rossi", "19960827"));
		System.out.println("Militare con matricola inesistente: "+ge.getMilitare(111));
		
		ge.aggiungiMilitare("Luigi", "Verdi", "19960104");
		System.out.println("Militare inserito: "+ge.getMilitare(101)+": "+ge.getMilitare(101).getMatricola()+" "+ge.getMilitare(101).getNome()+" "+ge.getMilitare(101).getCognome()+" "+ge.getMilitare(101).getDataNascita());
		
		ge.aggiungiComandante("Lorenzo", "Neri", "19940707", "Ufficiale");
		System.out.println("Comndante inserito: "+ge.getComandante(102)+": "+ge.getComandante(102).getMatricola()+" "+ge.getComandante(102).getNome()+" "+ge.getComandante(102).getCognome()+" "+ge.getComandante(102).getDataNascita()+" "+ge.getComandante(102).getGrado());
		
		System.out.println("Risultato inserimento nullo: "+ge.aggiungiComandante("Luigi", "Rossi", "19960827", null));
		System.out.println("Comandante con matricola inesistente: "+ge.getComandante(111));
		
		ge.aggiungiComandante("Alberto", "Bianchi", "19941225", "Generale");
		System.out.println("Comndante inserito: "+ge.getComandante(103)+": "+ge.getComandante(103).getMatricola()+" "+ge.getComandante(103).getNome()+" "+ge.getComandante(103).getCognome()+" "+ge.getComandante(103).getDataNascita()+" "+ge.getComandante(103).getGrado());
		
		ge.aggiungiSquadra("SquadraTorino");
		System.out.println("Squadra inserita: "+ge.getSquadra("SquadraTorino")+" ["+ge.getSquadra("SquadraTorino").getNomeSquadra()+"]");
		 
		ge.aggiungiSquadra("SquadraTorino");
		
		ge.aggiungiSquadra("SquadraMilano");
		System.out.println("Squadra inserita: "+ge.getSquadra("SquadraMilano")+" ["+ge.getSquadra("SquadraMilano").getNomeSquadra()+"]");
		
		ge.assegnaASquadra(100, "SquadraTorino");
		ge.assegnaASquadra(101, "SquadraTorino");
		ge.assegnaASquadra(102, "SquadraTorino");
		ge.assegnaASquadra(101, "SquadraMilano");
		ge.assegnaASquadra(103, "SquadraMilano");
		ge.assegnaASquadra(100, "SquadraVenezia");
		
		System.out.println("Militare 100, nome squadra:"+ge.getMilitare(100).getNomeSquadra());
		System.out.println("Componenti SquadraTorino: "+ge.getSquadra("SquadraTorino").getComponenti());
		System.out.println("Componenti SquadraMilano: "+ge.getSquadra("SquadraMilano").getComponenti());
		
		
		ge.assegnaComandante(103, 101);
		ge.assegnaComandante(103, 100);
		ge.assegnaComandante(102, 101);
		ge.assegnaComandante(101, 101);
		ge.assegnaComandante(101, 100);
		ge.assegnaComandante(103, 102);
		
		System.out.println("Comandante di 103: "+ge.getMilitare(103).getComandante());
		System.out.println("Comandante di 102: "+ge.getMilitare(102).getComandante().getMatricola());
		System.out.println("Comandante di 101: "+ge.getMilitare(101).getComandante().getMatricola());
		System.out.println("Comandante di 100: "+ge.getMilitare(100).getComandante().getMatricola());
		
		//ge.getComandante(103).getSoldati();
	}

}
