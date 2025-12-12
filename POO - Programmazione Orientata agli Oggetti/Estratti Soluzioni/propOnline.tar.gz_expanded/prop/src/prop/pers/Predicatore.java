package prop.pers;

import static prop.gui.CostantiGUI.*;
import static prop.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;
import prop.sim.GeneratoreCasuale;

public class Predicatore extends Persona{

	static final private Image IMMAGINE_ROSSA = leggiImmagineOggetto(RISORSA_IMMAGINE_ROSSO);
	static private int progId=0;

	public Predicatore(Ambiente ambiente) {		
		super(ambiente, progId++);
	}

	public Image getImmagine() {
		return IMMAGINE_ROSSA;
	}

	public void mossa() {
		List<Persona> persone = new LinkedList<>(this.getAmbiente().getAllPersone());
		double distanza = 0;
		Coordinate coMax = null;
		for(Persona a : persone) {
			if(!this.getClass().equals(a.getClass())) {
				if(Coordinate.distanza(this.getPosizione(),a.getPosizione())>distanza) {
					distanza = Coordinate.distanza(this.getPosizione(),a.getPosizione());
					coMax = a.getPosizione();
				}
			}
		}
		distanza = 65536;
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		Coordinate prescelta = null;
		for(Coordinate c : adiacenti) {
			if(Coordinate.distanza(coMax, c)<distanza) {
				distanza = Coordinate.distanza(coMax, c);
				prescelta = c;
			}
		}
		this.setPosizione(prescelta);
	}


	@Override
	public String toString() {
		return Predicatore.class.getSimpleName()+getId();
	}

	@Override
	public void avvenuto(Contatto contatto) {
		// TODO Auto-generated method stub	
	}


}
