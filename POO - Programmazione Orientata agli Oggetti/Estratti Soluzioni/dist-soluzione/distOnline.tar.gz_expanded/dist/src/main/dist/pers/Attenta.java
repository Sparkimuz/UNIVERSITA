package dist.pers;

import static dist.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static dist.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dist.sim.Ambiente;
import dist.sim.Coordinate;

public class Attenta extends Persona {
	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);
	static private int progId;
	private final int id;
	
	public Attenta(Ambiente ambiente) {
		super(ambiente);
		this.id = progId++;
	}
	
	@Override
	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void mossa() {
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		List<Coordinate> adiacenti2 = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		//List<Persona> persone = this.getAmbiente().getAllPersone();
		for(Coordinate c : adiacenti) {
			if(!(getAmbiente().getPersona(c).isEmpty()))
				adiacenti2.remove(c);
		}
		Collections.shuffle(adiacenti2);
		this.setPosizione(adiacenti2.get(0));
	}


}
