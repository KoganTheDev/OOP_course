package tasks;

/**
 * Summary:
 * Represents a set of named tasks with dependencies between them.
 * Extends the Tasks class to work with task names.
 *
 * Fields:
 * tasksByWord - (String[] type): An array of task names.
 */
public class NamedTasks extends Tasks {
	private String[] tasksByWord;
	
	 /**
     * Summary:
     * Constructs a NamedTasks object with the specified task names.
     * Initializes the dependency matrix based on the number of tasks.
     *
     * Arguments:
     * @param names - (String[] type): An array of task names.
     */
	public NamedTasks(String[] names) {
		super(names.length); 
		tasksByWord = names;
	}
	
	 /**
     * Summary:
     * Sets a dependency from task1 to task2 using task names.
     *
     * Arguments:
     * @param task1 - (String type): The name of the task that depends on task2.
     * @param task2 - (String type): The name of the task that task1 depends on.
     *
     * Returns:
     * @return - (boolean type): True if the dependency is set successfully, otherwise false.
     */
	public boolean dependsOn(String task1, String task2) {
		int indexTask1 = -1, indexTask2 = -1;
		int i;
		
		for (i=0;i<tasksByWord.length;i++) { // find the indices of the strings task1 and task2.
			if (tasksByWord[i] == task1) {
				indexTask1 = i;
			}
			else if(tasksByWord[i] == task2) {
				indexTask2 = i;
			}
		}
		return dependsOn(indexTask1, indexTask2);
	}
	
	 /**
     * Summary:
     * Determines the order of tasks based on their dependencies and returns the task names in order.
     *
     * Returns:
     * @return - (String[] type): An array of task names in order, or null if a circular dependency is detected.
     */
	public String[] nameOrder() {
		int[] sortedTaskByNumbers = super.order();
		int i;
		String[] sortedTaskByStrings = new String[this.tasksByWord.length];
		
		// Make and sort the Task array by name
		for (i=0;i<sortedTaskByNumbers.length;i++) {
			sortedTaskByStrings[i] = tasksByWord[sortedTaskByNumbers[i]]; 
		}
		
		return sortedTaskByStrings;
	}
	
}
