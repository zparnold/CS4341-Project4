package main;

public class Item {
	int weight = 0;
	char id;
	
	public int getWeight() {
		return weight;
	}

	Item(char id, int weight){
		this.id = id;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", weight=" + weight + "]\n";
	}
	
}
