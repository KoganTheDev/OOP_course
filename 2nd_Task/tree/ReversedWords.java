package tree;

import java.util.Scanner;

/**
 * This class contains a method to check for reversed words in user input.
 */
public class ReversedWords {
	
	/**
     * This method reads strings from user input, checks for their reversed versions in a tree,
     * and counts the number of reversed strings found.
     * 
     * @return The number of reversed strings found in the input
     */
	public static int checkReversed() {
		Node root = new Node();
		String newString;
		boolean foundX = false; 
		boolean isPalindrome = false;
		Scanner userInput = new Scanner(System.in);
		int amountOfReversedStrings = 0;
		String reversedString = ""; 
		int i;
		
		while (userInput.hasNext() && !foundX) {
			newString = userInput.next();
			if (newString.charAt(0) == 'X') {
				foundX = true;
			}
			else {
				root.add(newString); 
				for (i = newString.length() - 1;i>=0;i--) { // This loop is used to create the reversed string.
					reversedString += newString.charAt(i);
				}
				
				if (newString.equals(reversedString)){
					isPalindrome = true;
				}
				
				/**
				 *  In case the function finds a palindrome it will count it as it was already found.
				 *  though here we have a special case, even if it counts itself to be counted it has to occur
				 *  at least one more time, therefore it has to equal or be bigger than 2.
				 */
				if (isPalindrome) {
					if (root.num(reversedString) >= 2) {
						amountOfReversedStrings++;
					}
				}
				
				// check if reverse word is in the tree.
				if (!isPalindrome) {
					if (root.num(reversedString) >= 1) { // returns at least 1 if the reversed string exists. 
						amountOfReversedStrings++;
					}
				}
				
				newString = ""; // Reset the string the user gives on each iteration.
				reversedString = ""; // Reset the reversed string so it will be able to contain a new reversed word.
				isPalindrome = false; // Reset isPalindrome for the next iteration.
			}	
		}
		
		userInput.close();
		return amountOfReversedStrings;
	}
	
}
