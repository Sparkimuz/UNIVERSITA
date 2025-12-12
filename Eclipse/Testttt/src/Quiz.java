
class X {
    
    public void me(){
        System.out.println("X");
    }
    
    public void greet(X x) {
        System.out.println("greet(X)");
    }

}

class Y extends X {
    @Override
    public void me(){
        System.out.println("Y");
    }
    
    public void greet(Y y) {
        System.out.println("greet(Y)");
    } 
    
}

public class Quiz {
    public static void main (String[] args) {
        X a = new Y();
        Y b = new Y();
        
        a.me();
        a.greet(b);
        a.greet(a);
    }
    
}