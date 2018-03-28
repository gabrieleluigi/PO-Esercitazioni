package azienda;

import java.util.Collection;

public interface Responsabile extends Lavoratore {
  public String getQualifica();
  public Collection<Lavoratore> getSottopostiInOrdineDiEtaDecrescente();
  public Collection<Lavoratore> getSottopostiOrdinatiPerMatricolaCrescente();
}