package prop.stats;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import prop.sim.Contatto;
import prop.sim.Simulatore;

/**
 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
 */
public class Statistiche {

	synchronized public void stampaFinale(Simulatore simulatore) {
		final List<Contatto> contatti = simulatore.getContatti();

		System.out.println(contatti.size() + " contatti rilevati." );
		System.out.println(simulatore.getContatti());
		System.out.println();

		final Map<Integer,Set<Contatto>> mappa = produciStatistiche(simulatore.getContatti());
		System.out.println("Contatti per persona:");
		stampaStatistiche(mappa);
		System.out.println();
	}

	public Map<Integer, Set<Contatto>> produciStatistiche(List<Contatto> contatti) {
		Map<Integer, Set<Contatto>> p2c = new HashMap<Integer, Set<Contatto>>();
		Integer passo;
		Set<Contatto> insiemeContatti = new HashSet<Contatto>();
		Collections.sort(contatti, new ComparatoreContatti());
		
		for(Contatto c : contatti) {
			insiemeContatti.add(c);			
		}
		
		for(Contatto k : insiemeContatti) {
			passo = k.getPassoSimulazione();
			p2c.put(passo, insiemeContatti);
		}
		return p2c;
	}
	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 */
	private void stampaStatistiche(final Map<Integer, Set<Contatto>> mappa) {
		for(Object key : mappa.keySet()) {
			final Set<Contatto> l = mappa.get(key);
			System.out.print(key + " è stato coinvolto in :");
			for(Object c : l) 
				System.out.print(c.toString() + " ");
			System.out.println();
		}
	}
}
