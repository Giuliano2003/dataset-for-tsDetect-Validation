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
  public void testDispatcher() throws Exception {
    // Given
    final String expected = "100051001";
    final String uri = "/post";
    final HttpUrl baseUrl = server.url(uri);
    dispatcher = new Dispatcher() {

      @Override
      public MockResponse dispatch(RecordedRequest request) throws InterruptedException {

          if (request.getPath().equals("/post") && request.getMethod().equals("POST")){
              return new MockResponse().setBody(expected);
          } 
          return new MockResponse().setResponseCode(404);
      }
  };
  server.setDispatcher(dispatcher);
  PostExample postExample = new PostExample();

    // When
    String actual = baseUrl.toString();
    
    //Then
    assertThat(actual, equalTo(expected));
  }
  
}