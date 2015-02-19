/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author Zach
 *
 */
public class State {
	private ArrayList<ItemBag> bags;
	// Variables that haven't been assigned yet
	private ArrayList<Item> items;
	private ArrayList<Item> unusedItems = new ArrayList<Item>();;

	// private State parent;

	public ArrayList<ItemBag> getBags() {
		return bags;
	}

	public void setBags(ArrayList<ItemBag> bags) {
		this.bags = bags;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> newItems) {
		this.items = newItems;
	}

	/*
	 * public State getParent() { return parent; }
	 * 
	 * public void setParent(State parent) { this.parent = parent; }
	 */
	/**
	 * General constructor for the class
	 * 
	 * @param newBags
	 * @param newDomain
	 * @param newParent
	 */
	public State(ArrayList<ItemBag> newBags, ArrayList<Item> newItems,
			State newParent) {
		this.bags = newBags;
		this.items = newItems; 
		
		//this.parent = newParent;
	}

	/**
	 * Parent-less constructor for the class
	 * 
	 * @param newBags
	 * @param newDomain
	 */
	public State(ArrayList<ItemBag> newBags, ArrayList<Item> newDomain) {
		this.bags = newBags;
		this.items = newDomain;
		
		updateUnusedItems();
		System.out.println(unusedItems.toString());
		//this.parent = null;
	}
	
	/**
	 * Helper Function
	 * @return Return the items that are NOT already included in the state
	 */
	public ArrayList<Item> getUnusedItems(){
		return unusedItems;
	}
	
	public void addItemToBag(ItemBag bag, Item i){
		for(ItemBag ib : bags){
			if(ib.getID().equals(bag.getID())){
				ib.addItem(i);
			}
		}
		unusedItems.remove(i);
	}
	
	private void updateUnusedItems(){
		for(Item i : items){
			for(ItemBag b : bags){
				if(!b.getItems().contains(i) && !unusedItems.contains(i)){
					unusedItems.add(i);
				}
			}
		}
		//System.out.println(items.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "State [bags=" + bags + ", domain=" + items + "]";
	}

}