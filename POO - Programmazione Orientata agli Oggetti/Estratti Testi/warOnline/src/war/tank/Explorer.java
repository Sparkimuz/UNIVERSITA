package war.tank;

import static war.simulatore.GeneratoreCasuale.siVerificaEventoDiProbabilita;

import java.util.Set;

import static war.costanti.CostantiSimulazione.*;
import war.Campo;
//import war.Direzione;
import war.Direzione;
import war.simulatore.GeneratoreCasuale;

public class Explorer extends Tank{
	public Explorer(Campo campo) {
		super(campo);
	}
	
	@Override
	public boolean decideDiCambiareDirezione(int passo) {
		return (siVerificaEventoDiProbabilita(PROBABILITA_CAMBIO_DIREZIONE) ) ;
	}
	
	@Override
	public Direzione cambioDirezione(Set<Direzione> possibili) {
		return Direzione.scegliAcasoTra(possibili);
	}
	@Override
	public boolean decideDiSparare(int passo) {
		return GeneratoreCasuale.siVerificaEventoDiProbabilita(PROBABILITA_SPARO) ;
	}
}
