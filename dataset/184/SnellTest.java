import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ATMTest {
    private ATM atm;

    @Before
    public void setUp() {
        atm = new ATM("Downtown", 2000.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testATMInitializationWithNegativeCash() {
        new ATM("Suburban", -100.0);
    }

    @Test
    public void testATMInitializationWithPositiveCash() {
        ATM atm = new ATM("Suburban", 100.0);
        assertEquals(100.0, atm.getCashBalance(), 0.001);
        assertEquals("Suburban", atm.getLocation());
    }

    @Test
    public void testDepositCashSuccessfully() {
        atm.depositCash(500.0);
        assertEquals(2500.0, atm.getCashBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositCashWithNegativeAmount() {
        atm.depositCash(-500.0);
    }

    @Test
    public void testDepositCashSmallAmount() {
        double initialBalance = atm.getCashBalance();
        atm.depositCash(0.01);
        assertEquals(initialBalance + 0.01, atm.getCashBalance(), 0.001);
    }

    @Test
    public void testDepositCashLargeAmount() {
        atm.depositCash(10000.0);
        assertEquals(12000.0, atm.getCashBalance(), 0.001);
    }

    @Test
    public void testConsecutiveDeposits() {
        atm.depositCash(100.0);
        atm.depositCash(200.0);
        assertEquals(2300.0, atm.getCashBalance(), 0.001);
    }

    @Test
    public void testWithdrawCashSuccessfully() {
        atm.withdrawCash(1500.0);
        assertEquals(500.0, atm.getCashBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawCashWithNegativeAmount() {
        atm.withdrawCash(-500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawCashWithZeroAmount() {
        atm.withdrawCash(0);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithdrawCashMoreThanBalance() {
        atm.withdrawCash(2500.0);
    }

    @Test
    public void testWithdrawCashSmallAmount() {
        double initialBalance = atm.getCashBalance();
        atm.withdrawCash(1.0);
        assertEquals(initialBalance - 1.0, atm.getCashBalance(), 0.001);
    }

    @Test
    public void testWithdrawJustBelowBalance() {
        atm.withdrawCash(1999.99);
        assertEquals(0.01, atm.getCashBalance(), 0.001);
    }

    @Test
    public void testConsecutiveWithdrawals() {
        atm.withdrawCash(500.0);
        atm.withdrawCash(300.0);
        assertEquals(1200.0, atm.getCashBalance(), 0.001);
    }

    @Test
    public void testGetLocation() {
        assertEquals("Downtown", atm.getLocation());
    }

    @Test
    public void testIsLowOnCashTrue() {
        ATM lowCashATM = new ATM("Rural", 500.0);
        assertTrue(lowCashATM.isLowOnCash());
    }

    @Test
    public void testIsLowOnCashFalse() {
        assertFalse(atm.isLowOnCash());
    }

    @Test
    public void testJustAboveLowCashThreshold() {
        ATM justAboveATM = new ATM("Just Above", 1000.01);
        assertFalse(justAboveATM.isLowOnCash());
    }

    @Test
    public void testAfterTransactionsChangeCashStatus() {
        atm.depositCash(1000.0);
        assertFalse(atm.isLowOnCash());
        atm.withdrawCash(2500.0);
        assertTrue(atm.isLowOnCash());
    }
}