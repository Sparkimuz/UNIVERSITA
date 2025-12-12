package dist.stats;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dist.sim.Contatto;
import dist.sim.Simulatore;

/**
 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
 */
public class Statistiche {

	synchronized public void stampaFinale(Simulatore simulatore) {
		final Set<Contatto> contatti = simulatore.getContatti();

		System.out.println(contatti.size() + " contatti rilevati." );
		System.out.println(simulatore.getContatti());
		System.out.println();

		final Map<Object,List<Object>> mappa = produciStatistiche(simulatore.getContatti());
		System.out.println("Statistica:");
		stampaStatistiche(mappa);
		System.out.println();
	}

	public Map<Object, List<Object>> produciStatistiche(Set<Contatto> contatti) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		return Collections.emptyMap();
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 */
	private void stampaStatistiche(final Map<Object, List<Object>> mappa) {
		for(Object key : mappa.keySet()) {
			final List<Object> l = mappa.get(key);
			System.out.print(key + " è stato coinvolto in :");
			for(Object c : l) 
				System.out.print(c.toString() + " ");
			System.out.println();
		}
	}
}
