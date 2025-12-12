package prop.pers;

import java.awt.Image;

import prop.sim.Ambiente;
import prop.sim.Contatto;
import prop.sim.Coordinate;
import prop.sim.GeneratoreCasuale;

public abstract class Persona {
	
	static private int progId;
	private final int id;
	private Ambiente ambiente;
	private Coordinate posizione;    // posizione corrente
	
	public Persona(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.posizione = GeneratoreCasuale.posizioneCasuale();
		this.id = progId++;
	}
	
	public abstract int getId();
	
	public abstract Image getImmagine();

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}
	
	public Ambiente getAmbiente() {
		return this.ambiente;
	}
	
	
	public abstract void mossa();
	
	public abstract void avvenuto(Contatto contatto);
}
