package code;

public class Ship extends Cell{
    public int no_of_passengers;
    int blackbox_damage;

    public Ship(int i, int j, int no_of_passengers){
        super(i,j);
        this.no_of_passengers = no_of_passengers;
        blackbox_damage = 0;
    }
	public Ship(int i, int j, int no_of_passengers, int blackbox_damage){
		super(i,j);
		this.no_of_passengers = no_of_passengers;
		this.blackbox_damage = blackbox_damage;
	}
	public boolean hasBlackBox() {
		return blackbox_damage<20;
	}
	public int getNoOfPassengers() {
		return no_of_passengers;
	}
	public void setNoOfPassengers(int no_of_passengers) {
		this.no_of_passengers = no_of_passengers;
	}
	public int getBlackBoxDamage() {
		return blackbox_damage;
	}
	public void setBlackBoxDamage(int blackbox_damage) {
		this.blackbox_damage = (this.blackbox_damage > 20) ? 20:blackbox_damage;
	}
	public boolean isWreck() {
		if(no_of_passengers == 0) return true;
		return false;
	}
	public void decrement() {
		if(no_of_passengers>0) { 
			no_of_passengers--;
			if (no_of_passengers == 0) blackbox_damage = 1;
		}
		else if(blackbox_damage<20){
				blackbox_damage++;
		}
	}
	public Ship clone() {
		return new Ship(i,j,no_of_passengers,blackbox_damage);
	}
}