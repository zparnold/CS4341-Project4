/**
 * 
 */
package constraints;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
		
		if(!s.getUnusedItems().contains(i)){
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
	
	/**
	 * 
	 * @return The variable that can be put into the LEAST amount of bags.
	 */
	public Item MostRestrainedVariable(State s){
		int[] itemArray = new int[s.getItems().size()];
		int index = 0;
		
		//For each item, if a constraint allows an item to be placed in a bag,
		//then we increment a counter corresponding to that items position in an array
		for(Item i : s.getItems()){
			for(ItemBag b : s.getBags()){
				for (Constraint c : constraints){
					if(c.isValid(s, b, i)){
						//System.out.println(c.getClass() + b.getID() + i.getID());
						itemArray[index]++;
					}
				}
			}
			index++;
		}
		
		List min = Arrays.asList(itemArray);
		int minIndex = min.indexOf(Collections.min(min));
		
		return s.getItems().get(minIndex);
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public Item leastConstrainingVariable(State s){
		
		
		return null;
	}
	
}
