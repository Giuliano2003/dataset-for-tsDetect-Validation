package com.bankingsystem.dao;

import com.bankingsystem.models.BankAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BankAccountDAOTest {
    // Declare an instance of the BankAccountDAO to be tested
    private BankAccountDAO bankAccountDAO;

    // Set up the test environment before each test is executed
    @Before
    public void setUp() {
        // Initialize the DAO object before each test
        bankAccountDAO = new BankAccountDAO();
    }


    // Test case to verify that a BankAccount can be deleted correctly
    @Test
    public void testDelete() {
        // Save a BankAccount object
        bankAccountDAO.save(new BankAccount(1, "John Doe", 1000.0));

        // Delete the account by its ID
        boolean result = bankAccountDAO.delete(1);

        // Assert that the deletion was successful
        assertTrue(result);

        // Assert that the account no longer exists
        assertNull(bankAccountDAO.findById(1));
    }
}