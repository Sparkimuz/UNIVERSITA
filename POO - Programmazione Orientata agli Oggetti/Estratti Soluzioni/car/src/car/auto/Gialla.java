package car.auto;

import static car.gui.LettoreImmagini.leggiImmagineVettura;
import static car.sim.GeneratoreCasuale.generaNposizioniCasuali;

import java.awt.Image;
import java.util.Collections;
import java.util.List;
import car.sim.Coordinate;
import car.sim.Zona;

/**
 * Modella le fasi del ciclo di vista di una vettura {@link Gialla}.
 * <B>(VEDI DOMANDA 2)</B>
 */
public class Gialla extends Auto{

	static final private Image IMMAGINE_VETTURA_GIALLA = leggiImmagineVettura(java.awt.Color.YELLOW);
	static private List<Coordinate> destinazioni =generaNposizioniCasuali(5);
	static private int progId = 0;

	public Gialla(Zona zona) {		
		super(zona, progId++);
	}

	@Override
	protected Coordinate decidiProssimaDestinazione() {
		Collections.shuffle(destinazioni);
		return destinazioni.get(0);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_VETTURA_GIALLA;
	}

}
