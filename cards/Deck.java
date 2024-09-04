package cards;

/**
 * Summary:
 * Represents a deck of cards. The deck can be initialized, manipulated, and displayed through various methods.
 *
 * Fields:
 * num - (int type): The number of cards currently in the deck.
 * arr - (Card array type): An array holding the cards in the deck.
 */
public class Deck {
	private int num;
	private Card[] arr;

	
	 /**
	 * Summary:
	 * Constructs a deck with the specified number of different cards.
	 * Each card is replicated for each suit.
	 *
	 * Arguments:
	 * @param num - (int type): Represents the different numbers in the deck each number has 4 different suits.
	 *
	 * Variables:
	 * number - (int type): Used for card number iteration.
	 * suit - (int type): Used for suit iteration.
	 * indexToInsertNewCard - (int type): Index for inserting a new card into the array.
	 * currCard - (Card type): Holds the current card being created.
	 *
	 * Creates:
	 * An array of cards with the specified number of values and suits.
	 */
	public Deck(int num) {
		int number,suit;
		int indexToInsertNewCard = 0;
		Card currCard;
		arr = new Card[num*4];
		
		this.num = num*4; // calculates all of the cards multiplied by all of the suits.
		
		// creating the array that contains all the optional cards available for this deck
		for (number=0;number<num;number++) {
			for (suit=0;suit<4;suit++) {
				currCard =  new Card(number, suit);
				arr[indexToInsertNewCard] = currCard;
				indexToInsertNewCard += 1;
			}
		}
	}
	
	 /**
	 * Summary:
	 * Constructs a new deck by copying a specified number of cards from another deck.
	 *
	 * Arguments:
	 * @param from - (Deck type): The deck to copy cards from.
	 * @param num - (int type): The number of cards to copy from the 'from' deck.
	 *
	 * Variables:
	 * arr - (Card array type): Array holding the cards in the new deck.
	 * cardToTransfer - (Card type): Holds the card being transferred from the 'from' deck.
	 * IndexForInsertingNewCard - (int type): Index for inserting a new card into the array.
	 * countCardsInNewDeck - (int type): Counts the number of cards successfully copied to the new deck.
	 *
	 * Creates:
	 * A new deck with the specified number of cards copied from the 'from' deck.
	 * If the 'from' deck does not have enough cards, the new deck will contain as many cards as possible.
	 */
	public Deck(Deck from, int num) {
		arr = new Card[num];
		Card cardToTransfer;
		int IndexForInsertingNewCard;
		int countCardsInNewDeck = 0;
		
		for (IndexForInsertingNewCard = 0; IndexForInsertingNewCard<num;IndexForInsertingNewCard++) {
			cardToTransfer = from.takeOne();
			if (cardToTransfer != null) {
				arr[IndexForInsertingNewCard] = cardToTransfer;
				countCardsInNewDeck++;
			}
		}
		this.num = countCardsInNewDeck;
	}
	
	 /**
	 * Summary:
	 * Constructs a new deck by merging two given decks. Cards are alternately taken from each deck until both are empty.
	 *
	 * Arguments:
	 * @param first - (Deck type): The first deck to merge.
	 * @param second - (Deck type): The second deck to merge.
	 *
	 * Variables:
	 * newCardIndex - (int type): Index for inserting a new card into the array.
	 * amountOfCardsFirstDeck - (int type): Number of cards in the first deck.
	 * amountOfCardsSecondDeck - (int type): Number of cards in the second deck.
	 * amountOfCardsInLargerDeck - (int type): The number of cards in the larger of the two decks.
	 * i - (int type): Iteration variable.
	 * newCard - (Card type): Holds the current card being taken from either deck.
	 * amountOfCardsInNewDeck - (int type): Counts the number of cards successfully added to the new deck.
	 *
	 * Creates:
	 * A new deck containing cards  taken from the first and second decks. The new deck's size is the sum of both input decks' sizes.
	 */
	public Deck(Deck first, Deck second) {
		int newCardIndex = 0;
		int amountOfCardsFirstDeck = first.num;
		int amountOfCardsSecondDeck = second.num;
		int amountOfCardsInLargerDeck;
		int i;
		Card newCard;
		int amountOfCardsInNewDeck = 0;
		
		if (amountOfCardsFirstDeck > amountOfCardsSecondDeck) {
			amountOfCardsInLargerDeck = amountOfCardsFirstDeck;
		}
		else {
			amountOfCardsInLargerDeck = amountOfCardsSecondDeck;
		}
		
		this.arr = new Card[amountOfCardsFirstDeck + amountOfCardsSecondDeck]; 
		
		for (i=0;i<amountOfCardsInLargerDeck;i++) {
			newCard = first.takeOne();
			if (newCard != null) {
				arr[newCardIndex] = newCard;
				newCardIndex++;
			}
			newCard = second.takeOne();
			if (newCard != null) {
				arr[newCardIndex] = newCard;
				newCardIndex++;
			}
		}
		
		for (i=0;i<arr.length;i++) {
			if (arr[i] != null) {
				amountOfCardsInNewDeck++;
			}
		}
		this.num = amountOfCardsInNewDeck;
	}
	
	 /**
	 * Summary:
	 * Returns the number of cards currently in the deck.
	 *
	 * Returns:
	 * @return - (int type): The number of cards in the deck.
	 */
	public int getNumCards() { 
		return num;
	}
	
	/**
	 * Summary:
	 * This method removes and returns one card from the deck.
	 *
	 * Variables:
	 * i - (int type): Used for iterating through the deck from the last card to the first.
	 * returnCard - (Card type): Stores the card to be returned.
	 *
	 * Returns:
	 * @return - (Card type): The first non-null card found from the end of the deck, or null if the deck is empty.
	 */
	public Card takeOne() {
		int i; 
		Card returnCard;
		
		for (i = num-1;i>=0;i--) {
			if (arr[i] != null) { 
				returnCard = arr[i];
				arr[i] = null;
				this.num = this.num - 1; // updates that now the deck has one less card
				return returnCard;
			}
		}
		return null; // In case the deck is empty.
	}
	
	 /**
	 * Summary:
	 * Returns a string representation of the deck.
	 *
	 * Variables:
	 * i - (int type): Used for iteration over the deck's cards.
	 * str - (String type): Builds the string representation of the deck.
	 *
	 * Returns:
	 * @return - (String type): A string representation of the deck in the format "[Card1, Card2, ..., CardN]".
	 *           Each card's string representation is obtained by calling its `toString` method.
	 */
	public String toString() {
		int i;
		
		String str = new String("[");
		for (i = 0 ;i<num;i++) {
			if (i == num-1) {
				str += arr[i].toString() + "]";
			}
			else {
				str += arr[i].toString() + ", ";
			}
		}
		return str;
	}
	
	 /**
	 * Summary:
	 * Sorts the cards in the deck by their natural order. The sorting is performed using a simple comparison-based sorting algorithm.
	 *
	 * Variables:
	 * i - (int type): Used for iteration over the deck's cards.
	 * j - (int type): Used for the inner loop to compare and sort cards.
	 * temp - (Card type): Temporary variable used for swapping cards.
	 */
	public void sort() {
		int i,j;
		Card temp;
		
		for (i=0;i<num;i++) {
			for (j=i;j<num;j++) {
				if (arr[i].compareTo(arr[j]) == 1) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
