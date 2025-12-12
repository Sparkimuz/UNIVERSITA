package codice;


public abstract class EssereVivente{
    Coordinate Posizione = new Coordinate(0, 0);

    public EssereVivente(Coordinate posizione){
        this.Posizione = posizione;
    }
    public Coordinate getPosizione(){
        return Posizione;
    }
    public abstract void muovi(Direzione dir);
}

