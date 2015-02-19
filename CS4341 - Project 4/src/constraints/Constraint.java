package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;
import main.State;

/**
 * All the constraints will derive from this class
 * @author Sean
 *
 */

public interface Constraint {
	
	/**
	 * Each Constraint will have a function that verifies if its been validated
	 * @param bag The bag we are trying to insert into.
	 * @param item The item we are trying to insert.
	 * @return valid
	 */
	boolean isValid(State currentState, ItemBag bag, Item item);

	boolean constrains(Item i);

	void forwardMoveInvalid(State s);

}
