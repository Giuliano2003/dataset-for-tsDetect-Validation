package ie.atu.sw;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * BankingApp class serves as a simple orchestrator, delegating functionality
 * to the AccountManager, LoanManager and BankDeposits classes. Since those
 * classes are tested, minimal testing is implemented here to ensure proper 
 * initialization of dependencies
 */

/* https://github.com/sttadic/banking-app-tests/blob/main/src/ie/atu/sw/BankingAppTest.java */

class BankingAppTest {

	@BeforeAll
	public static void setUpBeforeClass() {
		System.out.println("Start unit tests in BankingAppTest suite");
	}
	


	
	@Test
	public void testBankingAppDependencies() {
		BankingApp bankingApp = new BankingApp();
		
		assertNotNull(bankingApp.getAccountManager());
		assertNotNull(bankingApp.getLoanManager());
		assertNotNull(bankingApp.getBankDeposits());
	}
}