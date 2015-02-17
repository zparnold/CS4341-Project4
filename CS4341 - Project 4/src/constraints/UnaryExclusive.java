package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;

public class UnaryExclusive implements Constraint {
	/*
	 * (non-Javadoc)
	 * @see constraints.Constraint#isValid(main.ItemBag, main.Item)
	 * 
	 * Need to check if an item is NOT in a bag
	 */
	
	Item item;
	ArrayList<ItemBag> bags = new ArrayList<ItemBag>();
	
	public UnaryExclusive(ArrayList<ItemBag> bags, Item i){
		this.bags = bags;
		this.item = i;
	}
	
	public boolean isValid(ArrayList<ItemBag> bag, ArrayList<Item> i) {
		// TODO Auto-generated method stub
		if(this.item.getID() == i.get(0).getID() && this.bags.contains(i.get(0))){
			return false;
		}
		return true;
	}

}
