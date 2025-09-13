package ie.atu.sw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

class LoanManagerTest {
	private LoanManager loanManager;
	private BankDeposits bankDeposits;
	private AccountManager accountManager;
	private Account alice;
	private Account bill;
	
	
	@BeforeEach
	public void setUp() {
		bankDeposits = new BankDeposits();
		accountManager = new AccountManager(bankDeposits);
		accountManager.addAccount("Alice", 1000);
		accountManager.addAccount("Bill", 500);
		loanManager = new LoanManager(bankDeposits);
		alice = accountManager.findAccount("Alice");
		bill = accountManager.findAccount("Bill");
	}

	
	
	@Test
	public void testRepayLoanInvalidRepayAmount(double repayAmount) {
		loanManager.approveLoan(bill, 500);
		assertFalse(loanManager.repayLoan(bill, repayAmount));
	}
	
	@Test
	public void testRepayLoanAmountLargerThanLoan() {
		loanManager.approveLoan(alice, 500);
		assertFalse(loanManager.repayLoan(alice, 500.01));
	}
	
	@Test
	public void testRepayLoanSuccess() {
		loanManager.approveLoan(alice, 500);
		assertTrue(loanManager.repayLoan(alice, 500));
	}
}