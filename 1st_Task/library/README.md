# 📚 Library Management System

## 📜 Overview
This project represents a simple library management system with a collection of books. It includes classes for **Book**, **Author**, and **Library**, providing methods for managing books and authors.

---

## 🏗️ Class Diagram

```plaintext
+-------------------------------+
|            Library            |
+-------------------------------+
| - arr: Book[]                 |
+-------------------------------+
| + Library(int)                |
| + setBook(int, String, Author)|
| + getBook(int): Book          |
+-------------------------------+
               |
               |
+-------------------------------+
|            Book               |
+-------------------------------+
| - title: String               |
| - auth: Author                |
+-------------------------------+
| + Book(String, Author)        |
| + getTitle(): String          |
| + getAuthorName(): String     |
| + getAuthorBirthYear(): int   |
| + toString(): String          |
+-------------------------------+
               |
               |
+-------------------------------+
|            Author             |
+-------------------------------+
| - name: String                |
| - birthYear: int              |
+-------------------------------+
| + Author(String, int)         |
| + getName(): String           |
| + getBirthYear(): int         | 
| + getAge(int): int            |
| + toString(): String          |
+-------------------------------+
```

---

## 📚 Classes

### 1. **Library**

#### ✏️ Summary
Represents a library with a collection of books.

#### 🔑 Fields
- **`arr`** (Book[]): An array to store the books in the library.

#### 🛠️ Methods
- **`Library(int size)`**  
  Constructs a Library object with the specified size.

- **`void setBook(int bookNum, String title, Author auth)`**  
  Adds a new book to the library at the specified index.

- **`Book getBook(int bookNum)`**  
  Retrieves the book at the specified index from the library.

#### 💡 Example
```java
Library library = new Library(10);
Author author = new Author("J.K. Rowling", 1965);
library.setBook(0, "Harry Potter and the Sorcerer's Stone", author);
```
---

### 2. **Book**

#### ✏️ Summary
Represents a book with a title and an author.

#### 🔑 Fields
- **`title`** (String): The title of the book.
- **`auth`** (Author): The author of the book.

#### 🛠️ Methods
- **`Book(String title, Author auth)`**  
  Constructs a Book object with the specified title and author.

- **`String getTitle()`**  
  Returns the title of the book.

- **`String getAuthorName()`**  
  Returns the name of the author of the book.

- **`int getAuthorBirthYear()`**  
  Returns the birth year of the author of the book.

- **`String toString()`**  
  Returns a string representation of the book.

#### 💡 Example
```java
Book book = new Book("Harry Potter and the Sorcerer's Stone", author);
System.out.println(book.toString());
```

---

### 3. **Author**

#### ✏️ Summary
Represents an author with a name and birth year.

#### 🔑 Fields
- **`name`** (String): The name of the author.
- **`birthYear`** (int): The birth year of the author.

#### 🛠️ Methods
- **`Author(String name, int birthYear)`**  
  Constructs an Author object with the specified name and birth year.

- **`String getName()`**  
  Returns the name of the author.

- **`int getBirthYear()`**  
  Returns the birth year of the author.

- **`int getAge(int thisYear)`**  
  Calculates the age of the author based on the specified current year.

- **`String toString()`**  
  Returns a string representation of the author.

#### 💡 Example
```java
Author author = new Author("J.K. Rowling", 1965);
System.out.println(author.getName() + " was born in " + author.getBirthYear());
```

---

## 📊 Conclusion
This library management system allows users to manage a collection of books and authors efficiently. Each class is designed with encapsulation and provides methods for interaction with book and author data.

---

## 📝 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
