import java.sql.SQLNonTransientException;
import java.sql.SQLRecoverableException;
import java.sql.SQLSyntaxErrorException;
import java.sql.SQLTransactionRollbackException;
import java.sql.SQLTransientConnectionException;
import java.sql.SQLTransientException;
import java.sql.SQLWarning;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.mock.java.io.MockFile;
import org.evosuite.runtime.mock.java.io.MockFileWriter;
import org.evosuite.runtime.mock.java.net.MockURI;
import org.evosuite.runtime.mock.java.net.MockURL;
import org.junit.runner.RunWith;

public class HttpRequest_ESTest extends HttpRequest_ESTest_scaffolding {
  @Test
  public void test010()  throws Throwable  {
      URL uRL0 = MockURL.getHttpExample();
      HttpRequest httpRequest0 = HttpRequest.head(uRL0);
      int int0 = httpRequest0.intHeader("User-Agent");
      assertTrue(httpRequest0.ignoreCloseExceptions());
      assertEquals(8192, httpRequest0.bufferSize());
      assertEquals((-1), int0);
  }
}