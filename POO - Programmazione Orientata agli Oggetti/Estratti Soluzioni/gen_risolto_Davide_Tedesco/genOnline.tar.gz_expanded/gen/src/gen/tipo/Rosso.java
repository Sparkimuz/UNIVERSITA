package gen.tipo;

import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_ROSSO;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import gen.sim.Ambiente;
import gen.sim.Coordinate;

public class Rosso extends Animale {

	private static int progId;
	static final private Image IMMAGINE_ROSSA= leggiImmagineOggetto(RISORSA_IMMAGINE_ROSSO);
	public Rosso(Ambiente ambiente) {
		super(ambiente, progId++);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Animale creaClone() {
		return new Rosso(this.getAmbiente());

	}

	@Override
	Animale decidiProssimoObiettivo() {
		final List<Animale> all = this.getAmbiente().getAllAnimali();
		List<Animale> possibili = new LinkedList<Animale>();
		//mi salvo le possibili direzioni in una lista
		for(Animale a : all) {
			if(a.getClass()!=this.getClass())
				possibili.add(a);
		}
		
		//cerco l'animale con distanza mimina
		double min = 0;
		double temp;
		Animale minDist = possibili.get(0);
		for(int i=0; i<possibili.size()-1;i++) {
			if(possibili!=null) {
				temp = Coordinate.distanza(this.getPosizione(), possibili.get(i).getPosizione());
				if(min > temp) {
					min = temp;
					minDist = possibili.get(i);
				}
			}

		}
		//ritorno l'animale con distanza minima
		return minDist;
	}



	@Override
	public Image getImmagine() {
		return IMMAGINE_ROSSA;

	}

	@Override
	public String toString() {
		return Rosso.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
	}
}
