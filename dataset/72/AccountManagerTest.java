
package ie.atu.sw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*https://github.com/sttadic/banking-app-tests/blob/main/src/ie/atu/sw/AccountManagerTest.java */

class AccountManagerTest {
	private static AccountManager accountManager;
	private static BankDeposits bankDeposits;

	
	@BeforeEach
	public void setUp() {
		bankDeposits = new BankDeposits();
		accountManager = new AccountManager(bankDeposits);
		accountManager.addAccount("Alice", 1000);
		accountManager.addAccount("Bob", 500);
	}
	

	
	@Test
	public void testFindAddAccountSuccess() {
		accountManager.addAccount("Tim", 1500);
		assertNotNull(accountManager.findAccount("Tim"));
	}
	
	@Test
	public void testDepositGetBalanceSuccess(double amount) {
		assertTrue(accountManager.deposit("Alice", amount));
		assertEquals(1000 + amount, accountManager.getBalance("Alice"));	
	}

	
	
}
