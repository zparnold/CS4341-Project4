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
	private ArrayList<Item> domain;
	private State parent;

	public ArrayList<ItemBag> getBags() {
		return bags;
	}

	public void setBags(ArrayList<ItemBag> bags) {
		this.bags = bags;
	}

	public ArrayList<Item> getDomain() {
		return domain;
	}

	public void setDomain(ArrayList<Item> domain) {
		this.domain = domain;
	}

	public State getParent() {
		return parent;
	}

	public void setParent(State parent) {
		this.parent = parent;
	}

	/**
	 * General constructor for the class
	 * @param newBags
	 * @param newDomain
	 * @param newParent
	 */
	public State(ArrayList<ItemBag> newBags, ArrayList<Item> newDomain,
			State newParent) {
		this.bags = newBags;
		this.domain = newDomain;
		this.parent = newParent;
	}
	
	/**
	 * Parent-less constructor for the class
	 * @param newBags
	 * @param newDomain
	 */
	public State(ArrayList<ItemBag> newBags, ArrayList<Item> newDomain){
		this.bags = newBags;
		this.domain = newDomain;
		this.parent = null;
	}

	public boolean checkUIConstraint() {
		// TODO Auto-generated method stub
		
		for(ItemBag bag : this.bags){
			
		}
		return false;
	}

	public boolean checkUEConstraint() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkBEContstraint() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkBNEConstraint() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkMEConstraint() {
		// TODO Auto-generated method stub
		return false;
	}
}