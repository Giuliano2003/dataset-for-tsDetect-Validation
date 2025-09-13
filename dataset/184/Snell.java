/**
 * Represents ATM that can handle cash deposits, withdrawals, and provide information about its current cash balance and location.
 *
 */
public class ATM {

    /**
     * Holds the location of ATM.
     */
    private String location;

    /**
     * Holds the cash balance in ATM.
     */
    private double cash;

    /**
     * Constructs an ATM with a specified location and initial cash balance.
     *
     * @param location    The physical location of the ATM.
     * @param initialCash The initial amount of cash the ATM contains.
     * @throws IllegalArgumentException if the initial cash balance is negative.
     */
    public ATM(String location, double initialCash) {
        if (initialCash < 0) {
            throw new IllegalArgumentException("Initial cash cannot be negative.");
        }
        this.location = location;
        this.cash = initialCash;
    }

    /**
     * Deposits a specified amount of cash into the ATM.
     *
     * @param amount The amount to deposit.
     * @throws IllegalArgumentException if the deposit amount is negative.
     */
    public void depositCash(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        cash += amount;
    }

    /**
     * Withdraws a specified amount of cash from the ATM.
     *
     * @param amount The amount to withdraw.
     * @throws IllegalArgumentException if the withdrawal amount is less than or
     *                                  equal to zero.
     * @throws IllegalStateException    if the ATM does not have sufficient cash for
     *                                  the withdrawal.
     */
    public void withdrawCash(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > cash) {
            throw new IllegalStateException("ATM does not have sufficient cash.");
        }
        cash -= amount;
    }

    /**
     * Returns the current cash balance in the ATM.
     *
     * @return The current cash balance.
     */
    public double getCashBalance() {
        return cash;
    }

    /**
     * Returns the location of the ATM.
     *
     * @return The physical location of the ATM.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Checks if the ATM is low on cash.
     *
     * @return true if the ATM's cash balance is less than 1000; false otherwise.
     */
    public boolean isLowOnCash() {
        return cash < 1000;
    }

    /**
     * Prints the current cash balance of the ATM to the console.
     */
    public void checkBalance() {
        System.out.println("The current cash balance is: " + getCashBalance());
    }
}