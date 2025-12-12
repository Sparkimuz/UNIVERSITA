package dist.stats;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import dist.pers.Persona;
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

		final Map<Persona,List<Contatto>> mappa = produciStatistiche(simulatore.getContatti());
		System.out.println("Statistica:");
		stampaStatistiche(mappa);
		System.out.println();
	}

	public Map<Persona, List<Contatto>> produciStatistiche(Set<Contatto> contatti) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		final Map<Persona, List<Contatto>> p2c = new HashMap<>();
		
		for(Contatto c : contatti) {
			for(Persona p : c.getCoinvolti()) {
				if(p2c.containsKey(p)) {
					p2c.get(p).add(c);
				} else {
					p2c.put(p, new ArrayList<>());
					p2c.get(p).add(c);
				}
			}
		}
		//dopo aver realizzato la mappa che lega ogni persona ad una lista di contatti, la posso ordinare con un comparatore
		Map<Persona, List<Contatto>> tree = new TreeMap<>(new Comparator<Persona>() {

			@Override
			public int compare(Persona o1, Persona o2) {
				return p2c.get(o1).size()-p2c.get(o2).size();
			}
		});
		
		//inserendo gli elementi nella TreeMap essi si ordineranno automaticamente
		tree.putAll(p2c);
		
		return p2c;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 */
	private void stampaStatistiche(final Map<Persona, List<Contatto>> mappa) {
		for(Object key : mappa.keySet()) {
			final List<Contatto> l = mappa.get(key);
			System.out.print(key + " è stato coinvolto in :");
			for(Object c : l) 
				System.out.print(c.toString() + " ");
			System.out.println();
		}
	}
}
