package banca;

import java.util.Comparator;

public class ComparatoreTransazioniPerTipoeImporto implements Comparator<Transazione>{

	@Override
	public int compare(Transazione a, Transazione b) {
		
		// se la prima transazione e' un bonifico e la seconda una ricarica
		// viene prima la prima
		if (a instanceof Bonifico && b instanceof RicaricaCellulare)
			return -1;
		
		// altrimenti (se vale il contrario)
		// viene prima la seconda
		if (a instanceof RicaricaCellulare && b instanceof Bonifico)
			return 1;
		
		return - a.getImporto().compareTo(b.getImporto());
	}
	

}
