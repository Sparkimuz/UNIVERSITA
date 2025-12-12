package codice;

public class Coordinate{
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void Sposta(int dx, int dy){
    	this.setX(this.x +dx);
    	this.setY(this.y +dy);
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return this.x == other.x && this.y == other.y;
    }

    public int distanzaDa(Coordinate other){
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy));
    }
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
        
}
