package grandedistribuzione;

//import java.util.Arrays;

public class CasaMadre {
	
	private String nome;
	private String indirizzo;
	private String numeroTelefono;
	private String sitoWeb;
	
	private Negozio[] arrayNegozi;
	private int i;
	
	private Articolo[] arrayArticoli;
	private int j;
	
	public CasaMadre(String nome, String indirizzo, String numeroTelefono, String sitoWeb){
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numeroTelefono = numeroTelefono;
		this.sitoWeb = sitoWeb;
		
		arrayNegozi = new Negozio[20];
		i = 0;
		
		arrayArticoli = new Articolo[1000];
		j = 0;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getIndirizzo(){
		return this.indirizzo;
	}
	
	public String getNumeroTelefono(){
		return this.numeroTelefono;
	}
	
	public String getSitoWeb(){
		return this.sitoWeb;
	}
	
	public int aggiungiNegozio(String nome, String indirizzo, int numeroArticoliEsponibili){
		if(i < arrayNegozi.length) {
			arrayNegozi[i] = new Negozio(i+1,nome,indirizzo,numeroArticoliEsponibili);
			i++;
			return i;
		}
		else
			return 0;
	}
	
	public String negozio(int codice){
		if(checkNegozio(codice) == true)
			return arrayNegozi[codice-1].toString();
		else
			return "";
	}
	
	public String negozioPiuGrande(){
		int codiceMax = arrayNegozi[0].getCodice();
		double max = arrayNegozi[0].getNumeroArticoliEsponibili();
		
		for(int l = 1; l < i; l++) {
			if(arrayNegozi[l].getNumeroArticoliEsponibili() > max) {
				max = arrayNegozi[l].getNumeroArticoliEsponibili();
				codiceMax = arrayNegozi[l].getCodice();
			}
		}
		return new String(negozio(codiceMax));
	}
	
	public int aggiungiArticolo(String nome, String descrizione, double prezzo){
		if(j < arrayArticoli.length) {
			arrayArticoli[j] = new Articolo(j+100,nome,descrizione,prezzo);
			j++;
			return j+99;
		}
		else
			return 0;
	}
	
	public String articolo(int codice){
		if(checkArticolo(codice) == true)
			return arrayArticoli[codice-100].toString();
		else
			return "";
	}
	
	public String articoloPiuEconomico(){
		int codiceMin = arrayArticoli[0].getCodice();
		double min = arrayArticoli[0].getPrezzo();
		
		for(int m = 1; m < j; m++) {
		 	if(arrayArticoli[m].getPrezzo() < min) {
		 		min = arrayArticoli[m].getPrezzo();
				codiceMin = arrayArticoli[m].getCodice();
			}
		}
		return new String(articolo(codiceMin));
	}
	
	public void esponiArticoloInNegozio(int codiceNegozio, int codiceArticolo){
		codiceNegozio -= 1;
		if(arrayNegozi[codiceNegozio].getNumeroArticoli() < arrayNegozi[codiceNegozio].getNumeroArticoliEsponibili() && arrayNegozi[codiceNegozio].checkArticoloInNegozio(codiceArticolo) == false) {
			codiceArticolo -= 100;
			arrayArticoli[codiceArticolo].esponiInNegozio(arrayNegozi[codiceNegozio]);
			arrayNegozi[codiceNegozio].esponeArticoli(arrayArticoli[codiceArticolo]);
		}
	}
	
	public String elencoNegozi(int codiceArticolo){
		if(checkArticolo(codiceArticolo) == true) {
			codiceArticolo-=100;
			String s = new String();
			Negozio arr[] = arrayArticoli[codiceArticolo].getArticoliInNegozio();
		
			for(int k = 0; k < arrayArticoli[codiceArticolo].getNumeroNegozi(); k++)
				s += negozio(arr[k].getCodice())+"\n";
			return cutString(s);
		}
		else
			return "";
	}

	public String elencoArticoli(int codiceNegozio){
		if(checkNegozio(codiceNegozio) == true) {
			codiceNegozio-=1;
			String s = new String();
			Articolo arr[] = arrayNegozi[codiceNegozio].getNegozioEsponeArticoli();
		
			for(int k = 0; k < arrayNegozi[codiceNegozio].getNumeroArticoli(); k++)
				s += articolo(arr[k].getCodice())+"\n";
			return cutString(s);
		}
		else
			return "";
	}

	public int numeroNegozi(int codiceArticolo){
		if(checkArticolo(codiceArticolo) == true)
			return arrayArticoli[codiceArticolo-100].getNumeroNegozi();
		else
			return 0;
	}

	public int numeroArticoli(int codiceNegozio){
		if(checkNegozio(codiceNegozio) == true)
			return arrayNegozi[codiceNegozio-1].getNumeroArticoli();
		else	
			return 0;
	}

	public String elencoNegoziCheEspongonoPiuDiTotArticoli(int numArticoli){
		String s = new String();
		
		for(int l = 0; l < i; l++)
			if(arrayNegozi[l].getNumeroArticoli() >= numArticoli) 
					s += arrayNegozi[l].toString() + "\n";
		return cutString(s);
	}

	public String elencoArticoliEspostiInPiuDiTotNegozi(int numNegozi){
		String s = new String();	
		
		for(int m = 0; m < j; m++) 
			if(arrayArticoli[m].getNumeroNegozi() >= numNegozi)
				s += arrayArticoli[m].toString() + "\n";
		return cutString(s);
	}
	
	public boolean checkNegozio(int codice) {
		for(int l = 0; l < i; l++)
			if(arrayNegozi[l].getCodice() == codice)
				return true;
		return false;
	}
	
	public boolean checkArticolo(int codice) {
		for(int m = 0; m < j; m++) 
			if(arrayArticoli[m].getCodice() == codice) 
				return true;
		return false;
	}
	
	public String cutString(String s) {
		return s.substring(0, s.length() - 1);
	}
	
/*	
	public void printArray() {
		System.out.println("___________________________________________");
		System.out.print("Array Negozi: ");
		System.out.println(Arrays.toString(arrayNegozi));
		System.out.print("Array Articoli: ");
		System.out.println(Arrays.toString(arrayArticoli));
		System.out.println("___________________________________________");
	}
*/
}



