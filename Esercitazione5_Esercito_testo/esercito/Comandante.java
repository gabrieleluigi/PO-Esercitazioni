package esercito;

import java.util.Collection;

public interface Comandante extends Militare {
  public String getGrado();
  public Collection<Militare> getSoldati() throws ErrSoldatiInesistenti;
  public Collection<Militare> getSoldatiOrdinatiPerMatricolaDecrescente() throws ErrSoldatiInesistenti;
}