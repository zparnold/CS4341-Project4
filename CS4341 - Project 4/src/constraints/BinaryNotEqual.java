package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;
import main.State;

public class BinaryNotEqual implements Constraint {
	
	/**
	 * This method is in here because the overridden method only works for
	 * unary constraints...maybe we could switch the interface to Array
	 * List of type Item and just check the first one for unary constraints?
	 * @param bag
	 * @param item1
	 * @param item2
	 * @return
	 */
	Item a;
	Item b;
	
	public BinaryNotEqual(Item A, Item B){
		this.a = A;
		this.b = B;
	}

	/**
	 * If two items are in the same bag, then isValid returns true
	 */
	@Override
	public boolean isValid(State currentState, ItemBag bag, Item item) {
		//If input item is the same as item in constraint
		if(item.getID().equals(a.getID())){
			//If first item is in the bag
			if(bag.getItems().contains(a)){
				if(bag.getItems().contains(b)){
					return false;
				}
			}
		}
		
		//Do the same for untested item
		if(item.getID().equals(b.getID())){
			//If first item is in the bag
			if(bag.getItems().contains(b)){
				if(bag.getItems().contains(a)){
					return false;
				}
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

}
