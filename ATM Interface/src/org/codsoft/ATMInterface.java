package org.codsoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface {
    private JFrame frame;
    private BankAccount account;
    private ATM atm;

    public ATMInterface() {
        account = new BankAccount(1000); // initial balance
        atm = new ATM(account);

        frame = new JFrame("ATM Machine");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(50, 50, 150, 30);
        frame.add(btnDeposit);
        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                if (amountStr != null) {
                    try {
                        double amount = Double.parseDouble(amountStr);
                        atm.deposit(amount);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid amount entered.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(200, 50, 150, 30);
        frame.add(btnWithdraw);
        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                if (amountStr != null) {
                    try {
                        double amount = Double.parseDouble(amountStr);
                        atm.withdraw(amount);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid amount entered.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JButton btnCheckBalance = new JButton("Check Balance");
        btnCheckBalance.setBounds(50, 100, 150, 30);
        frame.add(btnCheckBalance);
        btnCheckBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atm.checkBalance();
            }
        });

        JButton btnLastTransactions = new JButton("Last 30 Days Transactions");
        btnLastTransactions.setBounds(200, 100, 150, 30);
        frame.add(btnLastTransactions);
        btnLastTransactions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atm.showLast30DaysTransactions();
            }
        });

        JButton btnDownloadPDF = new JButton("Download Transactions PDF");
        btnDownloadPDF.setBounds(50, 150, 300, 30);
        frame.add(btnDownloadPDF);
        btnDownloadPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atm.generateTransactionPDF();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ATMInterface();
    }
}

