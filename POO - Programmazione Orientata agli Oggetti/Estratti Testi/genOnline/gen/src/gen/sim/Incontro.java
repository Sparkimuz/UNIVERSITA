package gen.sim;

import java.util.Set;

import gen.tipo.Bianco;

public class Incontro {

	private Set<Bianco> animali;

	public Incontro(Set<Bianco> animali) {
		if (animali.size()!=2) throw new IllegalArgumentException();
		this.animali = animali;
	}
	
	public Set<Bianco> getAnimali() {
		return this.animali;
	}
	
	public Bianco figlio() {
		final Bianco genitore = this.animali.iterator().next();
		final Bianco clone = genitore.creaClone();
		clone.setPosizione(genitore.getPosizione());
		clone.setDirezione(Direzione.casuale());
		return clone;
    }
	
}
