/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
		
		//read the file
		while ((line = streamReader.readLine()) != null) {
			//denotes new section
			if(line == "#####"){
				//depending on the section number, the data
				//has different relevance 
				switch(section){
				//This is variables
				case 0:
					break;
				//This is bag values
				case 1:
					break;
				//This is fitting limits
				case 2:
					break;
				//This is unary inclusive
				case 3:
					break;
				//This is unary exclusive vars
				case 4:
					break;
				//binary equal vars
				case 5:
					break;
				//This is binary not equals
				case 6:
					break;
				//This is mutually excusive
				case 7:
					break;
				}
			}
		}

	}

}
