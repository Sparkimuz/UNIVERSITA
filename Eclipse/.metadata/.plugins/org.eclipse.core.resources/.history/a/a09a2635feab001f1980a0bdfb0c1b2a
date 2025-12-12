
class X {
	public void dim(X x) {
		System.out.print("X.dim(X)");
	}
	public void dim(Y y) {
		System.out.print("X.dim(Y)");
	}
	public void dim(Z z) {
		System.out.print("X.dim(Z)");
	}
}

class Z extends X {
	public void dim(X x) {
		System.out.print("Z.dim(X)");
	}
	public void dim(Y y) {
		System.out.print("Z.dim(Y)");
	}
	public void dim(Z z) {
		System.out.print("Z.dim(Z)");
	}
}

public class Y extends X {
	public void dim(X x) {
		System.out.print("Y.dim(X)");
	}
	public void dim(Y y) {
		System.out.print("Y.dim(Y)");
	}
	public void dim(Z z) {
		System.out.print("Y.dim(Z)");
	}
	
	public static void main(String args[]) {
		X a = new Z();
		Y b = new Y();
		a.dim(b);
		Y a1 = new Y();
		System.out.print(" - ");
		a1.dim(a);
	}
}
