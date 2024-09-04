package tree;

/**
 * Summary:
 * Represents a node in a tree structure where each node contains an array of children nodes and a count.
 *
 * Fields:
 * count - (int type): The count associated with the node.
 * children - (Node[] type): The array of children nodes.
 */
public class Node {
	private int count;
	private Node[] children = new Node['z'-'a'+1];
	private int realIndex;
	
	/**
     * Summary:
     * Returns the count of a string if it exists in the tree.
     *
     * Arguments:
     * @param s - (String type): The string to be searched in the tree.
     *
     * Returns:
     * @return - (int type): The count of the string if it exists, otherwise 0.
     */
	public int num(String s) {
		if (s == "") {
			return this.count;
		}
		
		realIndex = s.charAt(0) - 'a';
		if (s.substring(1) == "" && children[realIndex] == null) { // Checks if we got to the end but the next node is doesn`t exist - if so return 0.
			return 0;
		}
		else if (s.substring(1) != "" && children[realIndex] == null) {
			return 0;
		}
			
		return (children[realIndex].num(s.substring(1)));
	}
	/**
     * Summary:
     * Adds a string to the tree, updating the count as necessary.
     *
     * Arguments:
     * @param s - (String type): The string to be added to the tree.
     */
	public void add(String s) { 
		char currentChar;
		Node currentNode = this;
		int realIndex;
		
		while (s != "") {
			currentChar = s.charAt(0);
			realIndex = currentChar - 'a';
			
			if (s.substring(1) == "" && currentNode.children[realIndex] != null && currentChar >= 'a' && currentChar <= 'z') { // Check if it`s the last letter and the next node already exists, if so just add 1 to the counter of the next node.
				currentNode.children[realIndex].count++;
			}
			else if (s.substring(1) == "" && currentNode.children[realIndex] == null && currentChar >= 'a' && currentChar <= 'z') { // Checking if this is the last letter and if so it creates a new Node class and adds one to the counter.
					currentNode.children[realIndex] = new Node();
					currentNode.children[realIndex].count++;
				}
			else if (currentNode.children[realIndex] == null && currentChar >= 'a' && currentChar <= 'z') { // Creates a new arc in the tree in case the arc did not exist beforehand.
				currentNode.children[realIndex] = new Node();
			}
	
			currentNode = currentNode.children[realIndex];
			s = s.substring(1);
		}
	}
}

