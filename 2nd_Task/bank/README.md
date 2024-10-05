# 🏦 Banking Application

## 📜 Overview
This banking application consists of two main classes: `Account` and `ProAccount`. The `Account` class represents a standard bank account with basic functionalities, while the `ProAccount` class extends the `Account` class to include features like transaction history management.

---

## ⚙️ Features
- **Account Management**: Create accounts with a name and manage balances.
- **Deposit Funds**: Add money to an account.
- **Transaction History**: Track balance changes in the `ProAccount` class.
- **Fund Transfer**: Transfer funds between `ProAccount` instances.

---

## 📚 Usage Example
Here’s how to use the `Account` and `ProAccount` classes in your Java application:

```java
import bank.Account;
import bank.ProAccount;

public class Main {
    public static void main(String[] args) {
        // Create a regular account
        Account account = new Account("Alice");
        account.add(100);
        System.out.println(account);

        // Create a professional account
        ProAccount proAccount = new ProAccount("Bob");
        proAccount.add(200);
        System.out.println(proAccount);

        // Transfer money from one ProAccount to another
        ProAccount anotherProAccount = new ProAccount("Charlie");
        ProAccount.transfer(proAccount, anotherProAccount, 50);
        
        System.out.println(proAccount);
        System.out.println(anotherProAccount);
    }
}
```

---

## 📄 Class Documentation

### `Account`
Represents a bank account with an account holder's name and the amount of money in the account.

#### 🔑 Fields
- **`name`** (String): The name of the account holder.
- **`moneyInAccount`** (int): The amount of money in the account in shekels.

#### 🛠️ Methods

- **`Account(String name)`**
  - **Summary**: Constructs an Account object with the specified name and initializes the account balance to 0.
  - **Arguments**:
    - `name` (String): The name of the account holder.

- **`int getShekels()`**
  - **Summary**: Gets the current balance in the account.
  - **Returns**:
    - `int`: The amount of money in the account in shekels.

- **`String getName()`**
  - **Summary**: Gets the name of the account holder.
  - **Returns**:
    - `String`: The name of the account holder.

- **`void add(int amount)`**
  - **Summary**: Adds a specified amount of money to the account.
  - **Arguments**:
    - `amount` (int): The amount of money to be added to the account.

- **`String toString()`**
  - **Summary**: Returns a string representation of the account, including the account holder's name and the current balance.
  - **Returns**:
    - `String`: A string representation of the account.

---

### `ProAccount`
This class represents a professional account, extending the `Account` class.

#### 🔑 Fields
- **`history`** (int[]): An array to keep track of the transaction history.
- **`lastHistoryChange`** (int): An index for the last transaction in the history.

#### 🛠️ Methods

- **`ProAccount(String name)`**
  - **Summary**: Constructs a new ProAccount object with the specified name.
  - **Arguments**:
    - `name` (String): The name of the account holder.

- **`void add(int amount)`**
  - **Summary**: Adds the specified amount to the account balance and updates the transaction history.
  - **Arguments**:
    - `amount` (int): The amount to be added.

- **`String toString()`**
  - **Summary**: Returns a string representation of the ProAccount object.
  - **Returns**:
    - `String`: A string representation of the ProAccount object.

- **`static void transfer(ProAccount from, ProAccount to, int amount)`**
  - **Summary**: Transfers the specified amount from one ProAccount to another.
  - **Arguments**:
    - `from` (ProAccount): The ProAccount to transfer from.
    - `to` (ProAccount): The ProAccount to transfer to.
    - `amount` (int): The amount to be transferred.

---

## 📝 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
