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
	
	public boolean isValid(ArrayList<ItemBag> bag, ArrayList<Item> i) {
		// TODO Auto-generated method stub
		if(this.item.getID() == i.get(0).getID() && this.bags.contains(i.get(0))){
			return true;
		}
		return false;
	}

}
