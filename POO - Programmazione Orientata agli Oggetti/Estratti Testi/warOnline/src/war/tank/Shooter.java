package war.tank;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import static war.costanti.CostantiSimulazione.PROBABILITA_CAMBIO_DIREZIONE;
import static war.costanti.CostantiSimulazione.PROBABILITA_SPARO;

//import java.util.Set;

import war.*;
import war.simulatore.GeneratoreCasuale;

public class Shooter extends Tank{
	public Shooter(Campo campo) {
		super(campo);
	}
	
	@Override
	public boolean decideDiCambiareDirezione(int passo) {
		int traccia = this.getCampo().rilevaTracciaVerso(this.getPosizione(), this.getDirezione());
		if(traccia>0)
			return false;
		else {
			return GeneratoreCasuale.siVerificaEventoDiProbabilita(PROBABILITA_CAMBIO_DIREZIONE);
		}
	}
	//rilevaTracciaVerso(Coordinate riferimento, Direzione dir);
	
	public Direzione cambioDirezione(Set<Direzione> possibili) {

		//escludo la mia stessa traccia
		possibili.remove(this.getDirezione().opposta());

		return Collections.max(possibili, new Comparator <Direzione>() {

			@Override
			public int compare(Direzione d1, Direzione d2) {
				return getCampo().rilevaTracciaVerso(getPosizione(), d1) - getCampo().rilevaTracciaVerso(getPosizione(), d2);
			}
			
		});
	}
	@Override
	public boolean decideDiSparare(int passo) {
		return GeneratoreCasuale.siVerificaEventoDiProbabilita(PROBABILITA_SPARO) ;
	}
}
