package banca;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class FsGui extends JFrame{

  public static void main(String[] args){
	  
	 FsGui f = new FsGui();
  }

  public ContoCorrente conto;
  public Banca banca = new Banca(); // definisco il model
  
  public JComboBox codiciContiCorrentiList;
  public JButton visualizzaDatiConto;
  public JLabel saldo;
  
  public FsGui(){
	  
  	super("Banca");
	  
	try {
		ContoCorrente c1 = banca.getContoCorrente(banca.aggiungiContoCorrente("Franco", "Rossi", 100.0));
		ContoCorrente c2 = banca.getContoCorrente(banca.aggiungiContoCorrente("Marco", "Bianchi", 20.0));
		ContoCorrente c3 = banca.getContoCorrente(banca.aggiungiContoCorrente("Giovanni", "Blu", 10.0));
		ContoCorrente c4 = banca.getContoCorrente(banca.aggiungiContoCorrente("Maria", "Viola", 30.0));
		//ContoCorrente c5 = banca.getContoCorrente(banca.aggiungiContoCorrente("Gianni", "Bianchi", 200.0));
		//ContoCorrente c6 = banca.getContoCorrente(banca.aggiungiContoCorrente("Marco", "Rossi", 100.0));
		
		  
		banca.effettuaBonifico(1, 2, 20.0, "20180106");
		banca.effettuaRicaricaCellulare(1, "333999888777", 10.0,  "20180110");
		banca.effettuaRicaricaCellulare(1, "333999888777", 5.0,  "20171225");
		
		/*banca.effettuaBonifico(c5.getCodiceConto(), c6.getCodiceConto(), 50.0, "20141231");
		if (c5.getSaldo() == 150.0 && c6.getSaldo() == 150.0)
			  System.out.println("Metodo effettuaBonifico() corretto");*/
	
		//banca.effettuaRicaricaCellulare(2, "333999888777", 5.0,  "20171225");
		
	} 
	catch (ErrContoInesistente e) {
		e.printStackTrace();
	}
	catch (ErrContoScoperto e) {
		e.printStackTrace();
	}
	
	try {
		banca.caricaDati("elenco.txt");
	} catch (IOException e) {
		e.printStackTrace();
	}
	
  	// TODO: continuare.... 
  	// suggerimento: usare un GridLayout(1,2)
	// la dimensione della view consigliata è 500x100
	try {
		for(Transazione x: banca.elencoTransazioniPerData(1)){
			System.out.println(x.getOrigine().getCodiceConto()+" "+x.getCodiceTransazione()+" "+x.getData());
		}
	} catch (ErrContoInesistente e1) {
		e1.printStackTrace();
	}
	//STAMPO LISTE PER VEDERE SE FUNZIONANO GLI ORDINAMENTI
	//---------------------
	/*for(ContoCorrente x: banca.elencoContiCorrentiPerSaldoDecrescente()){
		System.out.println(x.getCodiceConto()+" "+x.getNomeIntestatario()+" "+x.getCognomeIntestatario()+" "+x.getSaldo());
		}
	try {
		for(Transazione x: banca.elencoTransazioniPerData(1)){
			System.out.println(x.getOrigine().getCodiceConto()+" "+x.getCodiceTransazione()+" "+x.getData());
		}
	} catch (ErrContoInesistente e1) {
		e1.printStackTrace();
	}
	try {
		for(Transazione x: banca.elencoTransazioniPerTipoeImporto(1)){
			System.out.println(x.getOrigine().getCodiceConto()+" "+x.getClass().getSimpleName()+" "+x.getImporto());
		}
	} catch (ErrContoInesistente e2) {
		e2.printStackTrace();
	}*/
	//---------------------
	
	this.setSize(500,100);
	
	this.setLayout(new GridLayout(1,2));
	
	AscoltatoreDiEventiClick l = new AscoltatoreDiEventiClick(this, banca);

	JPanel p1 = new JPanel(); // creo tanti JPanel (che all'interno possono ospitare altri elementi) quanti ne necessito
	this.add(p1);
	p1.add(new JLabel("Seleziona conto"));
	p1.add(codiciContiCorrentiList = new JComboBox()); // JComboBox da implementare con i codici in ordine decrescente
	p1.add(visualizzaDatiConto = new JButton("Visualizza dati conto"));
	visualizzaDatiConto.addActionListener(l); // aggiungo l'ascoltatore
	
	JPanel p2 = new JPanel();
	this.add(p2);
	p2.add(new JLabel("Saldo: "));
	p2.add(saldo = new JLabel(""));
		
	aggiornaCombo();
	
	//Operazioni da eseguire alla fine
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
  }
  
  private void aggiornaCombo(){
	  List<ContoCorrente> l = new LinkedList<ContoCorrente>(banca.elencoContiCorrentiPerSaldoDecrescente());
	  for (int i = 0; i < l.size(); i++)
		  codiciContiCorrentiList.addItem(l.get(i).getCodiceConto());
  }
  
}
