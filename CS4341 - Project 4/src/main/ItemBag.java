package main;

import java.util.ArrayList;

public class ItemBag {
	String id;
	int capacity = 0;
	int lowerFit = 0, upperFit = 0;
	ArrayList<Item> items; 
	
	/**
	 * Creates a Bag for holding items given an ID and a capacity
	 * @param id
	 * @param capacity
	 */
	public ItemBag(String id, int capacity){
		this.id = id;
		this.capacity = capacity;
		items = new ArrayList<Item>();
	}
	
	/**
	 * Returns the Wasted Capacity measurement
	 * @return Wasted Capacity
	 */
	int getWastedCapacity(){
		return capacity - getTotalWeight();
	}
	
	/**
	 * Helper function for getWastedCapacity
	 * @return The total weight of all items in the bag.
	 */
	int getTotalWeight(){
		int totalWeight = 0;
		if(items.size() == 0){
			return totalWeight;
		}
		
		for(Item i : items){
			totalWeight += i.weight;
		}
		return totalWeight;
	}
	
	/**
	 * Getter for capacity
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Getter for list of items
	 * @return items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void addItem(Item i){
		this.items.add(i);
	}

	public void setLowerFit(int lowerFit) {
		this.lowerFit = lowerFit;
	}

	public void setUpperFit(int upperFit) {
		this.upperFit = upperFit;
	}

	@Override
	public String toString() {
		return "ItemBag [id=" + id + ", capacity=" + capacity + ", items="
				+ items + "]\n";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		ItemBag itemBagToCheck = (ItemBag) obj;
		return this.id.equals(itemBagToCheck.id)
				&& this.capacity == itemBagToCheck.capacity;
	}

	public int compareTo(Object arg0) {
		return this.id.compareTo(((ItemBag) arg0).id);
	}
}
