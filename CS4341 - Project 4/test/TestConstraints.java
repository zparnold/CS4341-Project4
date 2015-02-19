import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import main.Item;
import main.ItemBag;
import main.State;

import org.junit.Before;
import org.junit.Test;

import constraints.BinaryEqual;
import constraints.BinaryMutualExclusive;
import constraints.BinaryNotEqual;
import constraints.UnaryExclusive;
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
	UnaryExclusive ue;
	BinaryMutualExclusive bme;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		//bme = new BinaryMutualExclusive(bags,items);
	}

	@Test
	public void testUnaryInclusiveConstraintValidity() {
		Item C14 = new Item("C",14);
		items.add(C14);
		Item D14 = new Item("D",14);
		items.add(D14);
		
		ItemBag q15 = new ItemBag("q",15);
		ItemBag p15 = new ItemBag("p",15);
		bags.add(p15);
		bags.add(q15);
		
		p15.addItem(C14);
		
		ArrayList<ItemBag> p15Array = new ArrayList<ItemBag>();
		
		p15Array.add(p15);
		
		ui = new UnaryInclusive(p15Array,C14);
		ue = new UnaryExclusive(p15Array,C14);
		State s = new State(bags,items);
		assertTrue(ui.isValid(s,p15,C14));
		assertFalse(ue.isValid(s,p15,C14));
	}
	
	@Test
	public void testBinaryInExclusiveConstraintValidity() {
		Item C14 = new Item("C",14);
		items.add(C14);
		Item D14 = new Item("D",14);
		items.add(D14);
		
		ItemBag q15 = new ItemBag("q",15);
		ItemBag p15 = new ItemBag("p",15);
		bags.add(p15);
		bags.add(q15);
		
		p15.addItem(C14);
		p15.addItem(D14);
		
		ArrayList<ItemBag> p15Array = new ArrayList<ItemBag>(Arrays.asList(p15));
		
		
		BinaryEqual be = new BinaryEqual(D14,C14);
		BinaryNotEqual bne = new BinaryNotEqual(D14,C14);
		
		State s = new State(bags,items);
		assertTrue(be.isValid(s,p15,C14));
		assertFalse(bne.isValid(s,p15,C14));
	}
	
	@Test
	public void testMutualExclusiveConstraintValidity() {
		Item C14 = new Item("C",14);
		items.add(C14);
		Item D14 = new Item("D",14);
		items.add(D14);
		
		ItemBag q15 = new ItemBag("q",15);
		ItemBag p15 = new ItemBag("p",15);
		bags.add(p15);
		bags.add(q15);
		
		p15.addItem(C14);
		p15.addItem(D14);
		
		
		BinaryMutualExclusive bme = new BinaryMutualExclusive(p15,q15,C14,D14);
		
		State s = new State(bags,items);
		assertTrue(bme.isValid(s,p15,C14));
	}
	
	@Test
	public void testMutualExclusiveConstraintValidity2() {
		Item C14 = new Item("C",14);
		items.add(C14);
		Item D14 = new Item("D",14);
		items.add(D14);
		
		ItemBag q15 = new ItemBag("q",15);
		ItemBag p15 = new ItemBag("p",15);
		bags.add(p15);
		bags.add(q15);
		
		p15.addItem(C14);
		q15.addItem(D14);
		
		
		
		BinaryMutualExclusive bme = new BinaryMutualExclusive(p15,q15,C14,D14);
		
		State s = new State(bags,items);
		assertFalse(bme.isValid(s,p15,C14));
	}

}
