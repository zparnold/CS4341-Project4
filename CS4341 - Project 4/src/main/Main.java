/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import constraints.BinaryEqual;
import constraints.BinaryMutualExclusive;
import constraints.BinaryNotEqual;
import constraints.ConstraintManager;
import constraints.UnaryExclusive;
import constraints.UnaryInclusive;

/**
 * @author Zach Arnold and Sean MacEachern
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader streamReader = new BufferedReader(
				new FileReader(args[0]));
		String line = "";
		Integer section = 0;
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<ItemBag> bags = new ArrayList<ItemBag>();

		ConstraintManager constraints = new ConstraintManager();
		// read the file
		while ((line = streamReader.readLine()) != null) {

			// denotes new section
			if (line.contains("#####")) {
				// depending on the section number, the data
				// has different relevance
				section++;
			} else {
				String[] s = line.split(" ");
				switch (section) {
				// This is items
				case 1:
					Item i = new Item(s[0], Integer.parseInt(s[1]));
					items.add(i);
					// TODO Decide what to do here
					break;

				// This is bags
				case 2:
					ItemBag ib = new ItemBag(s[0], Integer.parseInt(s[1]));
					bags.add(ib);
					break;

				// This is fitting limits
				case 3:
					// fittingLimits.add(line);
					for (ItemBag bag : bags) {
						bag.setLowerFit(Integer.parseInt(s[0]));
						bag.setUpperFit(Integer.parseInt(s[1]));
					}

					break;
				// This is unary inclusive
				case 4:
					Item addItem = new Item(null,0);
					for (Item item : items) {
						if (item.id == s[0])
							addItem = item;
					}

					ArrayList<ItemBag> ibArray = new ArrayList<ItemBag>();
					// Fetch the bags from the bag list
					for (int i1 = 1; i1 < s.length; i1++) {
						for (ItemBag bag : bags) {
							if (bag.id == s[i1])
								ibArray.add(bag);
						}
					}
					UnaryInclusive uc = new UnaryInclusive(ibArray, addItem);

					constraints.addConstraint(uc);
					break;
				// This is unary exclusive vars
				case 5:
					// Get the item from the list
					Item addUEItem = new Item(null, 0);
					for (Item item : items) {
						if (item.id == s[0])
							addUEItem = item;
					}

					ArrayList<ItemBag> ibUEArray = new ArrayList<ItemBag>();
					// Fetch the bags from the bag list
					for (int i1 = 1; i1 < s.length; i1++) {
						for (ItemBag bag : bags) {
							if (bag.id == s[i1])
								ibUEArray.add(bag);
						}
					}
					// Make the constraint
					UnaryExclusive ue = new UnaryExclusive(ibUEArray, addUEItem);

					// Add it to the constraint manager
					constraints.addConstraint(ue);
					break;
				// binary equal vars
				case 6:
					ArrayList<Item> beItems = new ArrayList<Item>();
					ArrayList<ItemBag> beBags = bags;

					// Loop over string array looking for bag matches
					for (int i1 = 0; i1 < s.length; i1++) {
						for (Item item : items) {
							if (item.id == s[i1])
								beItems.add(item);
						}
					}

					BinaryEqual be = new BinaryEqual(beBags, beItems);
					constraints.addConstraint(be);
					break;
				// This is binary not equals
				case 7:
					ArrayList<Item> bneItems = new ArrayList<Item>();
					ArrayList<ItemBag> bneBags = bags;

					// Loop over string array looking for bag matches
					for (int i1 = 0; i1 < s.length; i1++) {
						for (Item item : items) {
							if (item.id == s[i1])
								bneItems.add(item);
						}
					}

					BinaryNotEqual bne = new BinaryNotEqual(bneBags, bneItems);
					constraints.addConstraint(bne);

					break;
				// This is mutually exclusive
				case 8:

					// For example, a line "A B x y" means x cannot be assigned
					// to A if y is assigned to B, and vice versa.
					
					ArrayList<Item> meItems = new ArrayList<Item>();
					ArrayList<ItemBag> meBags = new ArrayList<ItemBag>();
					
					for (Item item : items){
						if (item.id == s[0] || item.id == s[1])
							meItems.add(item);
					}
					
					for (ItemBag itemBag : bags){
						if (itemBag.id == s[2] || itemBag.id == s[3])
							meBags.add(itemBag);
					}

					BinaryMutualExclusive me = new BinaryMutualExclusive(meBags, meItems);
					constraints.addConstraint(me);
					break;
				}
			}
		}

		// Now create the world, instantiate the solver and solve it!
		  
		  CSPSolver solver = new CSPSolver(items,bags,constraints);
		  
		  solver.backtrackSearch();
		 
		streamReader.close();

	}

}
