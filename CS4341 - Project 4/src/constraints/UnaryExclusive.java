package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;
import main.State;

public class UnaryExclusive implements Constraint {
	/*
	 * (non-Javadoc)
	 * 
	 * @see constraints.Constraint#isValid(main.ItemBag, main.Item)
	 * 
	 * Need to check if an item is NOT in a bag
	 */

	Item i;
	ArrayList<ItemBag> b;

	public UnaryExclusive(ArrayList<ItemBag> bag, Item i) {
		this.b = bag;
		this.i = i;
	}

	@Override
	public boolean isValid(State currentState, ItemBag bag, Item item) {
		// TODO Auto-generated method stub
		if (item.getID().equals(i.getID())) {
			if (b.contains(bag)) {
				return false;
			}
		}

		return true;
	}
	
	@Override
	/**
	 * returns true if the constraint constrains is
	 */
	public boolean constrains(Item item) {
		return(item.equals(i));
	}

	@Override
	public void forwardMoveInvalid(State s) {
		// TODO Auto-generated method stub
		
	}

}
