package constraints;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;

public class BinaryNotEqual implements Constraint {
	
	/**
	 * This method is in here because the overridden method only works for
	 * unary constraints...maybe we could switch the interface to Array
	 * List of type Item and just check the first one for unary constraints?
	 * @param bag
	 * @param item1
	 * @param item2
	 * @return
	 */
	ArrayList<ItemBag> bags = new ArrayList<ItemBag>();
	ArrayList<Item> items = new ArrayList<Item>();
	
	public BinaryNotEqual(ArrayList<ItemBag> bags, ArrayList<Item> items){
		this.bags = bags;
		this.items = items;
	}
	
	@Override
	public boolean isValid(ArrayList<ItemBag> bags, ArrayList<Item> items){
		for(ItemBag bag : bags){
			if(bag.getItems().containsAll(items))
				return false;
		}
		return true;
	}

}
