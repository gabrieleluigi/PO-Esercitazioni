package residenza;

public class Residenza {

	private String nomeR;
	private String indirizzoR;
	private Ospite[] arrayOspiti;
	private int i;
	
	public Residenza() {
	  arrayOspiti = new Ospite[100];
	  i = 0;
	}
	
	public void setNome(String nome) {
	  nomeR = nome;
	}
	public String getNome() {
	  return nomeR;
	}
	
	public void setIndirizzo(String indirizzo) {
	  indirizzoR = indirizzo;
	}
	public String getIndirizzo() {
	  return indirizzoR;
	}
	
	public void aggiungiOspite(String nome, String cognome, String dataDiNascita){
	  
	  Ospite o = new Ospite();
	  
	  o.setNomeO(nome);
	  o.setCognomeO(cognome);
	  o.setDataO(dataDiNascita);
	  
	  arrayOspiti[i] = o;
	  
	  i++;
	  
	}
	public String primo() {
	  return new String(arrayOspiti[0].getNomeO() + " " + arrayOspiti[0].getCognomeO() + " " +arrayOspiti[0].getDataO());
	}
	public String ultimo() {
	  return new String(arrayOspiti[i-1].getNomeO() + " " + arrayOspiti[i-1].getCognomeO() + " " +arrayOspiti[i-1].getDataO());
	}
	public String ospite(int i) {
	  return new String(arrayOspiti[i-1].getNomeO() + " " + arrayOspiti[i-1].getCognomeO() + " " +arrayOspiti[i-1].getDataO());
	}
	public String elenco() {
	  String a = new String();
	  for(int j=0;j< i-1 ;j++)
			a += new String(arrayOspiti[j].getNomeO() + " " + arrayOspiti[j].getCognomeO() + " " +arrayOspiti[j].getDataO() + ";\n");
	  a += new String(arrayOspiti[i-1].getNomeO() + " " + arrayOspiti[i-1].getCognomeO() + " " +arrayOspiti[i-1].getDataO() + ".");
	  return a;
	}
}
