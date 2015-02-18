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
	ItemBag b;

	public UnaryExclusive(ItemBag bag, Item i) {
		this.b = bag;
		this.i = i;
	}

	@Override
	public boolean isValid(State currentState, ItemBag bag, Item item) {
		// TODO Auto-generated method stub
		if(bag.getID().equals(b.getID())){
			if(item.getID().equals(i.getID())){
				if(bag.getItems().contains(i)){
					return false;
				}
			}
		}
		
		return true;
	}

	

}
