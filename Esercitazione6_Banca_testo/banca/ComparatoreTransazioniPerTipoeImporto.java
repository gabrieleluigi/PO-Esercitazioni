package banca;

import java.util.Comparator;

public class ComparatoreTransazioniPerTipoeImporto implements Comparator<Transazione> {

	@Override
	public int compare(Transazione t1, Transazione t2) {
		/*ordino prima per tipo poi per importo
		int tipo = t1.getClass().getSimpleName().compareTo(t2.getClass().getSimpleName());
		if(tipo!=0)
			return tipo;
		else
			return -(int)(t1.getImporto()-t2.getImporto());*/
		
		// se la prima transazione e' un bonifico e la seconda una ricarica
		// viene prima la prima
		if (t1 instanceof Bonifico && t2 instanceof RicaricaCellulare)
			return -1;
				
		// altrimenti (se vale il contrario)
		// viene prima la seconda
		if (t1 instanceof RicaricaCellulare && t2 instanceof Bonifico)
			return 1;
				
		return - t1.getImporto().compareTo(t2.getImporto());
	}
}
