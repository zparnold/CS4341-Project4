/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Stack;

import constraints.ConstraintManager;

/**
 * @author Zach
 *
 */
public class CSPSolver {

	private ArrayList<Item> items;
	private ArrayList<ItemBag> bags;
	private int counter = 0;
	private Stack<State> stateStack;
	private ConstraintManager constraintManager;

	public CSPSolver(ArrayList<Item> items, ArrayList<ItemBag> bags,
			ConstraintManager constraints) {
		this.items = items;
		this.bags = bags;
		this.constraintManager = constraints;
	}

	/**
	 * Searches using the backtracking search algorithm for a solution to the
	 * CSP (Used algorithm from Russel and Norvig)
	 * 
	 * @return boolean, whether or not the constraints are attainable
	 */
	public State backtrackSearch() {
		return backtrackRecursive(new State(bags,items));

	}

	
	private State backtrackRecursive(State holder) {
		// Update statistics (for later)
		counter++;
		this.stateStack.push(holder);

		if (holder.getDomain().isEmpty()) {
			return holder;
		}

		Item var = this.getUnassignedVar(holder);

		
		for (ItemBag bag : holder.getBags()) {
			if ((bag.capacity - bag.getTotalWeight()) >= var.weight){
				bag.items.add(var);
				
				if (constraintManager.isSatisfied(holder)) {
					
					backtrackRecursive(holder);
				}
				else{
					stateStack.pop();
					
				}
			}

		}

		return holder;
	}
	
	/**
	 * Gets the next unassigned variable
	 * @return the item
	 */
	private Item getUnassignedVar(State s){
		return s.getDomain().get(0);
	}

	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	/**
	 * @return the bags
	 */
	public ArrayList<ItemBag> getBags() {
		return bags;
	}

	/**
	 * @param bags the bags to set
	 */
	public void setBags(ArrayList<ItemBag> bags) {
		this.bags = bags;
	}

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * @return the stateStack
	 */
	public Stack<State> getStateStack() {
		return stateStack;
	}

	/**
	 * @param stateStack the stateStack to set
	 */
	public void setStateStack(Stack<State> stateStack) {
		this.stateStack = stateStack;
	}

	/**
	 * @return the constraintManager
	 */
	public ConstraintManager getConstraintManager() {
		return constraintManager;
	}

	/**
	 * @param constraintManager the constraintManager to set
	 */
	public void setConstraintManager(ConstraintManager constraintManager) {
		this.constraintManager = constraintManager;
	}

}
