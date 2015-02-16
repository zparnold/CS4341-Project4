package main;

/**
 * All the constraints will derive from this class
 * @author Sean
 *
 */

public abstract class Constraint {
	boolean isValid(ItemBag bag, Item item){
		// TODO Auto-generated method stub
		return false;
	}

	boolean isValid(Item a, Item b) {
		// TODO Auto-generated method stub
		return false;
	}

}
