/**
 * 
 */
package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;
import main.State;

/**
 * @author Zach
 *
 */
public class ConstraintManager {
	
	private ArrayList<Constraint> constraints = new ArrayList<Constraint>();
	
	/**
	 * 
	 * @param s
	 */
	public ConstraintManager(){
		
	}

	public ArrayList<Constraint> getConstraints() {
		return constraints;
	}

	public void addConstraint(Constraint constraint) {
		this.constraints.add(constraint);
	}
	
	public boolean isSatisfied(State s){
		int successCount = 0;
		
		for (Constraint c : constraints){
			if(c.isValid(s.getBags(), s.getDomain()))
				successCount++;
		}
		
		if(successCount == constraints.size())
			return true;
		else 
			return false;
	}
	
}
