public abstract class EssereVivente{
    Coordinate Posizione = new Coordinate(0, 0);

    public EssereVivente(Coordinate posizione){
        this.posizione = posizione;
    }
    public Coordinate getPosizione(){
        return Posizione;
    }
    public abstract void muovi(Direzione dir){
    }
}

public class Persona extends EssereVivente{
    public Persona(Coordinate posizione){
        super(posizione);
    }

    @Override
    public abstract void muovi(Direzione dir){
        this.posizione = dir.sposta(this.posizione);
    }
}

public class Animale extends EssereVivente{
    public Animale(Coordinate posizione){
        super(posizione);
    }

    @Override
    public abstract void muovi(Direzione dir){
        this.posizione = dir.sposta(dir.sposta(this.posizione));
    }
}