package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;
import main.State;

public class BinaryEqual implements Constraint {
	
	/**
	 * Class for Binary Equals Operation
	 * @param item1
	 * @param item2
	 * @return
	 */
	Item a;
	Item b;
	
	public BinaryEqual(Item A, Item B){
		this.a = A;
		this.b = B;
	}

	/**
	 * If two items are in the same bag, then isValid returns true
	 */
	@Override
	public boolean isValid(State currentState, ItemBag bag, Item item) {
		//If input item is the same as item in constraint
		if(bag.getItems().isEmpty()){
			return true;
		}
		
		if(item.getID().equals(a.getID())){
			//If first item is in the bag
			
				if(!bag.getItems().contains(b)){
					return false;
				} else {
					return true;
				}
			
		}
		
		//Do the same for untested item
		if(item.getID().equals(b.getID())){
			//If first item is in the bag
			
				if(!bag.getItems().contains(a)){
					return false;
				} else {
					return true;
				}
			
		}
		
		
		return true;
	}

	@Override
	/**
	 * returns true if the constraint constrains is
	 */
	public boolean constrains(Item i) {
		return(a.equals(i) || b.equals(i));
	}

	@Override
	public void forwardMoveInvalid(State s) {
		// TODO Auto-generated method stub
		
	}

	
}
