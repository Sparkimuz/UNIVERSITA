package prop.pers;

import java.awt.Image;

import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;
import prop.sim.GeneratoreCasuale;

public abstract class Persona {

	private Ambiente ambiente;
	private Coordinate posizione;    // posizione corrente
	private final int id;

	public Persona(Ambiente ambiente, int progId) {
		this.ambiente = ambiente;
		this.posizione = GeneratoreCasuale.posizioneCasuale();
		this.id = progId;

	}
	public abstract Image getImmagine();
	
	public Ambiente getAmbiente() {
		return this.ambiente;
	}


	public Coordinate getPosizione() {
		return this.posizione;
	}

	public void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}
	
	public abstract void mossa();
	
	public int getId() {
		return this.id;
	}
	public abstract void avvenuto(Contatto contatto);

//	public double calcolaDistanza(Coordinate c1, Coordinate c2) {
//		return Math.abs(Math.sqrt(((c1.getX()-c2.getX())^2+((c1.getY()-c2.getY()))^2)));
//	}

}
