package dist.stats;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dist.pers.Persona;
import dist.sim.Contatto;
import dist.sim.Simulatore;
import java.util.Comparator;

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

	//comparatore esterno -> vedi la classe ComparatoreContatti
//	public Map<Persona, List<Contatto>> produciStatistiche(Set<Contatto> contatti) {
//		// DA COMPLETARE (VEDI DOMANDA 3)
//		Map<Persona, List<Contatto>> risultato = new HashMap<>();
//		for(Contatto c : contatti) {
//			for(Persona p : c.getCoinvolti()) {
//				if(risultato.containsKey(p))
//					risultato.get(p).add(c);
//				else {
//					List<Contatto> l = new ArrayList<>();
//					l.add(c);
//					risultato.put(p, l);
//				}
//				Collections.sort(risultato.get(p), new CompartoreContatti());
//			}
//		}
//		return risultato;
//	}

	
	
	//comparatore con classe anonima
	public Map<Persona, List<Contatto>> produciStatistiche(Set<Contatto> contatti) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		Map<Persona, List<Contatto>> risultato = new HashMap<>();
		for(Contatto c : contatti) {
			for(Persona p : c.getCoinvolti()) {
				if(risultato.containsKey(p))
					risultato.get(p).add(c);
				else {
					List<Contatto> l = new ArrayList<>();
					l.add(c);
					risultato.put(p, l);
				}
				Collections.sort(risultato.get(p), new Comparator<Contatto>() {
					@Override
					public int compare(Contatto o1, Contatto o2) {
						if(o1.numeroCoinvolti()-o2.numeroCoinvolti() == 0)
							return o1.getPassoSimulazione()-o2.getPassoSimulazione();
						return o1.numeroCoinvolti()-o2.numeroCoinvolti();
					}
				});
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
