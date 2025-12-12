package dist.stats;

import java.util.Comparator;

import dist.sim.Contatto;

public class CompartoreContatti implements Comparator<Contatto>{

	@Override
	public int compare(Contatto o1, Contatto o2) {
		if(o1.numeroCoinvolti()-o2.numeroCoinvolti() == 0)
			return o1.getPassoSimulazione()-o2.getPassoSimulazione();
		return o1.numeroCoinvolti()-o2.numeroCoinvolti();
	}

}
