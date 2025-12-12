package prop.sim;

import java.util.Set;

import prop.pers.Persona;

public class Contatto implements Comparable<Contatto>{

	private int passoSimulazione; //il passo della simulazione in cui è avvenuto il contatto
	private Set<Persona> coinvolti;
	private Coordinate luogo;

	public Contatto(int passoSimulazione, Set<Persona> stessaPosizione, Coordinate luogo) {
		if (stessaPosizione.isEmpty()) throw new IllegalArgumentException();
		this.passoSimulazione = passoSimulazione;
		this.coinvolti = stessaPosizione;
		this.luogo = luogo;
	}

	public Set<Persona> getCoinvolti() {
		return this.coinvolti;
	}

	public int getPassoSimulazione() {
		return this.passoSimulazione;
	}
	
	public void setPassoSimulazione(int passo) {
		this.passoSimulazione = passo;
	}
	
	public int numeroCoinvolti() {
		return this.coinvolti.size();
	}
	
	public Coordinate getLuogo() {
		return this.luogo;
	}

	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + 
				": era " + this.passoSimulazione + 
				", #coinvolti " + this.coinvolti.size() + "]";
	}

	@Override
	public int compareTo(Contatto that) {
		return this.getCoinvolti().size()-that.getCoinvolti().size();
	}
	
	

}
