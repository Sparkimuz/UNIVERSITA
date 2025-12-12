package codice;

public class Direzione {
    public static final Direzione NORD = new Direzione(0, 1);
    public static final Direzione EST = new Direzione(1, 0);
    public static final Direzione SUD = new Direzione(0, -1);
    public static final Direzione OVEST = new Direzione(-1, 0);

    private int dx;
    private int dy;

    public Direzione(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Direzione opposta(Direzione dir) {
        if (dir == NORD) return SUD;
        if (dir == EST) return OVEST;
        if (dir == SUD) return NORD;
        if (dir == OVEST) return EST;
        return null;
    }

    public void sposta(Coordinate origine) {
        origine.setX(origine.getX() + this.dx);
        origine.setY(origine.getY() + this.dy);
    }

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
    
    
}
