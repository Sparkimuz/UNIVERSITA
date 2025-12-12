package war.tank;

import static war.costanti.CostantiSimulazione.PROBABILITA_CAMBIO_DIREZIONE;
import static war.simulatore.GeneratoreCasuale.siVerificaEventoDiProbabilita;

import java.util.Set;

import war.Campo;
import war.Coordinate;
import war.Direzione;

public class Gunner extends Tank{

	public Gunner(Campo campo) {
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
		Direzione dir = this.getDirezione();
		Coordinate pos1 = this.getPosizione();

		for(Tank t : this.getCampo().getTank()) {
			Coordinate pos2 = t.getPosizione();

			if(dir == new Direzione(1,1) && pos2.getX() > pos1.getX() && pos2.getY() > pos1.getY())
				return (siVerificaEventoDiProbabilita(1));
			if(dir == new Direzione(1,0) && pos2.getX() > pos1.getX())
				return (siVerificaEventoDiProbabilita(1));
			if(dir == new Direzione(0,1) && pos2.getY() > pos1.getY())
				return (siVerificaEventoDiProbabilita(1));
			if(dir == new Direzione(-1,0) && pos2.getX() < pos1.getX())
				return (siVerificaEventoDiProbabilita(1));
			if(dir == new Direzione(0,-1) && pos2.getY() < pos1.getY())
				return (siVerificaEventoDiProbabilita(1));
			if(dir == new Direzione(-1,-1) && pos2.getX() < pos1.getX() && pos2.getY() < pos1.getY())
				return (siVerificaEventoDiProbabilita(1));
			if(dir == new Direzione(1,-1) && pos2.getX() > pos1.getX() && pos2.getY() < pos1.getY())
				return (siVerificaEventoDiProbabilita(1));
			if(dir == new Direzione(-1,1) && pos2.getX() < pos1.getX() && pos2.getY() > pos1.getY())
				return (siVerificaEventoDiProbabilita(1));
		}
		return false;
	}

}
