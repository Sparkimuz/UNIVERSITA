package dist.pers;

import static dist.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static dist.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dist.sim.Ambiente;
import dist.sim.Coordinate;
import dist.sim.GeneratoreCasuale;

public class Persona {

	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);
	
	static private int progId;
	private final int id;
	private Ambiente ambiente;
	private Coordinate posizione;    // posizione corrente

	public Persona(Ambiente ambiente) {		
		this.ambiente = ambiente;
		this.posizione = GeneratoreCasuale.posizioneCasuale();
		this.id = progId++;
	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	}

	public int getId() {
		return this.id;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
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
