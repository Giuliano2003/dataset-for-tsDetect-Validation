package com.bankingsystem.dao;

import com.bankingsystem.models.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO {
    // List to store BankAccount objects (In-memory storage for simplicity)
    private final List<BankAccount> accounts = new ArrayList<>();

    // Method to save a new bank account into the list
    public BankAccount save(BankAccount account) {
        accounts.add(account); // Add the account to the list
        return account; // Return the saved account
    }

    // Method to retrieve all bank accounts
    public List<BankAccount> findAll() {
        return new ArrayList<>(accounts); // Return a copy of the accounts list
    }

    // Method to retrieve a bank account by its ID
    public BankAccount findById(int accountId) {
        return accounts.stream() // Use stream to filter accounts
                .filter(account -> account.getId() == accountId) // Match by account ID
                .findFirst() // Get the first matching account (or null if not found)
                .orElse(null); // Return null if no account is found
    }

    // Method to delete a bank account by its ID
    public boolean delete(int accountId) {
        return accounts.removeIf(account -> account.getId() == accountId); // Remove and return true if an account is found and deleted
    }
}