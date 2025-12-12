public static class Direzione {
    public static final Direzione NORD = new Direzione(0, 1);
    public static final Direzione EST = new Direzione(1, 0);
    public static final Direzione SUD = new Direzione(0, -1);
    public static final Direzione OVEST = new Direzione(-1, 0);

    private final int dx;
    private final int dy;

    private Direzione(int dx, int dy) {
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

    public Coordinate sposta(Coordinate origine) {
        int nuovoX = origine.getX() + this.dx;
        int nuovoY = origine.getY() + this.dy;
        return new Coordinate(nuovoX, nuovoY);
    }
}
