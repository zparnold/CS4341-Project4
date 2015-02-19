/**
 * 
 */
package constraints;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import main.Item;
import main.ItemBag;
import main.State;

/**
 * @author Zach
 *
 */
public class ConstraintManager {

	private ArrayList<Constraint> constraints = new ArrayList<Constraint>();

	/**
	 * 
	 * @param s
	 */
	public ConstraintManager() {

	}

	public ArrayList<Constraint> getConstraints() {
		return constraints;
	}

	public void addConstraint(Constraint constraint) {
		this.constraints.add(constraint);
	}

	public boolean tryPut(State s, ItemBag b, Item i) {

		// If we try to put the item in a bag that cannot physically hold it,
		// then return false
		if (i.getWeight() > (b.getCapacity() - b.getTotalWeight())) {
			return false;
		}

		if (!s.getUnusedItems().contains(i)) {
			return false;
		}

		for (Constraint c : constraints) {
			if (!c.isValid(s, b, i)) {
				System.out.println(c.getClass() + b.getID() + i.getID());
				return false;
			}
		}
		s.addItemToBag(b, i);

		return true;
	}

	/**
	 * 
	 * @return The variable that can be put into the LEAST amount of bags.
	 */
	public Item MostRestrainedVariable(State s) {
		int[] itemArray = new int[s.getItems().size()];
		int index = 0;

		// For each item, if a constraint allows an item to be placed in a bag,
		// then we increment a counter corresponding to that items position in
		// an array
		for (Item i : s.getUnusedItems()) {
			for (ItemBag b : s.getBags()) {
				for (Constraint c : constraints) {
					if (c.isValid(s, b, i)) {
						// System.out.println(c.getClass() + b.getID() +
						// i.getID());
						itemArray[index]++;
					}
				}
			}
			index++;
		}

		List min = Arrays.asList(itemArray);
		int minIndex = min.indexOf(Collections.min(min));

		return s.getItems().get(minIndex);
	}

	/**
	 * 
	 * @param s
	 *            the State to analyze
	 * @return the item with the least number of constraints assigned to it
	 */
	public Item leastConstrainingVariable(State s) {

		int[] lcvCount = new int[s.getItems().size()];
		int index = 0;

		// basically the same as above, if we can assign it to a lot of things
		// then it makes sense to assume that it is not a constraining impact
		// on the problems
		for (Item i : s.getUnusedItems()) {
			for (ItemBag b : s.getBags()) {
				for (Constraint c : constraints) {
					if (c.isValid(s, b, i)) {

						lcvCount[index]++;
					}
				}
			}
			index++;
		}

		List max = Arrays.asList(lcvCount);
		int maxIndex = max.indexOf(Collections.max(max));

		return s.getItems().get(maxIndex);
	}
	
	/**
	 * 
	 * @param s
	 */
	public void initalizeFC(State s) {
		// make a new array of constraints
		ArrayList<Constraint> binaryEqual = new ArrayList<Constraint>();

		for (Constraint c : constraints) {
			if (c.getClass() == UnaryInclusive.class
					|| c.getClass() == UnaryExclusive.class) {

			}
			if (c.getClass() == BinaryEqual.class)
				binaryEqual.add(c);
		}

	}

	/**
	 * Gets the best next variable following the degree heuristic
	 * 
	 * @return and Item to place next
	 */
	public Item degreeHeuristic(State s) {

		int maxDegree = Integer.MIN_VALUE;

		// First, get the most restrained variable
		Item mostRestrained = MostRestrainedVariable(s);

		// now loop over items looking for the one that
		// is subject to the most number of constraints
		for (Item i : s.getItems()) {
			int degree = 0;
			for (Constraint c : constraints) {
				if (c.constrains(i)) {
					degree++;
				}
			}

			if (degree > maxDegree) {
				maxDegree = degree;
				mostRestrained = i;
			}
		}

		return mostRestrained;
	}

	/**
	 * 
	 * @param s
	 */
	public void forwardCheck(State s) {
		// If any of the next moves are a binary type
		// They will invalidate our forward check
		for (Constraint c : constraints) {
			if (c.getClass() == BinaryNotEqual.class
					|| c.getClass() == BinaryEqual.class
					|| c.getClass() == BinaryMutualExclusive.class) {

				c.forwardMoveInvalid(s);
			}
		}
	}

	/**
	 * 
	 * @param s
	 *            the state to check
	 * @return true or false if the bag is invalid at this state level
	 */
	public boolean checkForwardBagInvalidate(State s) {
		//now check the remaining items of the state
		//to see if we can use them
		for (Item i : s.getUnusedItems()) {
			int bagCount = 0;
			for (ItemBag b : s.getBags()) {
				if (b.getItems().contains(i))
					bagCount++;
			}
			if (bagCount == s.getBags().size()) {
				return true;
			}
		}
		return false;
	}



}
