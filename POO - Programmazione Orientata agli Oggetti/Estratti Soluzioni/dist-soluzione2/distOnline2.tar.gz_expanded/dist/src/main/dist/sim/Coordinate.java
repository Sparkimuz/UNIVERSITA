package dist.sim;

import java.util.Objects;

/**
 * Rappresenta le coordinate di  una posizione modellata come coppia di interi 
 * ascissa (x) ed ordinata (y), all'interno di un piano cartesiano.
 * <B>(DA COMPLETARE VEDI DOMANDA 1)</B>
 */
public class Coordinate {

	@Override
	public int hashCode() {
		return this.getX()+this.getY()*31;
	}

	@Override
	public boolean equals(Object obj) {
		Coordinate that = (Coordinate) obj;
		return this.getX()==that.getX() && this.getY()==that.getY();
	}

	static public double distanza(Coordinate c0, Coordinate c1) {
		final int dx = c1.getX()-c0.getX();
		final int dy = c1.getY()-c0.getY();
		return Math.sqrt(dx*dx+dy*dy); // il teorema di Pitagora serve
	}
	
	private int x;

	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "("+getX()+","+getY()+")";
	}

}
