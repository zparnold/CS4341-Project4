/**
 * 
 */
package main;

/**
 * @author Zach
 *
 */
public class CSPSolver {
	
	private ConstraintHolder holder;
	private int counter = 0;

	public CSPSolver(ConstraintHolder holder){
		this.holder = holder;
	}
	
	/**
	 * Searches using the backtracking search algorithm for a solution
	 * to the CSP (Used algorithm from Russel and Norvig)
	 * @return boolean, whether or not the constraints are attainable
	 */
	public boolean backtrackSearch(){
		//Update statistics
		counter++;
		
		Object var = holder.getNextUnsatVar();
		
		return holder.getFlag();
		
		
	}

}
