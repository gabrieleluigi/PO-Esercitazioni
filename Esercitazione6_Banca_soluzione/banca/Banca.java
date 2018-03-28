package banca;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Banca {
	
	private int codiceConto = 1;
	private int codiceTransazione = 0;
	
	private Map<Integer, ContoCorrente> contiCorrenti = new HashMap<Integer, ContoCorrente>();
	private Map<Integer, Transazione> transazioni = new TreeMap<Integer, Transazione>();
	
	
	public int aggiungiContoCorrente(String nomeIntestatario, String cognomeIntestatario, Double saldoIniziale) {
		ContoCorrente c = new ContoCorrente(codiceConto, nomeIntestatario, cognomeIntestatario, saldoIniziale);
		contiCorrenti.put(codiceConto, c);
		codiceConto++;
		return c.getCodiceConto();
	}
	
	public ContoCorrente getContoCorrente(int codiceContoCorrente) throws ErrContoInesistente{
		if (contiCorrenti.containsKey(codiceContoCorrente))
			return contiCorrenti.get(codiceContoCorrente);
		throw new ErrContoInesistente();
	}

	public boolean stringaCorretta(String stringa){
		if (stringa != null && stringa.compareTo("") != 0)
			return true;
		return false;
	}
	
	
	public void effettuaBonifico(int codiceContoCorrenteOrigine, int codiceContoCorrenteDestinazione, 
			Double importo, String data) 
			throws ErrContoScoperto, ErrContoInesistente {
		
		// trovo il primo conto corrente
		ContoCorrente origine = getContoCorrente(codiceContoCorrenteOrigine);
		
		// trovo il secondo conto corrente
		ContoCorrente destinazione = getContoCorrente(codiceContoCorrenteDestinazione);
		
		if (importo > 0.0 && stringaCorretta(data)){
			// se ho soldi
			if (origine.getSaldo() >= importo){
				Transazione t = new Bonifico(codiceTransazione, origine, importo, data, destinazione);
				transazioni.put(codiceTransazione, t);
				codiceTransazione++;
			}
			else
				throw new ErrContoScoperto();
		}
	}
	
	public void effettuaRicaricaCellulare(int codiceContoCorrenteOrigine, String numeroCellulare, 
			Double importo, String data) 
			throws ErrContoScoperto, ErrContoInesistente {

		ContoCorrente origine = getContoCorrente(codiceContoCorrenteOrigine);
		if (importo > 0.0 && stringaCorretta(numeroCellulare) && stringaCorretta(data)){
			if (origine.getSaldo() >= importo){
				Transazione t = new RicaricaCellulare(codiceTransazione, origine, importo, data, numeroCellulare);
				transazioni.put(codiceTransazione, t);
				codiceTransazione++;
			}
			else
				throw new ErrContoScoperto();
		}
	}

	public Collection<ContoCorrente> elencoContiCorrentiPerCodiceCrescente(){
		return contiCorrenti.values();
	}
}
