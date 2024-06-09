package org.codsoft;

import java.util.ArrayList;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Successfully deposited $" + amount);
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal of $" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }

    public void internetBanking() {
        // Implementation of internet banking options
    }

    public void savePayee(String payee) {
        // Implementation of saving a payee
    }

    public void showLast30DaysTransactions() {
        ArrayList<String> transactions = account.getLast30DaysTransactions();
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void generateTransactionPDF() {
        ArrayList<String> transactions = account.getLast30DaysTransactions();
        PDFGenerator.generatePDF(transactions);
    }
}
