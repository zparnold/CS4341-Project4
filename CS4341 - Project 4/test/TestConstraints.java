import static org.junit.Assert.*;

import java.util.ArrayList;

import main.Item;
import main.ItemBag;

import org.junit.Before;
import org.junit.Test;

import constraints.BinaryMutualExclusive;
import constraints.UnaryInclusive;

/**
 * 
 */

/**
 * @author Zach
 *
 */
public class TestConstraints {
	
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<ItemBag> bags = new ArrayList<ItemBag>();
	UnaryInclusive ui;
	BinaryMutualExclusive bme;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Item a = new Item("z",30);
		items.add(a);
		items.add(new Item("e", 15));
		items.add(new Item("w",60));
		ItemBag ib = new ItemBag("A",90);
		ib.addItem(a);
		bags.add(ib);
		bags.add(new ItemBag("B",75));
		
		ui = new UnaryInclusive(bags,items.get(0));
		//bme = new BinaryMutualExclusive(bags,items);
	}

	@Test
	public void testMutualExclusiveConstraintValidity() {
		 ArrayList<Item> uiItem = new ArrayList<Item>();
		 uiItem.add(ui.item);
		assertTrue(ui.isValid(bags,uiItem));
	}

}
