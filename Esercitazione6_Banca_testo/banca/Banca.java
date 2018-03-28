package banca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Banca {
	
	private Map<Integer, ContoCorrente> mappaCC = new HashMap<Integer, ContoCorrente>();
	private Map<Integer, Transazione> mappaT = new HashMap<Integer, Transazione>();
	
	private final int CODICE_CONTO_INIZIALE = 1;
	private final int CODICE_TRANSAZIONE_INIZIALE = 0;
	
	private int codiceConto = CODICE_CONTO_INIZIALE;
	private int codiceTransazione = CODICE_TRANSAZIONE_INIZIALE;

	public int aggiungiContoCorrente(String nomeIntestatario, String cognomeIntestatario, Double saldoIniziale) {
		ContoCorrente tcc = new ContoCorrente(codiceConto,nomeIntestatario,cognomeIntestatario,saldoIniziale);
		mappaCC.put(codiceConto, tcc);
		codiceConto++;
		return tcc.getCodiceConto();
	}
	
	public ContoCorrente getContoCorrente(int codiceContoCorrente) throws ErrContoInesistente{
		if(mappaCC.containsKey(codiceContoCorrente))
			return mappaCC.get(codiceContoCorrente);
		throw new ErrContoInesistente();
	}
	
	public void effettuaBonifico(int codiceContoCorrenteOrigine, int codiceContoCorrenteDestinazione, 
			Double importo, String data) 
			throws ErrContoScoperto, ErrContoInesistente {
		
		ContoCorrente occ = getContoCorrente(codiceContoCorrenteOrigine);
		ContoCorrente dcc = getContoCorrente(codiceContoCorrenteDestinazione);
		
		if(occ.getSaldo() >= importo) {
			mappaT.put(codiceTransazione, new Bonifico(codiceTransazione, occ, importo, data, dcc));
			occ.decrementaSaldo(importo);
			dcc.incrementaSaldo(importo);
			codiceTransazione++;
		}
		else
			throw new ErrContoScoperto();
			
	}
	
	public void effettuaRicaricaCellulare(int codiceContoCorrenteOrigine, String numeroCellulare, 
			Double importo, String data) 
			throws ErrContoScoperto, ErrContoInesistente {
		
		ContoCorrente occ = getContoCorrente(codiceContoCorrenteOrigine);
		
		if(occ.getSaldo() >= importo) {
			mappaT.put(codiceTransazione, new RicaricaCellulare(codiceTransazione, occ, importo, data, numeroCellulare));
			occ.decrementaSaldo(importo);
			codiceTransazione++;
		}
		else
			throw new ErrContoScoperto();
		
	}
	
	public String getInformazioniTransazione(int codiceTransazione){
		Transazione ttemp = mappaT.get(codiceTransazione);
		return ttemp.toString();
	}

	public Collection<ContoCorrente> elencoContiCorrentiPerSaldoDecrescente(){
		List<ContoCorrente> cctemp = new LinkedList<ContoCorrente>(mappaCC.values());
		Collections.sort(cctemp, new ComparatoreContiCorrentiPerSaldoDecrescente());
		return cctemp;
	}
	
	public Collection<Transazione> elencoTransazioniPerData(int codiceContoCorrente) throws ErrContoInesistente{
		ContoCorrente c1 = getContoCorrente(codiceContoCorrente);// Controllo inserito per ErrContoInesistente (controllo gia' eseguito nel metodo getContoCorrente)
		List<Transazione> ttemp = new LinkedList<Transazione>(mappaT.values());
		List<Transazione> fttemp = new LinkedList<Transazione>();
		for(Transazione t: ttemp)
			if(t.getOrigine().getCodiceConto() == codiceContoCorrente)
				fttemp.add(t);
		Collections.sort(fttemp, new ComparatoreTransazioniPerData());
		return fttemp;
		
	}
	
	public Collection<Transazione> elencoTransazioniPerTipoeImporto(int codiceContoCorrente) throws ErrContoInesistente{
		ContoCorrente c1 = getContoCorrente(codiceContoCorrente);// Controllo inserito per ErrContoInesistente (controllo gia' eseguito nel metodo getContoCorrente)
		List<Transazione> ttemp = new LinkedList<Transazione>(mappaT.values());
		List<Transazione> fttemp = new LinkedList<Transazione>();
		for(Transazione t: ttemp)
			if(t.getOrigine().getCodiceConto() == codiceContoCorrente)
				fttemp.add(t);
		Collections.sort(fttemp, new ComparatoreTransazioniPerTipoeImporto());
		return fttemp;
	}
	
	public int caricaDati(String nomeFile) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(nomeFile));
		String line; 
		int cont = 0;
		
		while ((line = br.readLine()) != null){
			String [] array = line.split(";");
			if (array.length == 5)
			{
				if (array[0].compareTo("b") == 0 || array[0].toUpperCase().compareTo("B") == 0) {
					try {
						effettuaBonifico(Integer.parseInt(array[1].trim()), Integer.parseInt(array[2].trim()), Double.parseDouble(array[3].trim()), array[4].trim());
						cont++;
					} catch (NumberFormatException | ErrContoScoperto | ErrContoInesistente e) {
						e.printStackTrace();
					}
				
				}
				if (array[0].compareTo("r") == 0 || array[0].toUpperCase().compareTo("R") == 0) {
					try {
						effettuaRicaricaCellulare(Integer.parseInt(array[1].trim()), array[2].trim(), Double.parseDouble(array[3].trim()), array[4].trim());
						cont++;
					} catch (NumberFormatException | ErrContoScoperto | ErrContoInesistente e) {
						e.printStackTrace();
					}
				
				}
			}
		}
		return cont;
	}
}
