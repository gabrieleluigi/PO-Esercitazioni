package esercito;

import java.util.Comparator;

public class ComparatoreDiSoldatiPerCognomeNomeDataNascita implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		Militare m1 = (Militare)o1;
		Militare m2 = (Militare)o2;
		
		int diffCognome = m1.getCognome().compareTo(m2.getCognome());
		if (diffCognome != 0)
			return diffCognome;
		
		int diffNome = m1.getNome().compareTo(m2.getNome());
		if (diffNome != 0)
			return diffNome;

		return m1.getDataNascita().compareTo(m2.getDataNascita());
	}
}
