package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;

/**
 * All the constraints will derive from this class
 * @author Sean
 *
 */

public interface Constraint {
	
	/**
	 * Each Constraint will have a function that verifies if its been validated
	 * @param bag
	 * @param item
	 * @return valid
	 */
	boolean isValid(ArrayList<ItemBag> bag, ArrayList<Item> items);
}
