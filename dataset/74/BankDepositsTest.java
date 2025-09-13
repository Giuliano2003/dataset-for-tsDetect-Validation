package ie.atu.sw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/* https://github.com/sttadic/banking-app-tests/blob/main/src/ie/atu/sw/BankDepositsTest.java*/

class BankDepositsTest {
	private BankDeposits bankDeposits;
	
	
	@BeforeEach
	public void setUp() {
		bankDeposits = new BankDeposits();
		bankDeposits.depositToBank(1000);
	}
	
	
	@Test
	public void testGetTotalDeposits() {
		assertEquals(1000, bankDeposits.getTotalDeposits());
	}
	
	@Test
	public void testDepositToBankSuccess() {
		bankDeposits.depositToBank(1000);
		assertEquals(2000, bankDeposits.getTotalDeposits());
	}
	
	@Test
	public void testDepositToBankInvalidAmount(double depAmount) {
		bankDeposits.depositToBank(depAmount);
		assertEquals(1000, bankDeposits.getTotalDeposits());	// total deposits unchanged
	}

	@Test
	public void testWithdrawFromBankInvalidWithdrawalAmounts(double witAmount) {
		bankDeposits.withdrawFromBank(witAmount);
		assertEquals(1000, bankDeposits.getTotalDeposits());	// total deposits unchanged
	}
	
	@Test
	public void testWithdrawFromBankSuccess() {
		bankDeposits.withdrawFromBank(1000);
		assertEquals(0, bankDeposits.getTotalDeposits());
	}
}