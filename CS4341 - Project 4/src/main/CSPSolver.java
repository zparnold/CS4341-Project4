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
	private Stack<State> stateStack = new Stack<State>();
	private Stack<Item> itemStack = new Stack<Item>();
	private ConstraintManager constraintManager;

	private static int steps, successes, fails = 0;

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
		// make a new state, push it on the stack
		// and call the recursive algorithm
		for (Item item : items) {
			itemStack.push(item);
		}
		State newState = new State(bags, items);
		stateStack.push(newState);
		return backtrackRecursive(newState);
	}

	/**
	 * 
	 * @param holder
	 * @return
	 */
	private State backtrackRecursive(State holder) {
		steps++;
		if (stateStack.isEmpty()) {
			System.out.println("Hooray! We're done");
			printSolution(holder);
			System.out.println("-----------------------------------");
			return holder;
		}

		Item var;

		// We've assigned all the variables
		// Item var = getUnassignedVar(holder);

		while (!stateStack.isEmpty()) {
			if ((var = getUnassignedVar2(holder)) == null) {
				System.out.println("Hooray! We're done");
				printSolution(holder);
				System.out.println("-----------------------------------");
				return holder;
			} else {
				
				State currentState = stateStack.pop();
				var = getUnassignedVar2(currentState);
				
				for (ItemBag bag : currentState.getBags()) {
					boolean successfulTry = false;
					//bag.addItem(var);
					
					System.out.println("----- Adding Item: " + var.getID() + " To Bag: " + bag.getID() + " -----");
					System.out.println("----- Checking the Current State -----");
					printSolution(currentState);
					
					if (constraintManager.tryPut(currentState, bag, var)) {
						if (stateValid(currentState)) {
							successfulTry = true;
							successes++;
						}
					} else {
						fails++;
						//bag.removeItem(var);
						System.out.println("----- Current State is not valid -----");
						System.out.println();
					}

					if (successfulTry) {
						System.out.println("----- Current State is valid. Deeper we go -----");
						stateStack.push(currentState);
						// backtrackRecursive(currentState);
					}
				}
			}
		}
		System.out.println("----- Unsatisfied Constraints -----");
		printSolution(holder);
		return holder;

	}

	public void printSolution(State s) {

		for (ItemBag bag : s.getBags()) {
			System.out.print(bag.id + " : ");
			for (Item i : bag.getItems()) {
				System.out.print(i.id + " ");
			}
			System.out.print("\n");
			System.out.println("Capacity : " + bag.getTotalWeight() + "/"
					+ bag.capacity);
			System.out.println("Wasted Capacity : " + bag.getWastedCapacity());
			System.out.println();
		}
		System.out.println("Successes: " + this.successes);
		System.out.println("Fails: " + this.fails);
		System.out.println("Total Steps: " + this.steps);

	}

	/**
	 * Gets the next unassigned variable
	 * 
	 * @return the item
	 */
	private Item getUnassignedVar(State s) {
		ArrayList<Item> unassigned = new ArrayList<Item>();

		for (Item item : s.getItems()) {
			if (item.isAssigned == false) {
				unassigned.add(item);
			}
		}

		if (unassigned.isEmpty())
			return null;
		else
			return unassigned.get(0);
	}
	
	private Item getUnassignedVar2(State s) {
		ArrayList<Item> unassigned = s.getUnusedItems();
		if(unassigned.isEmpty()){
			return null;
		}else{
			System.out.println(unassigned.toString());
			return unassigned.get(0);
		}
	}

	/**
	 * Checks that the given state is valid.
	 * 
	 * @param checkState
	 * @return
	 */
	public boolean stateValid(State checkState) {
		// Loop over bags and then items in the state to ensure validity
		// (Mostly checking to make sure that the bags are over 90%
		// full
		for (ItemBag bag : checkState.getBags()) {
			int weightSum = 0, itemCount = 0;

			for (Item item : checkState.getItems()) {
				if (item.isAssigned){
					//continue;
					itemCount += 1;
					weightSum += item.weight;
				}
			}

			if (((float) weightSum / bag.capacity) < 0.90) {

				return false;
			}
			/*
			if (!(itemCount < bag.lowerFit)) {
				return false;
			}
			*/
		}

		return true;
	}

	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
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
	 * @param bags
	 *            the bags to set
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
	 * @param counter
	 *            the counter to set
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
	 * @param stateStack
	 *            the stateStack to set
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
	 * @param constraintManager
	 *            the constraintManager to set
	 */
	public void setConstraintManager(ConstraintManager constraintManager) {
		this.constraintManager = constraintManager;
	}

}
