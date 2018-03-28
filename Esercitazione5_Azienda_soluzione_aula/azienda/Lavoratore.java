package azienda;

public interface Lavoratore extends Comparable<Lavoratore>{
  public abstract String getNome();
  public abstract String getCognome();
  public abstract String getDataNascita();
  public abstract int getMatricola();
  public abstract String getNomeTeam();
  public abstract Responsabile getResponsabile();
}