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
	
	public boolean tryPut(State s, ItemBag b, Item i){
		
		//If we try to put the item in a bag that cannot physically hold it, then return false
		if(i.getWeight() > (b.getCapacity() - b.getTotalWeight())){
			return false;
		}
		
		for (Constraint c : constraints){
			if(!c.isValid(s, b, i)){
				System.out.println(c.getClass() + b.getID() + i.getID());
				return false;
			}
		}
		s.addItemToBag(b, i);
		
		return true;
	}
	
}
