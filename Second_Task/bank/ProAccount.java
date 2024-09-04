package bank;

/**
 * This class represents a professional account, extending the Account class.
 */
public class ProAccount extends Account {
	private int[] history;
	private int lastHistoryChange;
	
	 /**
     * Constructs a new ProAccount object with the specified name.
     * 
     * @param name The name of the account holder
     */
	public ProAccount(String name) {
		super(name);
		lastHistoryChange = 0;
		history = new int[100];
	}
	
	/**
     * Updates the transaction history with the specified amount of money before the transaction.
     * 
     * @param moneyAfterTransaction The amount of money after the transaction
     */
	private void updateHistory(int moneyAfterTransaction) {
		history[lastHistoryChange] = moneyAfterTransaction;
		lastHistoryChange++;
	}
	
	/**
     * Formats and prints the transaction history up to the last index.
     * 
     * @return A formatted string representing the transaction history
     */
	private String printArrayUpToLastIndex(){
		String formattedPrint = "[";
		int i;
		
		for (i=0;i<lastHistoryChange;i++) {
			if (i == lastHistoryChange -1) {
				formattedPrint += history[i] + "]";
			}
			else {
				formattedPrint += history[i] + ",";
			}
		}
		return formattedPrint;
	}
	
	/**
     * Adds the specified amount to the account balance and updates the transaction history.
     * 
     * @param amount The amount to be added
     */
	@Override
	public void add(int amount) {
		if (amount != 0) {
			super.add(amount);
			updateHistory(super.getShekels());
		}
	}
	
	 /**
     * Returns a string representation of the ProAccount object.
     * 
     * @return A string representation of the ProAccount object
     */
	@Override
	public String toString() {
		return (super.getName() + " has " + super.getShekels() + " shekels " + this.printArrayUpToLastIndex());
	}
	
	 /**
     * Transfers the specified amount from one ProAccount to another.
     * 
     * @param from The ProAccount to transfer from
     * @param to The ProAccount to transfer to
     * @param amount The amount to be transferred
     */
	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add((-1) * amount); 
		to.add(amount);
	}
}
