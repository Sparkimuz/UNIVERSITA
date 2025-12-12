package car.auto;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static car.gui.LettoreImmagini.leggiImmagineVettura;
import static car.sim.GeneratoreCasuale.generaNposizioniCasuali;
import static car.sim.CostantiSimulazione.N_DESTINAZIONI_GIALLE;

import car.sim.Coordinate;
import car.sim.Zona;

public class Gialla extends Auto {

	static private int progId = 0;
	static final private Image IMMAGINE_VETTURA_GIALLA = leggiImmagineVettura(java.awt.Color.YELLOW);

	public Gialla(Zona zona) {
		super(zona, progId++);
	}

	@Override
	public Coordinate decidiProssimaDestinazione() {
		List<Coordinate> possibili = new ArrayList<>(generaNposizioniCasuali(N_DESTINAZIONI_GIALLE));
		Collections.shuffle(possibili);
		return possibili.get(0);
	}


	public Image getImmagine() {
		return IMMAGINE_VETTURA_GIALLA;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
}
