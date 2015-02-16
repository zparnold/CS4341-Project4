/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
		
		ArrayList<String> unaryInclusive = new ArrayList<String>();
		ArrayList<String> unaryExclusive = new ArrayList<String>();
		ArrayList<String> binaryEquals = new ArrayList<String>();
		ArrayList<String> binaryNotEquals = new ArrayList<String>();
		ArrayList<String> mutuallyExclusive = new ArrayList<String>();

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
					//fittingLimits.add(line);
					for(ItemBag bag : bags){
						bag.setLowerFit(Integer.parseInt(s[0]));
						bag.setUpperFit(Integer.parseInt(s[1]));
					}
					
					break;
				// This is unary inclusive
				case 4:
					unaryInclusive.add(line);
					break;
				// This is unary exclusive vars
				case 5:
					unaryExclusive.add(line);
					break;
				// binary equal vars
				case 6:
					binaryEquals.add(line);
					break;
				// This is binary not equals
				case 7:
					binaryNotEquals.add(line);
					break;
				// This is mutually exclusive
				case 8:
					mutuallyExclusive.add(line);
					break;
				}
			}
		}
		
		//Now create the world, instantiate the solver and solve it!
		/*
		ConstraintHolder world = new ConstraintHolder(items, bags,
				fittingLimits, unaryInclusive, unaryExclusive, binaryEquals,
				binaryNotEquals, mutuallyExclusive);
		
		CSPSolver solver = new CSPSolver(world);
		
		solver.backtrackSearch();
		*/
		streamReader.close();

	}

}
