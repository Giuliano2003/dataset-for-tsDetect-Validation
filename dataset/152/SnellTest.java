import java.util.Base64;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestPropertySource(properties = {
    "security.user.name = testuser",
    "security.user.password = testpassword",
    "spring.security.user.name = testuser",
    "spring.security.user.password = testpassword",})
public class AuthlistenerApplicationTests {

    @Rule
    public OutputCapture output = new OutputCapture();

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void logsSuccess() throws Exception {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString("testuser:testpassword".getBytes()));
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        final ResponseEntity<String> r = restTemplate
                .exchange("/", HttpMethod.GET, new HttpEntity<>(headers), String.class);
        assertThat(r.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(r.getBody(), is(equalTo("Hello, testuser.")));
        assertThat("Output did not contain 'Yeah!'", output.toString(), containsString("Yeah!"));
    }
}