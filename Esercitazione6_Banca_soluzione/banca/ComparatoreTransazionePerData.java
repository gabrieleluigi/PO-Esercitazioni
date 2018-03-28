package banca;

import java.util.Comparator;

public class ComparatoreTransazionePerData implements Comparator<Transazione>{

	@Override
	public int compare(Transazione a, Transazione b) {
		return - a.getData().compareTo(b.getData());
	}
	

}
