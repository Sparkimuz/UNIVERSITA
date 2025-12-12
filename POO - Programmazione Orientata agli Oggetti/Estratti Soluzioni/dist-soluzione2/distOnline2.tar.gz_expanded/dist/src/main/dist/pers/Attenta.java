package dist.pers;

import static dist.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static dist.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dist.sim.Ambiente;
import dist.sim.Coordinate;



public class Attenta extends Persona {
	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);

	static private int progId;

	public Attenta(Ambiente ambiente) {
		super(ambiente, progId++);
	}

	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	}

//	public void mossa() {
//		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
//		Set<Coordinate> possibili = new HashSet<>();
//		List<Coordinate> possibiliL = new ArrayList<>();
//
//		for(Coordinate c : adiacenti ) {
//			if(this.getAmbiente().getPersona(c)==null)
//				possibili.add(c);
//		}
//		
//		possibiliL.addAll(adiacenti);
//		
//		Collections.shuffle(possibiliL);
//		this.setPosizione(possibiliL.get(0));
//	}
	
	public void mossa() {
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		List<Coordinate> possibili = new LinkedList<>();

		for(Coordinate c : adiacenti ) {
			if(this.getAmbiente().getPersona(c).isEmpty())
				possibili.add(c);
		}
				
		Collections.shuffle(possibili);
		this.setPosizione(possibili.get(0));
	}

	
}
