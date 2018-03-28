package esercito;

public interface Militare extends Comparable<Militare>{
  public String getNome();
  public String getCognome();
  public String getDataNascita();
  public int getMatricola();
  public String getNomeSquadra();
  public Comandante getComandante();
}