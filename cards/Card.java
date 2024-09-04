package cards;

/**
 * Summary:
 * Represents a single playing card with a number and a suit.
 *
 * Fields:
 * num - (int type): The number or rank of the card.
 * suit - (int type): The suit of the card.
 */
public class Card {
	private int num, suit;
	
	 /**
	 * Summary:
	 * Constructs a card with a specified number and suit.
	 *
	 * Arguments:
	 * @param num - (int type): The number of the card.
	 * @param suit - (int type): The suit of the card.
	 *
	 * Variables:
	 * this.num - (int type): The number of the card being constructed.
	 * this.suit - (int type): The suit of the card being constructed.
	 */
	public Card(int num,int suit) {
		this.num = num;
		this.suit = suit;
	}
	
	 /**
	 * Summary:
	 * Returns the number of the card.
	 *
	 * Returns:
	 * @return - (int type): The number of the card.
	 */
	public int getNum() {
		return num;
	}
	
	 /**
	 * Summary:
	 * Returns the suit of the card.
	 *
	 * Returns:
	 * @return - (int type): The suit of the card as an integer.
	 */
	public int getSuit() {
		return suit;
	}
	
	/**
	 * Summary:
	 * Converts the card into its string representation.
	 *
	 * Variables:
	 * suitAsNumber - (char type): Represents the suit of the card as a character.
	 *
	 * Returns:
	 * @return - (String type): The string representation of the card, consisting of its number followed by its suit.
	 */
	public String toString() {
		char suitAsNumber;
		
		if (suit == 0) {
			suitAsNumber = 'C';
		}
		else if (suit == 1) {
			suitAsNumber = 'D';
		}
		else if (suit == 2) {
			suitAsNumber = 'H';
		}
		else {
			suitAsNumber = 'S';
		}
		return("" + num + suitAsNumber); //Used empty quotes so the elements will concatenate as a string.
	}
	
	/**
	 * Summary:
	 * Compares this card with another card based on their number and suit.
	 *
	 * Arguments:
	 * @param other - (Card type): The card to compare with.
	 *
	 * Returns:
	 * @return - (int type): 0 if the cards are equal, 1 if this card is greater than the other card, -1 if this card is less than the other card.
	 */
	public int compareTo(Card other) {
		if (this.getNum() == other.getNum() && this.getSuit() == other.getSuit()) {
			return 0;
		}
		else if (this.getNum() > other.getNum() || (this.getNum() == other.getNum() && this.getSuit() > other.getSuit())) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
