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
			return (T) holder.getAssignedVars();
		}

		Item var = holder.getUnusedItems().get(0);

		// world.orderDomainValues();
		for (ItemBag val : holder.getBagVals()) {

			// Logic
			holder.addAssignment(var);
			val.getItems().add(var);
			holder.getVariables().remove(var);

			if (holder.checkUIConstraint(var) && holder.checkUEConstraint(var)
					&& holder.checkBEContstraint(var)
					&& holder.checkBNEConstraint(var)
					&& holder.checkMEConstraint(var)) {
				
				backtrackRecursive(holder);
			}

		}

		return (T) holder.isFlag();
	}

}
