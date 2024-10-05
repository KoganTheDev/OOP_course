# 🌳 Tree Structure & Reversed Words Checker

![Java](https://img.shields.io/badge/Language-Java-brightgreen) ![License](https://img.shields.io/badge/License-MIT-blue)

## 📖 Overview

The **Tree Structure & Reversed Words Checker** project provides a robust implementation of a tree data structure that can efficiently manage strings and check for reversed words in user input. It allows for the addition of strings to a tree, counting occurrences, and identifying reversed strings or palindromes.

## ✨ Features

- **Tree Implementation**: Represent strings as nodes in a tree structure.
- **String Addition**: Add strings to the tree and keep track of their counts.
- **Reversed Words Check**: Input strings can be checked against their reversed versions.
- **Palindrome Detection**: Identify palindromic strings and count their occurrences.

## ⚙️ Usage

You can utilize the classes to manage strings and check for reversed words as shown below:

### Example of Adding Strings to the Tree and Checking Reversed Words

```java
public class Main {
    public static void main(String[] args) {
        // Check for reversed words from user input
        int count = ReversedWords.checkReversed();
        System.out.println("Number of reversed words found: " + count);
    }
}
```

### Input Example

You can input strings until you type `X` to stop:
```
hello
olleh
world
dlrow
X
```

### Output

```
Number of reversed words found: 2
```

## 📦 Classes

### 🏷️ Node Class

#### Summary

Represents a node in a tree structure where each node contains an array of children nodes and a count.

#### Fields

- **`count`** - *(int)*: The count associated with the node.
- **`children`** - *(Node[])*: The array of children nodes.

#### Methods

- **`int num(String s)`**: Returns the count of a string if it exists in the tree.
- **`void add(String s)`**: Adds a string to the tree, updating the count as necessary.

### 🏷️ ReversedWords Class

#### Summary

Contains methods to check for reversed words in user input.

#### Methods

- **`static int checkReversed()`**: Reads strings from user input, checks for their reversed versions in the tree, and counts the number of reversed strings found.

## 📝 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
