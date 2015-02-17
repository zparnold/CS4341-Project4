/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Zach
 *
 */
public class CSPSolver {

	private ConstraintHolder holder;
	private int counter = 0;
	private Stack<State> stateStack;

	public CSPSolver(ConstraintHolder holder) {
		this.holder = holder;
	}

	/**
	 * Searches using the backtracking search algorithm for a solution to the
	 * CSP (Used algorithm from Russel and Norvig)
	 * 
	 * @return boolean, whether or not the constraints are attainable
	 */
	public State backtrackSearch() {
		return backtrackRecursive(new State(holder.getBagVals(),holder.getVariables()));

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
				
				if (holder.checkUIConstraint() && holder.checkUEConstraint()
						&& holder.checkBEContstraint()
						&& holder.checkBNEConstraint()
						&& holder.checkMEConstraint()) {
					
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

}
