package war.simulatore;

//import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import war.Proiettile;
//import war.tank.Factory;
import war.tank.Factory.Fazione;
import java.util.Comparator;

public class ComparatoreFazioni implements Comparator<Fazione> {

	final private Map<Fazione, Set<Proiettile>> f2p;
	
	
	
	public ComparatoreFazioni(Map<Fazione, Set<Proiettile>> f2p) {
		this.f2p = f2p;
	}

	@Override
	public int compare(Fazione f1, Fazione f2) {
		return f2p.get(f2).size() - f2p.get(f1).size();
	}

}