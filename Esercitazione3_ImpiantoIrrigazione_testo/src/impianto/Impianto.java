package impianto;

import java.util.Arrays;

public class Impianto {

	private Componente[] arrayComponenti;
	private int prossimo_impianto;
	private final int MAX_COMPONENTI = 40;
	
	public Impianto(){
		arrayComponenti = new Componente[MAX_COMPONENTI];
		prossimo_impianto = 0;
	}
	
	public void aggiungiComponente(Componente componente){
		arrayComponenti[prossimo_impianto] = componente;
		prossimo_impianto++;
	}
	
	public Componente[] getComponenti(){
		return arrayComponenti;
	}
	
	public Componente cercaComponente(String daCercare){
		for(int i = 0; i < MAX_COMPONENTI; i++) {
			if(arrayComponenti[i] == null) 
				break;
			else if(arrayComponenti[i].getNome().contains(daCercare) || arrayComponenti[i].getDescrizione().contains(daCercare))
				return arrayComponenti[i];
		}
		return null;
	}
	
	public Componente[] ordinamentoSistema(){
		
		// -s
		// _i _s
		// _i _i
		Componente[] tempComponenti = new Componente[2];
		Componente[] componentiOrdinati = new Componente[MAX_COMPONENTI];
		
		int nextComponete = 0;
		
		for(int i=0; i<MAX_COMPONENTI; i++) {
			if(arrayComponenti[i] instanceof Sorgente) { 
				tempComponenti[0]=arrayComponenti[i];
				break;
			}
		}
		
		componentiOrdinati[nextComponete] = tempComponenti[0];
		tempComponenti[0] = tempComponenti[0].getUscita();
		nextComponete++;
		int j;
		while(isEmpty(tempComponenti) != true) {

			j = 0;

			while(j<tempComponenti.length) {
				if(tempComponenti[j] != null) {
					if(tempComponenti[j] instanceof Valvola) {
						componentiOrdinati[nextComponete] = tempComponenti[j];
						tempComponenti[0] = tempComponenti[j].getUscita();
						nextComponete++;
						j++;
						break;
					}
					if(tempComponenti[j] instanceof Irrigatore) {
						componentiOrdinati[nextComponete] = tempComponenti[j];
						tempComponenti[0] = tempComponenti[j].getUscita();
						nextComponete++;
						j++;
						break;
					}
					if(tempComponenti[j] instanceof Sdoppiatore) {
						componentiOrdinati[nextComponete] = tempComponenti[j];
						nextComponete++;
						Componente[] arr = new Componente[2];
						arr = ((Sdoppiatore) tempComponenti[j]).getUscite();
						tempComponenti[0] = arr[0];
						tempComponenti[1] = arr[1];
					}
				}
				else
					j++;
			}
		}
		return componentiOrdinati;
	}
	
	private boolean isEmpty(Componente[] tempComponenti) {
		  if (tempComponenti[0] != null && tempComponenti[0] != null) 
			  return false;
		  else
			  return true;
	}

	public String calcola(){
		
		String s = new String();
		
		Componente[] componentiOrdinati = ordinamentoSistema();
		System.out.println(Arrays.toString(ordinamentoSistema()));
		
		if(componentiOrdinati[0] instanceof Sorgente) {
			double portata = ((Sorgente) componentiOrdinati[0]).getPortata();
			s += stampa(componentiOrdinati[0],portata)+"\n";
			for(int i=1; i<componentiOrdinati.length; i++) {
				if(componentiOrdinati[i] != null)
				{
					if(componentiOrdinati[i] instanceof Valvola) {
						s += stampa(componentiOrdinati[i],portata);
						if(((Valvola) componentiOrdinati[i]).isAperta() == false)
							portata = 0;
						s += "-"+portata+"\n";
					}
					if(componentiOrdinati[i] instanceof Irrigatore)
						s += stampa(componentiOrdinati[i],portata)+"\n";
					if(componentiOrdinati[i] instanceof Sdoppiatore) {
						s += stampa(componentiOrdinati[i],portata);
						portata = portata/2;
						s += "-"+portata+"-"+portata+"\n";
					}
				}
			}
		}
		return s;
	}
	
	public String stampa(Componente componente, double portata) {
		return componente.getNome()+"-"+portata;
	}
	
}












