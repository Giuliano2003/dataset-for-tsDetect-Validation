import static org.junit.Assert.*;
import org.junit.*;
/**********************************************************
 * The jUnit test class BankAcount.
 *
 * @author Scott Grissom
 * @version January 12, 2013
 *********************************************************/
public class BankTest{

    private BankAccount account;
    /** allow for round off error */
    private double TOLERANCE = 0.01; 
    /** monthly interest rate */
    private double RATE = 1 + 0.025/12;
    
    public BankTest(){
        // no action necessary in this constructor
    }

    /******************************************************
     * Sets up the test fixture.
     *
     * Called before every test case method.
     *****************************************************/
    @Before
    public void setUp()
    {
        account = new BankAccount("Name",123,500); 
        account.insertCard(123);     
    }

    /******************************************************
     * Test initial values of the constructor
     *****************************************************/
    @Test 
    public void testConstructor()
    {
        int pin = 9999;
        double balance = 200.01;
        BankAccount acct = new BankAccount("Your Name", pin, balance); 
        acct.insertCard(pin);        
        Assert.assertTrue("BankAccount(): PIN not initialized", 
                acct.cardInserted()); 
        acct.removeCard();        
        Assert.assertEquals("BankAccount(): balance not properly initialized", 
                acct.getBalance(), balance, TOLERANCE);                  
    } 

    /******************************************************
     * Test initial values of the default constructor
     *****************************************************/    
    @Test 
    public void testDefaultConstructor()
    {
        BankAccount acct = new BankAccount(); 
        acct.insertCard(9999);        
        Assert.assertTrue("BankAccount(): PIN not initialized to 9999", 
                acct.cardInserted()); 
        acct.removeCard();        
        Assert.assertEquals("BankAccount(): balance not properly initialized", 
                acct.getBalance(), 245.67, TOLERANCE);                  
    } 

    /******************************************************
     * Test customer PIN and card insertion
     *****************************************************/    
    @Test 
    public void testValidation()
    {
        BankAccount acct = new BankAccount("Name",123,500); 
        Assert.assertTrue("BankAccount(): validation should start as false", 
                !acct.cardInserted()); 
        acct.insertCard(12);        
        Assert.assertTrue("Login(): did not properly test the PIN", 
                !acct.cardInserted()); 
        acct.insertCard(123);        
        Assert.assertTrue("Login(): did not properly test the PIN", 
                acct.cardInserted());  
        acct.removeCard();        
        Assert.assertTrue("Logout(): did not properly logout", 
                !acct.cardInserted());                  
    }     
}