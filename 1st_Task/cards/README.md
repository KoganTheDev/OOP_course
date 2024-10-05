# 🎴 Playing Card Class

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=java&logoColor=white) ![License](https://img.shields.io/badge/license-MIT-brightgreen) ![Version](https://img.shields.io/badge/version-1.0-blue)

## 📖 Overview

The **Playing Card Class** represents a single playing card, encapsulating its rank (number) and suit. This class can be used in various card games and applications that require card manipulation and comparisons.

## 🚀 Features

- Represents a card with a number and a suit.
- Provides methods to retrieve the card's number and suit.
- Converts the card to its string representation.
- Compares two cards based on their number and suit.

## 📚 Table of Contents

1. [Usage Example](#usage-example)
2. [Future Enhancements](#future-enhancements)
3. [License](#license)
4. [Author](#author)

## 💡 Usage Example

Here’s how you can use the `Card` class in your Java application:

```java
import cards.Card;

public class Main {
    public static void main(String[] args) {
        Card card1 = new Card(5, 0); // 5 of Clubs
        Card card2 = new Card(3, 1); // 3 of Diamonds
        
        System.out.println("Card 1: " + card1.toString()); // Output: Card 1: 5C
        System.out.println("Card 2: " + card2.toString()); // Output: Card 2: 3D

        int comparison = card1.compareTo(card2);
        if (comparison > 0) {
            System.out.println("Card 1 is greater than Card 2.");
        } else if (comparison < 0) {
            System.out.println("Card 1 is less than Card 2.");
        } else {
            System.out.println("Card 1 is equal to Card 2.");
        }
    }
}
```

## 📜 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
