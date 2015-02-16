package main;

public class Item {
	int weight = 0;
	String id;
	
	public int getWeight() {
		return weight;
	}

	Item(String id, int weight){
		this.id = id;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", weight=" + weight + "]\n";
	}
	
}
