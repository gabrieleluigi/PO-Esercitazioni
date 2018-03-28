package banca;

import java.util.Comparator;

public class ComparatoreTransazioniPerData implements Comparator<Transazione> {

	@Override
	public int compare(Transazione t1, Transazione t2) {
		return t1.getData().compareTo(t2.getData());
	}

}
