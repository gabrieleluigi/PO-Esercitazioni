package banca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreDiEventiClick implements ActionListener {

	FsGui view;
	Banca model;

	public AscoltatoreDiEventiClick(FsGui view, Banca model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == view.visualizzaDatiConto){ // if (evento.getActionCommand().equals("Visualizza dati conto"))
			String stringa = view.codiciContiCorrentiList.getSelectedItem().toString();
			
			// aggiornare il riferimento al conto che sto considerando
			try {
				view.conto = model.getContoCorrente(Integer.parseInt(stringa));
			} catch (NumberFormatException | ErrContoInesistente err) {
				err.printStackTrace();
			}
			
			// visualizzare il saldo
			view.saldo.setText(String.valueOf(view.conto.getSaldo()));
		}
	}

}
