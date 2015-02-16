/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author Zach
 *
 */
public class CSPSolver {

	private ConstraintHolder holder;
	private int counter = 0;

	public CSPSolver(ConstraintHolder holder) {
		this.holder = holder;
	}

	/**
	 * Searches using the backtracking search algorithm for a solution to the
	 * CSP (Used algorithm from Russel and Norvig)
	 * 
	 * @return boolean, whether or not the constraints are attainable
	 */
	public boolean backtrackSearch() {
		return backtrackRecursive(holder);

	}

	@SuppressWarnings("unchecked")
	private <T> T backtrackRecursive(ConstraintHolder holder) {
		// Update statistics (for later)
		counter++;

		if (holder.isComplete()) {
			return (T) holder;
		}

		ArrayList<ItemBag> var = holder.getNextUnsatVars();

		// world.orderDomainValues();
		for (ItemBag val : holder.getBagVals()) {

			holder.addAssignment(var, val);
			

		}

		return (T) holder.isFlag();
	}

}
