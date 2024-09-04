package tasks;

/**
 * Summary:
 * Represents a set of tasks with dependencies between them.
 *
 * Fields:
 * num - (int type): The number of tasks.
 * tasks - (int[][] type): A 2D array representing the dependencies between tasks.
 */
public class Tasks {
	private int num;
	private int[][] tasks;
	
	/**
     * Summary:
     * Constructs a Tasks object with the specified number of tasks.
     * Initializes the dependency matrix.
     *
     * Arguments:
     * @param num - (int type): The number of tasks.
     */
	public Tasks(int num){
		this.num = num;
		tasks = new int[num][num];
	}
	
	 /**
     * Summary:
     * Sets a dependency from task1 to task2.
     *
     * Arguments:
     * @param task1 - (int type): The task that depends on task2.
     * @param task2 - (int type): The task that task1 depends on.
     *
     * Returns:
     * @return - (boolean type): True if the dependency is set successfully, otherwise false.
     */
	public boolean dependsOn(int task1, int task2) {
		if (task1 < 0 || task1 > (this.num-1) || task2 < 0 || task2 > (this.num-1)) {
			return false;
		}
		tasks[task1][task2] = 1; 
		return true;
	}
	
	/**
     * Summary:
     * Determines the order of tasks based on their dependencies.
     *
     * Returns:
     * @return - (int[] type): An array representing the order of tasks, or null if a circular dependency is detected.
     */
	public int[] order(){
		int[] relationsArray = new int[num]; // in the end until last open index and tcop the elements to a new array that has enoguh room up to open index.
		int[] countingArray = new int[num]; // Used to check if the number is already in the ordered list.
		int i,j,k;
		boolean noRelations;
		int openIndex = 0;
		int indexOfNumberToMove = 0;
		
		// Counts all the rows that have no relations at all AKA rows made up of zeros.
		for (i=0;i<num;i++) {
			noRelations = true;
			for (j=0;j<num;j++) {
				if (tasks[i][j] == 1) {
					noRelations = false;
				}
			}
			if (noRelations) {
				relationsArray[openIndex] = i;
				openIndex++;
				countingArray[i] = 1;
			}
		}
		
		// Inserts each relation to the relations array.
		for (i=0;i<num;i++) {
			for (j=0;j<num;j++) {
				if (tasks[i][j] == 1) {
					if (tasks[j][i] == 1) {
						return null;
					}
					else if (countingArray[j] == 1 && countingArray[i] == 1) {
						for (k=0;k<openIndex;k++) {
							if (relationsArray[k] == i) {
								indexOfNumberToMove = k;
							}
						}
						for (k=openIndex;k>indexOfNumberToMove;k--) {
							relationsArray[k] = relationsArray[k-1];
						}
						relationsArray[indexOfNumberToMove] = j;
					}
						
					else if (countingArray[j] == 0){
						relationsArray[openIndex] = j;
						openIndex++;
						noRelations = false;
						countingArray[j] = 1;
					}
				}
			}
			if (countingArray[i] == 0) {
				relationsArray[openIndex] = i;
				openIndex++;
				countingArray[i] = 1;
			}
		}
		return relationsArray;
	}
}
