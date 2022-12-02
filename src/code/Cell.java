package code;

public class Cell {
	int i;
    int j;
    public Cell(int i, int j){
        this.i = i;
        this.j = j;
    }
    public String toString(){
        String type = "Em";
        if (this instanceof Agent) type = "Ag";
        if (this instanceof Station) type = "St";
        if (this instanceof Ship) type = "Sh";
        return type;
    }
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public Cell clone() {
		return new Cell(i,j);
	}
//	public int hashCode() {
//		return i*1 + j*10;
//	}
}
