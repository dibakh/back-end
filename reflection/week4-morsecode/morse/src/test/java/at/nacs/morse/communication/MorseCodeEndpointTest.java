package at.nacs.morse.communication;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MorseCodeEndpointTest {

    private String url="/morse";

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void postEncodedLetter() {
        Assertions.assertThat(testRestTemplate.postForObject("/morse", "A", String.class)).isEqualTo("·−");
    }
}