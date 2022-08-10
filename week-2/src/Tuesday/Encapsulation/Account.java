package Tuesday.Encapsulation;

import java.util.Arrays;

public class Account {
    private int accountId;
    private int balance;
    private String owner;
    private String type;

    // keep track of transactions
    private int [] transactions;

    public Account() {

    }

    public Account(int accountId, int balance, String owner, String type) {
        // constructor can definitely access these fields because it's part of the class
        this.accountId = accountId;
        this.balance = balance;
        this.owner = owner;
        this.type = type;
    }

    // use public getter to access the private variables:
    public int getAccountId() {
        // because this method is in the same class as the field, we can still access it here
        return this.accountId;
    }

    // public setter that takes in a value and updates the private field
    public void setAccountId(int accountId) {
        // because we are in the class, we can update the private field directly:
        this.accountId = accountId;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        // perform some logic to make sure our account stays "valid"
        if(balance > 1000) {
            System.out.println("Too much money, please upgrade you account.");
            // leave the method
            return;
        }
        if(balance > 0) {
            this.balance = balance;
        }
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int[] getTransactions() {
        return this.transactions;
    }
    public void setTransactions(int[] transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", owner='" + owner + '\'' +
                ", type='" + type + '\'' +
                ", transactions=" + Arrays.toString(transactions) +
                '}';
    }
}
