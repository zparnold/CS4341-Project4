package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;

public class BinaryMutualExclusive implements Constraint {
	
	/**
	 * 
	 * @param bag
	 * @param item1
	 * @param item2
	 * @return
	 */
	//This method is in here because the overridden method only works for
		//unary constraints...maybe we could switch the interface to Array
		//List of type Item and just check the first one for unary constraints?
	public boolean isValid(ItemBag bag, Item item1, Item item2){
		ArrayList<Item> check = new ArrayList<Item>();
		check.add(item1);
		check.add(item2);
		return (bag.getItems().containsAll(check));
	}

	@Override
	public boolean isValid(ItemBag bag, Item item) {
		// TODO Auto-generated method stub
		return false;
	}

}
