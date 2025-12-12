package dist.stats;

import java.util.ArrayList;
import java.util.Collections;
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
		
		Map<Persona, List<Contatto>> risultato = new TreeMap<>();
		
		Comparator<Contatto> cmp = new Comparator<Contatto>() {

			@Override
			public int compare(Contatto o1, Contatto o2) {
				int coin = o1.numeroCoinvolti()-o2.numeroCoinvolti();
				if(coin==0)
					return o1.getPassoSimulazione()-o2.getPassoSimulazione();
				return coin;
			}
		};
		
		List<Contatto> lista;

		for(Contatto c : contatti) {
			for(Persona p : c.getCoinvolti()) {
				if(risultato.containsKey(p))
					risultato.get(p).add(c);
				else {
					lista = new ArrayList<Contatto>();
					lista.add(c);
					risultato.put(p, lista);
				}
				Collections.sort(risultato.get(p),cmp);
			}
		}
		return risultato;
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
