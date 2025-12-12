package gen.sim;


import static gen.sim.CostantiSimulazione.MAX_ETA_RIPRODUZIONE;
import static gen.sim.CostantiSimulazione.MIN_ETA_RIPRODUZIONE;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import gen.tipo.Bianco;

public class Scontro {

	private Set<Bianco> animali;
	
	private Bianco vincente;

	final static int ETA_OTTIMALE_PER_GLI_SCONTRI = ( MAX_ETA_RIPRODUZIONE - MIN_ETA_RIPRODUZIONE ) / 2;
	
	public Scontro(Set<Bianco> animali) {
		if (animali.isEmpty()) throw new IllegalArgumentException();
		this.animali = animali;
		this.vincente = selezionaVincente(animali);
	}

	public Bianco getVincente() {
		return this.vincente;
	}
	
	public Set<Bianco> getAnimali() {
		return this.animali;
	}
	
	private Bianco selezionaVincente(Collection<Bianco> animali) {
				
		return Collections.min(animali, new Comparator<Bianco>() {

			@Override
			public int compare(Bianco a1, Bianco a2) {
				int diff1 = getForza(a1);
				int diff2 = getForza(a1); 
				int cmp = diff2-diff1;
				if (cmp==0) // forza un ordinamento totale in caso di parita', usando l'id 
					cmp = a1.getId()-a2.getId();
				if (cmp==0) // forza un ordinamento totale in caso di parita', usando il nome della classe
					cmp = a1.getClass().toString().compareTo(a2.getClass().toString());
				return cmp;
			}

			/**
			 * @param  a1 - oggetto di cui si calcola la forza
			 * @return La forza e' un intero non negativo legata all'eta', 0 e' la forza massima
			 */
			private int getForza(Bianco a1) {
				return Math.abs(a1.getEta() - ETA_OTTIMALE_PER_GLI_SCONTRI);
			}
		});
	}

}
