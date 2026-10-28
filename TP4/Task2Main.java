package TP4;


// --- 1. TRANSACTION CLASS ---
class Transaction {
    String type; // "DEPOSIT" or "WITHDRAW"
    double amount;
    double balanceAfter;

    public Transaction(String type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public String toLine() {
        return String.format("[%s] Amount: $%.2f | Balance After: $%.2f", type, amount, balanceAfter);
    }
}

// --- 2. TRANSACTION LOG CLASS ---
class TransactionLog {
    Transaction[] entries; // Bounded array
    int size;
    int capacity;

    public TransactionLog(int capacity) {
        this.capacity = capacity;
        this.entries = new Transaction[capacity];
        this.size = 0;
    }

    // Policy: Ignore new transactions when the log array is full
    public boolean add(Transaction t) {
        if (size >= capacity) {
            System.out.println("Log is full! Cannot record transaction.");
            return false;
        }
        entries[size] = t;
        size++;
        return true;
    }

    public Transaction get(int i) {
        if (i >= 0 && i < size) {
            return entries[i];
        }
        return null;
    }

    public int count() {
        return size;
    }
}

// --- 3. BANK ACCOUNT CLASS ---
class BankAccount {
    String owner;
    double balance;
    TransactionLog log; // Composition association

    public BankAccount(String owner, double initialBalance, int capacity) {
        this.owner = owner;
        this.balance = initialBalance;
        this.log = new TransactionLog(capacity);
    }

    public boolean deposit(double amount) {
        if (amount <= 0) { // Guard clause
            System.out.println("Deposit failed: Amount must be positive.");
            return false;
        }
        this.balance += amount;
        Transaction t = new Transaction("DEPOSIT", amount, this.balance);
        log.add(t);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) { // Guard clause
            System.out.println("Withdrawal failed: Invalid amount or insufficient funds.");
            return false;
        }
        this.balance -= amount;
        Transaction t = new Transaction("WITHDRAW", amount, this.balance);
        log.add(t);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public void printStatement() {
        System.out.println("==========================================");
        System.out.println("ACCOUNT STATEMENT - OWNER: " + owner);
        System.out.println("==========================================");
        for (int i = 0; i < log.count(); i++) {
            System.out.println(log.get(i).toLine());
        }
        System.out.println("------------------------------------------");
        System.out.printf("FINAL BALANCE: $%.2f\n", balance);
        System.out.println("==========================================");
    }
}

// --- 4. PUBLIC MAIN CLASS (Matches file name Task2Main.java) ---
public class Task2Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Amine", 500.0, 50);

        // 10 test operations
        account.deposit(200.0);
        account.withdraw(50.0);
        account.deposit(100.0);
        account.withdraw(300.0);
        account.deposit(40.0);
        account.withdraw(20.0);
        account.withdraw(10.0);
        account.deposit(150.0);
        account.withdraw(500.0); // Fails guard clause (insufficient funds)
        account.deposit(80.0);

        // Print statement with all transactions
        account.printStatement();
    }
}