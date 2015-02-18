package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;

public class UnaryExclusive implements Constraint {
	/*
	 * (non-Javadoc)
	 * 
	 * @see constraints.Constraint#isValid(main.ItemBag, main.Item)
	 * 
	 * Need to check if an item is NOT in a bag
	 */

	Item item;
	ArrayList<ItemBag> bags = new ArrayList<ItemBag>();

	public UnaryExclusive(ArrayList<ItemBag> bags, Item i) {
		this.bags = bags;
		this.item = i;
	}

	public boolean isValid(ArrayList<ItemBag> bag, ArrayList<Item> i) {
		// Loop over bags, ensure all items are in at least one
		boolean flag = true;

		for (ItemBag itemBag : bags) {
			if (itemBag.getItems().containsAll(i))
				flag = false;
		}
		return flag;
	}

}
