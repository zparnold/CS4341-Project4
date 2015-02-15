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
		ArrayList<String> variables = new ArrayList<String>();
		ArrayList<String> bagVals = new ArrayList<String>();
		ArrayList<String> fittingLimits = new ArrayList<String>();
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
				
				switch (section) {
				// This is variables
				case 1:
					
					variables.add(line);
					// TODO Decide what to do here
					break;
				// This is bag values
				case 2:
					bagVals.add(line);
					break;
				// This is fitting limits
				case 3:
					fittingLimits.add(line);
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
		streamReader.close();
	}

}
