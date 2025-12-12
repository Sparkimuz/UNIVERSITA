package gen.tipo;

import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_VERDE;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;
import static gen.sim.GeneratoreCasuale.generaNumeroSinoA;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import gen.sim.Ambiente;

public class Verde extends Animale {

	private static int progId;
	static final private Image IMMAGINE_VERDE = leggiImmagineOggetto(RISORSA_IMMAGINE_VERDE);

	public Verde(Ambiente ambiente) {
		super(ambiente, progId++);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Animale creaClone() {
		return new Verde(this.getAmbiente());

	}

	@Override
	Animale decidiProssimoObiettivo() throws IndexOutOfBoundsException{
		if(this.getEta()>gen.sim.CostantiSimulazione.MIN_ETA_RIPRODUZIONE) {
			final List<Animale> all = this.getAmbiente().getAllAnimali();
			return all.get(generaNumeroSinoA(all.size()));
		} else {
			final List<Animale> all = this.getAmbiente().getAllAnimali();

			List<Animale> possibili = new ArrayList<Animale>();

			for(Animale a : all) {
				if(a.getClass()!=this.getClass())
					possibili.add(a);
			}

			return possibili.get(0);

		}
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_VERDE;

	}

	@Override
	public String toString() {
		return Verde.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
	}

}
