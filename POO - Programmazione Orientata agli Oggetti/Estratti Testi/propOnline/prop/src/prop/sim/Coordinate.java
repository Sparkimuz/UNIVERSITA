package prop.sim;

/**
 * Rappresenta le coordinate di  una posizione modellata come coppia di interi 
 * ascissa (x) ed ordinata (y), all'interno di un piano cartesiano.
 * <B>(DA COMPLETARE VEDI DOMANDA 1)</B>
 */
public class Coordinate {

	static public double distanza(Coordinate c0, Coordinate c1) {
		if (c0 == null || c1 == null) {
			System.out.println("Debug: c0 = " + c0 + ", c1 = " + c1);
	        throw new IllegalArgumentException("Le coordinate non possono essere null");
	    }
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
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o == null || o.getClass() != this.getClass())
			return false;
		
		Coordinate other = (Coordinate) o;
		return this.getX() == other.getX() && this.getY() == other.getY();
		
	}
	
	@Override
	public int hashCode() {
		return this.getX()+this.getY();
	}

}
