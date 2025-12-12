package car.stats;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import car.auto.Auto;
import car.sim.Coordinate;
import car.sim.Tragitto;
import car.sim.Zona;

public class Statistiche {

	synchronized public void stampaFinale(Zona zona) {
		final List<Tragitto> tragitti = zona.getTragitti();

		System.out.println(tragitti.size() + " tragitti collezionati." );
		System.out.println(zona.getTragitti());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Percorsi di ciascuna vettura:");
		final Map<Auto,Set<Tragitto>> auto2tragitti = tragittoPerAuto(tragitti);
		stampaTragittiPerAuto(auto2tragitti);
		System.out.println();

		// (VEDI DOMANDA 4)
		System.out.println("Classifica finale delle posizioni piu' battute:");
		final SortedMap<Coordinate,Integer> pos2utilizzi = utilizzi(tragitti);
		stampaUtilizzi(pos2utilizzi);
		System.out.println();
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param tragitti - lista dei tragitti collezionati durante la simulazione
	 * @return una mappa che riporti per ogni auto (di qls tipo)
	 *         l'insieme dei tragitti che ha percorso
	 */
	public Map<Auto, Set<Tragitto>> tragittoPerAuto(List<Tragitto> tragitti) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		Map<Auto, Set<Tragitto>> mappa = new HashMap<>();
		for(Tragitto t  : tragitti) {
			if(mappa.containsKey(t.getAuto()))
				mappa.get(t.getAuto()).add(t);
			else {
				Set<Tragitto> s = new HashSet<>();
				s.add(t);
				mappa.put(t.getAuto(), s);
			}
		}
		return mappa;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param auto2tragitti
	 */
	private void stampaTragittiPerAuto(final Map<Auto, Set<Tragitto>> auto2tragitti) {
		for(Auto auto : auto2tragitti.keySet()) {
			Set<Tragitto> tragitti = auto2tragitti.get(auto);
			System.out.println("L'auto "+auto+" ha fatto "+( tragitti!=null ? tragitti.size() : 0 ) +" corse");
		}
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 4)</B>
	 * 	@param tragitti - lista dei tragitti collezionati durante la simulazione
	 * @return una mappa ordinata decrescente in cui figurano come chiavi 
	 *         le posizioni piu'battute come origine o destinazione di un 
	 *         tragitto, come valori il numero di tali tragitti
	 */
	public SortedMap<Coordinate,Integer> utilizzi(List<Tragitto> tragitti) {
		// DA COMPLETARE (VEDI DOMANDA 4)
		final Map<Coordinate,Integer> mappaAppoggio = new HashMap<Coordinate, Integer>();

		for(Tragitto t : tragitti) {
			if(mappaAppoggio.containsKey(t.getDestinazione())) {
				Integer intero = mappaAppoggio.get(t.getDestinazione())+1;
				mappaAppoggio.put(t.getDestinazione(), intero);
			}
			else {
				mappaAppoggio.put(t.getDestinazione(), 1);
			}
			
			if(mappaAppoggio.containsKey(t.getOrigine())) {
				Integer intero = mappaAppoggio.get(t.getOrigine())+1;
				mappaAppoggio.put(t.getOrigine(), intero);
			}
			else {
				mappaAppoggio.put(t.getOrigine(), 1);
			}


		}

		SortedMap<Coordinate, Integer> mappa = new TreeMap<Coordinate, Integer>(new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				if(mappaAppoggio.get(o2)-mappaAppoggio.get(o1)==0) {
					return o2.compareTo(o1);
				}
				return mappaAppoggio.get(o2)-mappaAppoggio.get(o1);
			}
		});

		mappa.putAll(mappaAppoggio);
		return mappa;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 4</EM>
	 * @param classifica delle posizioni piu' usate
	 */
	private void stampaUtilizzi(SortedMap<Coordinate,Integer> classifica) {
		int i = 0;
		for(Map.Entry<Coordinate, Integer> entry : classifica.entrySet()) {
			final Coordinate posizione = entry.getKey();
			final Integer numeri = entry.getValue();
			System.out.println(i+") "+posizione+" con "+numeri+" utilizzi");
			i++;
		}
	}

}
