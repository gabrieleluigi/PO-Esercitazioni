package banca;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class FsGui extends JFrame implements ActionListener{

  public static void main(String[] args){
	  
	 FsGui f = new FsGui();
  }

  public ContoCorrente conto;
  public Banca banca = new Banca(); // e' il model
  
  public JComboBox codiciContiCorrentiList;
  public JButton visualizzaDatiConto;
  public JButton perData;
  public JButton perImporto;
  public JTextField importo;
  public JTextField data;
  public JTextField numeroContoOCellulare;
  public JLabel saldo;
  public JList listaTransazioni;
  public JButton bonifico;
  public JButton ricarica;

  
  public FsGui(){
	  
  	super("Banca");
	  
	try {
		ContoCorrente c1 = banca.getContoCorrente(banca.aggiungiContoCorrente("Franco", "Rossi", 100.0));
		ContoCorrente c2 = banca.getContoCorrente(banca.aggiungiContoCorrente("Marco", "Bianchi", 30.0));
		ContoCorrente c3 = banca.getContoCorrente(banca.aggiungiContoCorrente("Giovanni", "Blu", 30.0));
		ContoCorrente c4 = banca.getContoCorrente(banca.aggiungiContoCorrente("Maria", "Viola", 30.0));
		  
		banca.effettuaBonifico(1, 2, 20.0, "20170106");
		banca.effettuaRicaricaCellulare(1, "333999888777", 10.0,  "20170110");
		banca.effettuaRicaricaCellulare(1, "333999888777", 5.0,  "20161225");
		  
	} 
	catch (ErrContoInesistente e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (ErrContoScoperto e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	
  	// TODO: continuare.... 
  	// suggerimento: usare un GridLayout(2,3)
	// la dimensione della view consigliata è 900x500
	
	// creo la view
	this.setSize(900,500);

	this.setLayout(new GridLayout(2, 3));
	
	/* la disposizione non funziona bene
	this.add(new JLabel("prova"));
	this.add(new JLabel("prova2"));
	this.add(new JLabel("prova3"));
	*/ 
	
	JPanel p1 = new JPanel(); // creo tanti JPanel (che all'interno possono ospitare altri elementi) quanti ne necessito
	this.add(p1);
	p1.add(new JLabel("Seleziona conto"));
	p1.add(codiciContiCorrentiList = new JComboBox()); // la dovro' riempire
	p1.add(visualizzaDatiConto = new JButton("Visualizza dati conto"));
	visualizzaDatiConto.addActionListener(this); // devo aggiungere l'ascoltatore!!!
	
	JPanel p2 = new JPanel();
	this.add(p2);
	p2.add(perData = new JButton("Per data"));
	p2.add(perImporto = new JButton("Per importo"));
	perData.addActionListener(this);
	perImporto.addActionListener(this);
	
	JPanel p3 = new JPanel();
	this.add(p3);
	p3.add(new JLabel("Importo"));
	p3.add(importo = new JTextField(23)); 
	p3.add(new JLabel("Data"));
	p3.add(data = new JTextField(23)); 
	p3.add(new JLabel("Numero conto destinazione/cellulare"));
	p3.add(numeroContoOCellulare = new JTextField(23)); 
	
	JPanel p4 = new JPanel();
	this.add(p4);
	p4.add(new JLabel("Saldo: "));
	p4.add(saldo = new JLabel(""));
	
	JPanel p5 = new JPanel();
	this.add(p5);
	p5.add(new JScrollPane(listaTransazioni = new JList()));
	
	JPanel p6 = new JPanel();
	this.add(p6);
	p6.add(bonifico = new JButton("Bonifico"));
	p6.add(ricarica = new JButton("Ricarica"));
	bonifico.addActionListener(this);
	ricarica.addActionListener(this);
	importo.addActionListener(this);
	data.addActionListener(this);
	numeroContoOCellulare.addActionListener(this);
	
	aggiornaCombo(); // per aggiornare la lista conticorrenti quando avvio la finestra
	
	// lo faccio alla fine
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);

  }
  
  private void aggiornaCombo(){
	  List<ContoCorrente> l = new LinkedList<ContoCorrente>(banca.elencoContiCorrentiPerCodiceCrescente());
	  
	  for (int i = 0; i < l.size(); i++)
		  codiciContiCorrentiList.addItem(l.get(i).getCodiceConto());
  }

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == this.visualizzaDatiConto){ // if (evento.getActionCommand().equals("Visualizza dati conto"))
			String stringa = codiciContiCorrentiList.getSelectedItem().toString();
			
			// aggiornare il riferimento al conto che sto considerando
			try {
				conto = banca.getContoCorrente(Integer.parseInt(stringa));
			} catch (NumberFormatException | ErrContoInesistente e) {
				e.printStackTrace();
			}
			
			// visualizzare il saldo
			saldo.setText(String.valueOf(conto.getSaldo()));
			listaTransazioni.setListData(conto.stampaTransazioniPerData().toArray());
		}
		
		if (evento.getSource() == this.perData)
			listaTransazioni.setListData(conto.stampaTransazioniPerData().toArray());

		if (evento.getSource() == this.perImporto)
			listaTransazioni.setListData(conto.stampaTransazioniPerTipoeImporto().toArray());
		
		if (evento.getSource() == this.bonifico){
			try {
				banca.effettuaBonifico(conto.getCodiceConto(), Integer.parseInt(numeroContoOCellulare.getText()), 
						Double.parseDouble(importo.getText()), data.getText());
			} catch (NumberFormatException | ErrContoScoperto
					| ErrContoInesistente e) {
				e.printStackTrace();
			}
			
			listaTransazioni.setListData(conto.stampaTransazioniPerData().toArray());
			saldo.setText(String.valueOf(conto.getSaldo()));
		}
		
		if (evento.getSource() == this.ricarica){
			try {
				banca.effettuaRicaricaCellulare(conto.getCodiceConto(), numeroContoOCellulare.getText(), 
						Double.parseDouble(importo.getText()), data.getText());
			} catch (NumberFormatException | ErrContoScoperto
					| ErrContoInesistente e) {
				e.printStackTrace();
			}
			
			listaTransazioni.setListData(conto.stampaTransazioniPerData().toArray());
			saldo.setText(String.valueOf(conto.getSaldo()));
		}
	}
}
