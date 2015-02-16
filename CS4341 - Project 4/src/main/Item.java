package main;

public class Item {
	int weight = 0;
	String id;
	
	//Property for seeing if this item has been assigned or not
	boolean isAssigned;
	
	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	public int getWeight() {
		return weight;
	}
	
	public String getID(){
		return id;
	}

	Item(String id, int weight){
		this.id = id;
		this.weight = weight;
		this.isAssigned = false;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", weight=" + weight + "]\n";
	}
	
}
