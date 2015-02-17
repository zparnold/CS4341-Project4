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
	ArrayList<ItemBag> bags = new ArrayList<ItemBag>();
	ArrayList<Item> items = new ArrayList<Item>();
	
	BinaryMutualExclusive(ArrayList<ItemBag> bags, ArrayList<Item> items){
		this.bags = bags;
		this.items = items;
	}

	/*
	 * We always know that with Mutually Esclusive Contraints that there will be TWO bags
	 * and TWO items. If A contains a, then B cannot contain b and vice versa.
	 */
	@Override
	public boolean isValid(ArrayList<ItemBag> bags, ArrayList<Item> items){
		if(bags.get(0).getItems().contains(items.get(0)) && bags.get(1).getItems().contains(items.get(1))
				|| bags.get(1).getItems().contains(items.get(1)) && bags.get(0).getItems().contains(items.get(0))){
			return false;
		}
		
		return true;
	}


}
