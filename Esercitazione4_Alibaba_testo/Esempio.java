import alibaba.*;

public class Esempio {

	public static void main(String[] args){
			
		Alibaba a = new Alibaba();
		String codice1 = "6XW"; 
		String codice2 = "1CI"; 
		String codice3 = "0SF"; 
		String codice4 = "75L";
		String codice5 = "75E"; //codice associato a nessun prodotto

		a.aggiungiProdotto(codice1, "Samsung Galaxy S8 Smartphone", "Fotocamera: 12 MP, memoria 64GB espandibili", "Nero", 501.0);
		a.aggiungiProdotto(codice2, "Raspberry Pi 3", "Official Desktop Starter Kit", "Nero", 52.5);
		a.aggiungiProdotto(codice3, "iRobot Roomba 871", "Aspirapolvere robot domestico", "Grigio", 659.99);
		a.aggiungiProdotto(codice4, "Apple iPhone X", "Single SIM 4G 64GB", "Grigio", 1100.0);
	    
	    System.out.println("Prodotto "+codice1+": nome " + a.getNome(codice1)+
	    		", descrizione "+a.getDescrizione(codice1) + 
	    		", colore "+a.getColore(codice1)+ 
	    		", prezzo "+a.getPrezzo(codice1));
	    System.out.println("Prodotto "+codice4+": nome " + a.getNome(codice4)+
	    		", descrizione "+a.getDescrizione(codice4) + 
	    		", colore "+a.getColore(codice4)+ 
	    		", prezzo "+a.getPrezzo(codice4));
	    System.out.println("Prodotto "+codice5+": nome " + a.getNome(codice5)+
	    		", descrizione "+a.getDescrizione(codice5) + 
	    		", colore "+a.getColore(codice5)+ 
	    		", prezzo "+a.getPrezzo(codice5));
	    
	    a.creaCartaDiCredito(12, 1000.0);
	    a.creaCartaDiCredito(3, 1500.0);
	    a.creaCartaDiCredito(5, 500.0);
	    System.out.println("Credito della tessera 5: "+a.getCredito(5));
	    a.creaCartaDiCredito(15, 800.0);
	    a.creaCartaDiCredito(5, 55.0);
	    
	    System.out.println("Credito della tessera 12: "+a.getCredito(12));
	    System.out.println("Credito della tessera 5: "+a.getCredito(5));
	    System.out.println("Credito della tessera 115: "+a.getCredito(115));
	    
	    a.aggiungiNegozio("IT1007", "DIEMME SERVICE", "via Boezio 6, Roma, IT", 4);
	    a.aggiungiNegozio("IT990", "Almost Anything Ltd", "Thornaby, Cecil Avenue, Salisbury, GB", 100);
	    a.aggiungiNegozio("CN96", "ILIFERobot", "Business Center, Lijincheng Industrial Park, East of Gongye Road, Longhua, Shenzhen, China", 300);
	    
	    a.esponiProdotto("IT1007", codice1);
	    a.esponiProdotto("IT1007", codice1);
	    a.esponiProdotto("IT1007", codice1);
	    a.esponiProdotto("IT1007", codice1);
	    a.esponiProdotto("IT1007", codice1);
	    a.esponiProdotto("IT990", codice2);
	    a.esponiProdotto("IT990", codice1);
	    a.esponiProdotto("CN96", codice3);
	    a.esponiProdotto("IT1007", codice4);
	    a.esponiProdotto("CN96", codice1);
	    a.esponiProdotto("CN96", codice2);
	    
	    System.out.println("Disponibilita' di Samsung Galaxy S8 nel negozio DIEMME SERVICE: "+a.getDisponibilita("IT1007", codice1));
	    System.out.println("Disponibilita' di Samsung Galaxy S8 in tutti i negozi: "+a.getDisponibilita(codice1));
	    System.out.println("Disponibilita' di cosice2 nel negozio CN96: "+a.getDisponibilita("CN96", codice2));
	    System.out.println("Disponibilita' di codice2 in tutti i negozi: "+a.getDisponibilita(codice2));
	    
	    System.out.println("-----Situazione pre acquisto:");
	    System.out.println("Credito della tessera 12: "+a.getCredito(12));
	    System.out.println("Disponibilita' di Samsung Galaxy S8 nel negozio DIEMME SERVICE: "+a.getDisponibilita("IT1007", codice1));
	    System.out.println("Disponibilita' di Samsung Galaxy S8 in tutti i negozi: "+a.getDisponibilita(codice1));
	    
	    a.acquistaProdotto(codice1, "IT1007", 12);
	    System.out.println("----->>>>>>> Prezzo articolo acquistato: "+a.getPrezzo(codice1));
	    
	    System.out.println("-----Situazione post acquisto:");
	    System.out.println("Credito della tessera 12: "+a.getCredito(12));
	    System.out.println("Disponibilita' di Samsung Galaxy S8 nel negozio DIEMME SERVICE: "+a.getDisponibilita("IT1007", codice1));
	    System.out.println("Disponibilita' di Samsung Galaxy S8 in tutti i negozi: "+a.getDisponibilita(codice1));
	    
	}
}
