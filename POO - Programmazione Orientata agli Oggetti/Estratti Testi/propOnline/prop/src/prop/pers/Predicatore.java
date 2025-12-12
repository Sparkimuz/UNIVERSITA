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

	private Image IMMAGINE_Predicatore = leggiImmagineOggetto(RISORSA_IMMAGINE_ROSSO);   // posizione corrente
	static private int progId;
	private final int id;

	public Predicatore(Ambiente ambiente) {		
		super(ambiente);
		this.id = progId++;
	}
	@Override
	public int getId() {
		return this.id;
	}


	@Override
	public Image getImmagine() {
		return IMMAGINE_Predicatore;
	}
	
	public void setImmagine(Image immagine) {
		this.IMMAGINE_Predicatore = immagine;
	}

	@Override
	public void mossa() {
		double distanza = 0;
		Coordinate coMax = new Coordinate (0,0);
		for(Persona p : this.getAmbiente().getAllPersone()) {
			System.out.println("Debug: Posizione corrente = " + this.getPosizione());
			System.out.println("Debug: Posizione di p = " + p.getPosizione());
			if(p.getClass() != this.getClass()) {
				if(Coordinate.distanza(this.getPosizione(), p.getPosizione()) > distanza ) {
					distanza = Coordinate.distanza(this.getPosizione(), p.getPosizione());
					coMax = p.getPosizione();
;				}
				
				
			}
			
		}
		distanza = 0;
		Coordinate prossimoPunto = new Coordinate(0,0);
		List<Coordinate> adiacenti = new LinkedList<>(this.getAmbiente().adiacentiA(this.getPosizione()));
		Collections.shuffle(adiacenti);
		for(Coordinate c : adiacenti) {
			if(Coordinate.distanza(coMax, c)>distanza) {
				distanza = Coordinate.distanza(coMax, c);
				prossimoPunto = c;
			}
		}
		this.setPosizione(prossimoPunto);
	}
	
	@Override
	public void avvenuto(Contatto contatto) {
		// ( VEDI DOMANDA 2b ) 
		// Metodo invocato ogni qual volta avviene un Contatto con questa
		for(Persona p : contatto.getCoinvolti()) {
			if(p.getClass()==Predicatore.class)
				if(GeneratoreCasuale.siVerificaEventoDiProbabilita(PROBABILITA_CONVERSIONE))
					this.setImmagine(leggiImmagineOggetto(RISORSA_IMMAGINE_GIALLO));
		}
	}

	@Override
	public String toString() {
		return Predicatore.class.getSimpleName()+getId();
	}

}
