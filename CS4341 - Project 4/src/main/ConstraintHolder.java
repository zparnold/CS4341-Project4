/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Zach
 *
 */
public class ConstraintHolder {
	//Whether or not the problem is attainable
	private boolean flag = false;
	private ArrayList<Item> variables = new ArrayList<Item>();
	private ArrayList<ItemBag> bagVals = new ArrayList<ItemBag>();
	private ArrayList<String> fittingLimits = new ArrayList<String>();
	private ArrayList<String> unaryInclusive = new ArrayList<String>();
	private ArrayList<String> unaryExclusive = new ArrayList<String>();
	private ArrayList<String> binaryEquals = new ArrayList<String>();
	private ArrayList<String> binaryNotEquals = new ArrayList<String>();
	private ArrayList<String> mutuallyExclusive = new ArrayList<String>();
	
	private HashMap<ItemBag,ArrayList<Item>> assignedVars = new HashMap<ItemBag,ArrayList<Item>>();
	
	public ConstraintHolder(ArrayList<Item> variables2, ArrayList<ItemBag> bagVals2, ArrayList<String> fittingLimits2, ArrayList<String> unaryInclusive2, ArrayList<String> unaryExclusive2, ArrayList<String> binaryEquals2, ArrayList<String> binaryNotEquals2, ArrayList<String> mutuallyExclusive2){
		setVariables(variables2);
		setBagVals(bagVals2);
		setFittingLimits(fittingLimits2);
		setUnaryInclusive(unaryInclusive2);
		setUnaryExclusive(unaryExclusive2);
		setBinaryEquals(binaryEquals2);
		setBinaryNotEquals(binaryNotEquals2);
		setMutuallyExclusive(mutuallyExclusive2);
	}
	

	/**
	 * Gets the unused Items from the variable declarations
	 * @return an array list of unused Items
	 */
	public ArrayList<Item> getUnusedItems(){
		ArrayList<Item> unused = new ArrayList<Item>();
		
		for (Item i:this.getVariables()){
			if(!this.assignedVars.entrySet().contains(i)){
				unused.add(i);
			}
		}
		return unused;
	}
	/**
	 * Gets the next unsatisfied variable looking for minimum remaining value
	 * @return the Item that is next to be analyzed
	 */
	public ArrayList<ItemBag> getNextUnsatVars() {
		
		 //If we haven't assigned anything yet, then we can do anything!
		if (assignedVars.keySet() == null){
			return this.getBagVals();
		}
		
		//Otherwise, look at all of the variables and decide
		
		for (Item i:this.getVariables()){
			
		}
		return null;
	}



	/**
	 * @return the flag
	 */
	public Boolean isFlag() {
		return flag;
	}



	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}



	/**
	 * @return the variables
	 */
	public ArrayList<Item> getVariables() {
		return variables;
	}



	/**
	 * @param variables the variables to set
	 */
	public void setVariables(ArrayList<Item> variables) {
		this.variables = variables;
	}



	/**
	 * @return the bagVals
	 */
	public ArrayList<ItemBag> getBagVals() {
		return bagVals;
	}



	/**
	 * @param bagVals the bagVals to set
	 */
	public void setBagVals(ArrayList<ItemBag> bagVals) {
		this.bagVals = bagVals;
	}



	/**
	 * @return the fittingLimits
	 */
	public ArrayList<String> getFittingLimits() {
		return fittingLimits;
	}



	/**
	 * @param fittingLimits the fittingLimits to set
	 */
	public void setFittingLimits(ArrayList<String> fittingLimits) {
		this.fittingLimits = fittingLimits;
	}



	/**
	 * @return the unaryInclusive
	 */
	public ArrayList<String> getUnaryInclusive() {
		return unaryInclusive;
	}



	/**
	 * @param unaryInclusive the unaryInclusive to set
	 */
	public void setUnaryInclusive(ArrayList<String> unaryInclusive) {
		this.unaryInclusive = unaryInclusive;
	}



	/**
	 * @return the unaryExclusive
	 */
	public ArrayList<String> getUnaryExclusive() {
		return unaryExclusive;
	}



	/**
	 * @param unaryExclusive the unaryExclusive to set
	 */
	public void setUnaryExclusive(ArrayList<String> unaryExclusive) {
		this.unaryExclusive = unaryExclusive;
	}



	/**
	 * @return the binaryEquals
	 */
	public ArrayList<String> getBinaryEquals() {
		return binaryEquals;
	}



	/**
	 * @param binaryEquals the binaryEquals to set
	 */
	public void setBinaryEquals(ArrayList<String> binaryEquals) {
		this.binaryEquals = binaryEquals;
	}



	/**
	 * @return the binaryNotEquals
	 */
	public ArrayList<String> getBinaryNotEquals() {
		return binaryNotEquals;
	}



	/**
	 * @param binaryNotEquals the binaryNotEquals to set
	 */
	public void setBinaryNotEquals(ArrayList<String> binaryNotEquals) {
		this.binaryNotEquals = binaryNotEquals;
	}



	/**
	 * @return the mutuallyExclusive
	 */
	public ArrayList<String> getMutuallyExclusive() {
		return mutuallyExclusive;
	}



	/**
	 * @param mutuallyExclusive the mutuallyExclusive to set
	 */
	public void setMutuallyExclusive(ArrayList<String> mutuallyExclusive) {
		this.mutuallyExclusive = mutuallyExclusive;
	}



	/**
	 * @return the assignedVars
	 */
	public HashMap<ItemBag, ArrayList<Item>> getAssignedVars() {
		return assignedVars;
	}



	/**
	 * @param assignedVars the assignedVars to set
	 */
	public void setAssignedVars(HashMap<ItemBag, ArrayList<Item>> assignedVars) {
		this.assignedVars = assignedVars;
	}


	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}


	public void addAssignment(ArrayList<ItemBag> var, ItemBag val) {
		// TODO Auto-generated method stub
		
	}


}
