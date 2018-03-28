import impianto.*;
import java.util.Arrays;
public class Esempio {

	public static void main(String args[]){
		
		Impianto i = new Impianto();

		// 1) si definiscono i componenti
		Sorgente sorgente = new Sorgente("Sorgente", "sorgente dell'impianto di irrigazione");
		i.aggiungiComponente(sorgente);
		Valvola valvola = new Valvola("Valvola", "prima valvolai");
		i.aggiungiComponente(valvola);
		Irrigatore irrigatore = new Irrigatore("Irrigatore", "primo irrigatore");
		i.aggiungiComponente(irrigatore);
		Sdoppiatore sdoppiatore = new Sdoppiatore("Sdoppiatore","primo sdoppiatore");
		//i.aggiungiComponente(sdoppiatore);

		System.out.println("___________________________________________");
		System.out.print("Array impianto: ");
		System.out.println(Arrays.toString(i.getComponenti()));
		System.out.println("___________________________________________");
		System.out.print("Cerco componente esistente: ");
		System.out.println(i.cercaComponente("volai"));
		System.out.print("Cerco componente esistente: ");
		System.out.println(i.cercaComponente("gatore"));
		System.out.print("Cerco componente inesistente: ");
		System.out.println(i.cercaComponente("dfghjk"));
		System.out.println("___________________________________________");
		
		// 2) si collegano
		sorgente.collega(valvola);
		valvola.collega(irrigatore);
		irrigatore.collega(sorgente);
		//sdoppiatore.collega(sorgente,1);
		
		System.out.println("___________________________________________");
		System.out.println("Uscita sorgente: "+sorgente.getUscita());
		System.out.println("Uscita valvola: "+valvola.getUscita());
		System.out.println("Uscita irrigatore: "+irrigatore.getUscita());
		//System.out.println("Uscita sdoppiatore2: "+Arrays.toString(sdoppiatore.getUscite()));
		System.out.println("___________________________________________");
		
		// 3) si definiscono i parametri
		sorgente.setPortata(30);
		valvola.setAperta(true);
		
		// 4) si calcola la portata
		System.out.println(i.calcola());
		
		Impianto j = new Impianto();
		
		Sorgente sorgentej = new Sorgente("Sorgente", "sorgente dell'impianto di irrigazione");
		Valvola valvolaj = new Valvola("Valvola", "prima valvolai");
		Irrigatore irrigatorej1 = new Irrigatore("Irrigatore1", "primo irrigatore");
		Irrigatore irrigatorej2 = new Irrigatore("Irrigatore2", "primo irrigatore");
		Sdoppiatore sdoppiatorej1 = new Sdoppiatore("Sdoppiatore1","primo sdoppiatore");
		Sdoppiatore sdoppiatorej2 = new Sdoppiatore("Sdoppiatore2","primo sdoppiatore");
		Irrigatore irrigatorej3 = new Irrigatore("Irrigatore3", "primo irrigatore");
		
		/* NON IN ORDINE
		j.aggiungiComponente(sorgentej);
		j.aggiungiComponente(valvolaj);
		j.aggiungiComponente(sdoppiatorej1);
		j.aggiungiComponente(irrigatorej1);
		j.aggiungiComponente(irrigatorej2);
		j.aggiungiComponente(sdoppiatorej2);
		j.aggiungiComponente(irrigatorej3);
		*/
		j.aggiungiComponente(sorgentej);
		j.aggiungiComponente(valvolaj);
		j.aggiungiComponente(sdoppiatorej1);
		j.aggiungiComponente(irrigatorej1);
		j.aggiungiComponente(sdoppiatorej2);
		j.aggiungiComponente(irrigatorej2);
		j.aggiungiComponente(irrigatorej3);
		System.out.println("Secondo impianto___________________________");
		System.out.print("Array impianto: ");
		System.out.println(Arrays.toString(j.getComponenti()));
		System.out.println("___________________________________________");
		sorgentej.collega(valvolaj);
		valvolaj.collega(sdoppiatorej1);	
		sdoppiatorej1.collega(irrigatorej1,0);
		sdoppiatorej1.collega(sdoppiatorej2,1);
		sdoppiatorej2.collega(irrigatorej2,0);
		sdoppiatorej2.collega(irrigatorej3,1);

		sorgentej.setPortata(30);
		valvolaj.setAperta(true);
		
		System.out.println(j.calcola());
		
	}
}
