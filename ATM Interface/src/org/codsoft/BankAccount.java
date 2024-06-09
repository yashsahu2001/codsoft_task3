package org.codsoft;

import java.util.ArrayList;
import java.util.Date;

public class BankAccount {
    private double balance;
    private ArrayList<String> transactions;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposit: $" + amount + " on " + new Date());
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawal: $" + amount + " on " + new Date());
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getLast30DaysTransactions() {
        // In a real application, filter the last 30 days transactions
        return transactions;
    }
}
