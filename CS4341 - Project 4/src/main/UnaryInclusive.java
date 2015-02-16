package main;

import java.util.ArrayList;

public class UnaryInclusive extends Constraint {
	
	/*
	 * We need to figure out which bags a particular item can be in
	 */
	Item item;
	ArrayList<ItemBag> itemBags;
	
	/**
	 * Initialize Constraint
	 * @param item
	 */
	UnaryInclusive(Item item){
		this.item = item;
	}
	
}
