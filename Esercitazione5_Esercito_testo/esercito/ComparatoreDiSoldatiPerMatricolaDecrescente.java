package esercito;

import java.util.Comparator;

public class ComparatoreDiSoldatiPerMatricolaDecrescente implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		Militare m1 = (Militare)o1;
		Militare m2 = (Militare)o2;
		
		return -(m1.getMatricola()-m2.getMatricola());
	}
}
