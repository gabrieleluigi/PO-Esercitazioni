package banca;

import java.util.Comparator;

public class ComparatoreContiCorrentiPerSaldoDecrescente implements Comparator<ContoCorrente> {

	@Override
	public int compare(ContoCorrente cc1, ContoCorrente cc2) {
		return -(int)(cc1.getSaldo()-cc2.getSaldo());
	}

}
