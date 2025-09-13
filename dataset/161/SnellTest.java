package testokhttp;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class Test {
  MockWebServer server;
  Dispatcher dispatcher;
  @Before
  public void setUp() throws IOException {
    server = new MockWebServer();
    server.start();
  }
  
  @After
  public void tearDown() throws IOException {
    server.shutdown();
  }
  
  @Test
  public void testGetExample() throws Exception {
    // Given
    final String expected = "hello, world!";
    final String uri = "/square/okhttp/master/README.md";
    HttpUrl baseUrl = server.url(uri );
    server.enqueue(new MockResponse().setBody(expected));
    GetExample getExample = new GetExample();

    // When
    String actual = baseUrl.toString();
    
    //Then
    assertThat(actual, equalTo(expected));
  }

  
}