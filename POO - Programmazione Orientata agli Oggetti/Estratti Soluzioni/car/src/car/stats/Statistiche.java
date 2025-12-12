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
		//inizializzo la mappa di riempimento
		Map<Auto, Set<Tragitto>> mappa = new HashMap<>();
		//scandisco la lista di tragitti
		for(Tragitto t : tragitti) {
			if(mappa.containsKey(t.getAuto())) {
				//se gia ho la chiave di un auto non la aggiungo
				mappa.get(t.getAuto()).add(t);
			}
			else {
				// se non ho la chiave, la aggiungo come HashSet
				mappa.put(t.getAuto(), new HashSet<Tragitto>());
				mappa.get(t.getAuto()).add(t);
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
			System.out.println("L'auto "+auto+" ha fatto "+( tragitti!=null ? tragitti.size() : 0 ) +" tragitti");
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
		final Map<Coordinate,Integer> mappaUtilizzi = new HashMap<>();
		for(Tragitto t : tragitti) {
			//aggiungo alla mappa con un metodo apposito
			this.aggiungiAMappa(t.getOrigine(), mappaUtilizzi);
			this.aggiungiAMappa(t.getDestinazione(), mappaUtilizzi);
		}
		//ho la mappa con le coordinate raggruppate per numero di occorrenze
		
		//ordinamento esterno tramite comparatore esterno
		SortedMap<Coordinate, Integer> risultato = new TreeMap<Coordinate,Integer>(new Comparator<Coordinate>() {
			
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				int res = mappaUtilizzi.get(c2)-mappaUtilizzi.get(c1);
				if(res==0)
					return c2.compareTo(c1);
				return res;
			}
		});
		
		//inserisco la mappa ordinata nella mappa da ritornare
		risultato.putAll(mappaUtilizzi);
		return risultato;
	}
	
	//metodo che aggiunge alla mappa
	private void aggiungiAMappa(Coordinate c, Map<Coordinate, Integer> mappa) {
		if(mappa.containsKey(c)){
			mappa.put(c, mappa.get(c)+1);
		}
		else
			mappa.put(c,1);
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
