package codice;

public class Animale extends EssereVivente{
    public Animale(Coordinate posizione){
        super(posizione);
    }

    @Override
    public void muovi(Direzione dir){
    	dir.sposta(this.Posizione);
        dir.sposta(this.Posizione);
    }
}