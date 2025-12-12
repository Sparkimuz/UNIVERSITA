interface Animale {
    public void verso();
}

class Cane implements Animale {
    public Cane() {}
    public void verso() {}
}

class Gatto implements Animale {
       public Gatto() {}
       public void verso(){}
}

public class Quiz {
    public void scrivi(Animale r) { 
        System.out.print("Animale "); 
    }
    
    public void scrivi(Cane l) { 
        System.out.print("Cane "); 
    }
    
    public void scrivi(Gatto s) { 
        System.out.print("Gatto "); 
    }

    public static void main(String args[]) {
        Quiz  m = new Quiz();

        Cane c = new Cane();
        Gatto g = new Gatto();
        Animale a = new Cane();
      
        a = g;
      
        m.scrivi(a);
        m.scrivi(g);
        m.scrivi(c);
    }
}