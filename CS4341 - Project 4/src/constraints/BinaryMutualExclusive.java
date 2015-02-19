package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;
import main.State;

public class BinaryMutualExclusive implements Constraint {
	
	/**
	 * 
	 * @param bag
	 * @param item1
	 * @param item2
	 * @return
	 */
	Item a, b;
	ItemBag A, B;
	
	public BinaryMutualExclusive(ItemBag A, ItemBag B, Item a, Item b){
		this.A = A;
		this.B = B;
		this.a = a;
		this.b = b;
		
	}
	
	/**
	 * If inserted item matches one of the items in this contraint
	 * then if the complimentary item exists in a complimentary bag
	 * then we return false.
	 */
	@Override
	public boolean isValid(State currentState, ItemBag bag, Item item) {
		if(bag.getID().equals(A.getID())){
			if(item.getID().equals(a.getID())){
				if(A.getItems().contains(a) && B.getItems().contains(b)){
					return false;
				}
				
				if(A.getItems().contains(b) && B.getItems().contains(a)){
					return false;
				}
			}
		}
		
		if(bag.getID().equals(B.getID())){
			if(item.getID().equals(b.getID())){
				if(B.getItems().contains(b) && A.getItems().contains(a)){
					return false;
				}
				
				if(B.getItems().contains(a) && A.getItems().contains(b)){
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

	@Override
	public void forwardMoveInvalid(State s) {
		// TODO Auto-generated method stub
		
	}


}
