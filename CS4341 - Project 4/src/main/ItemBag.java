package main;

import java.util.ArrayList;

public class ItemBag {
	char id;
	int capacity = 0;
	ArrayList<Item> items; 
	
	public int getCapacity() {
		return capacity;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	
	ItemBag(char id, int capacity){
		this.id = id;
		this.capacity = capacity;
		items = new ArrayList<Item>();
	}
	
	int getTotalWeight(){
		int totalWeight = 0;
		for(Item i : items){
			totalWeight += i.weight;
		}
		return totalWeight;
	}
	
	int getWastedCapacity(){
		return capacity - getTotalWeight();
	}

	@Override
	public String toString() {
		return "ItemBag [id=" + id + ", capacity=" + capacity + ", items="
				+ items + "]\n";
	}
	
	
}
