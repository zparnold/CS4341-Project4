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
		//this.parent = null;
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