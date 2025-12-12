package dist.pers;

import static dist.gui.CostantiGUI.RISORSA_IMMAGINE_ROSSO;
import static dist.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dist.sim.Ambiente;
import dist.sim.Coordinate;

public class Distratta extends Persona {
	static final private Image IMMAGINE_ROSSA = leggiImmagineOggetto(RISORSA_IMMAGINE_ROSSO);
	private static int progId;

	public Distratta(Ambiente ambiente) {
		super(ambiente, progId++);
	}

	public Image getImmagine() {
		return IMMAGINE_ROSSA;
	}
	
	public void mossa() {
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		Collections.shuffle(adiacenti);
		this.setPosizione(adiacenti.get(0));
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+getId();
	}
}
