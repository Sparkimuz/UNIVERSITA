package codice;

public class Persona extends EssereVivente{
    public Persona(Coordinate posizione){
        super(posizione);
    }

    @Override
    public void muovi(Direzione dir){
        dir.sposta(this.Posizione);
    }
}
