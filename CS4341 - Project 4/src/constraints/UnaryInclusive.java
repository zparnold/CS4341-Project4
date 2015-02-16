package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;

public class UnaryInclusive implements Constraint {
	/*
	 * (non-Javadoc)
	 * @see constraints.Constraint#isValid(main.ItemBag, main.Item)
	 * 
	 * Need to check if an item IS in a bag
	 */
	
	Item item;
	ArrayList<ItemBag> bags = new ArrayList<ItemBag>();
	
	public UnaryInclusive(ArrayList<ItemBag> bags, Item i){
		this.bags = bags;
		this.item = i;
	}
	
	public boolean isValid(ItemBag bag, Item i) {
		// TODO Auto-generated method stub
		if(this.item.getID() == i.getID() && this.bags.contains(i)){
			return true;
		}
		return false;
	}

}
