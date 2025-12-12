package prop.pers;

import static prop.gui.CostantiGUI.*;
import static prop.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;
import prop.sim.GeneratoreCasuale;

public class NonPredicatore extends Persona{

	static private int progId=0;
	private Image immagine = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);
	
	public NonPredicatore(Ambiente ambiente) {	
		super(ambiente, progId++);
	}

	public Image getImmagine() {
		return immagine;
	}

	public void setImmagine(Image immagine) {
		this.immagine =  immagine;
	}
	public void mossa() {
		List<Persona> persone = new LinkedList<>(this.getAmbiente().getAllPersone());
		double distanza = 65536;
		Coordinate coMax = null;
		for(Persona a : persone) {
			if(!this.getClass().equals(a.getClass())) {
				if(Coordinate.distanza(this.getPosizione(),a.getPosizione())<distanza) {
					distanza = Coordinate.distanza(this.getPosizione(),a.getPosizione());
					coMax = a.getPosizione();
				}
			}
		}
		distanza = 0;
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		Coordinate prescelta = null;
		for(Coordinate c : adiacenti) {
			if(Coordinate.distanza(coMax, c)>distanza) {
				distanza = Coordinate.distanza(coMax, c);
				prescelta = c;
			}
		}
		this.setPosizione(prescelta);
	}

	@Override
	public String toString() {
		return NonPredicatore.class.getSimpleName()+getId();
	}

	public void avvenuto(Contatto contatto) {
		// ( VEDI DOMANDA 2b ) 
		// Metodo invocato ogni qual volta avviene un Contatto con questa
		float convinta = 0;
		for(Persona p : contatto.getCoinvolti()) {
			if(p.getClass()==Predicatore.class)
				if(GeneratoreCasuale.siVerificaEventoDiProbabilita(PROBABILITA_CONVERSIONE))
					this.setImmagine(leggiImmagineOggetto(RISORSA_IMMAGINE_GIALLO));
		}
	}

}
