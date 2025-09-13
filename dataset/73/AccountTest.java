package ie.atu.sw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/* https://github.com/sttadic/banking-app-tests/blob/main/src/ie/atu/sw/Account.java */

class AccountTest {
	private Account account;
	
	
	@BeforeEach
	public void setUp() {
		this.account = new Account("Stjepan", 1000);
	}
	
	
	@Test
	public void testConstructor() {
		assertEquals("Stjepan", account.getAccountHolder());
		assertEquals(1000, account.getBalance());
		assertEquals(0, account.getLoan());
	}
	
	
	@Test
	public void testWithdrawSuccess() {
		assertTrue(account.withdraw(999.99));
	}
	
}