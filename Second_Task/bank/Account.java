package bank;

/**
 * Summary:
 * Represents a bank account with an account holder's name and the amount of money in the account.
 *
 * Fields:
 * name - (String type): The name of the account holder.
 * moneyInAccount - (int type): The amount of money in the account in shekels.
 */
public class Account {
	private String name;
	private int moneyInAccount;
	
	   /**
     * Summary:
     * Constructs an Account object with the specified name and initializes the account balance to 0.
     *
     * Arguments:
     * @param name - (String type): The name of the account holder.
     */
	public Account(String name) {
		this.name = name;
		moneyInAccount = 0;
	}
	
	  /**
     * Summary:
     * Gets the current balance in the account.
     *
     * Returns:
     * @return - (int type): The amount of money in the account in shekels.
     */
	public int getShekels() {
		return moneyInAccount;
	}
	
	 /**
     * Summary:
     * Gets the name of the account holder.
     *
     * Returns:
     * @return - (String type): The name of the account holder.
     */
	public String getName() {
		return name;
	}
	
	 /**
     * Summary:
     * Adds a specified amount of money to the account.
     *
     * Arguments:
     * @param amount - (int type): The amount of money to be added to the account.
     */
	public void add(int amount) {
		moneyInAccount += amount;
	}
	
	  /**
     * Summary:
     * Returns a string representation of the account, including the account holder's name and the current balance.
     *
     * Returns:
     * @return - (String type): A string representation of the account.
     */
	public String toString() {
		return (name + " has " + moneyInAccount + " shekels");
	}
}
