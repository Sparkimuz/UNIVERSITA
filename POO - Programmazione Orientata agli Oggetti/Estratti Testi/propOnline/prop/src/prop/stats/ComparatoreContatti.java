package prop.stats;

import java.util.*;

import prop.sim.Contatto;

public class ComparatoreContatti implements Comparator<Contatto> {
	
	public ComparatoreContatti() {
	}
	
	
	
	@Override
	public int compare(Contatto c1, Contatto c2) {
		return c1.getCoinvolti().size() - c2.getCoinvolti().size();
		
	}

}
