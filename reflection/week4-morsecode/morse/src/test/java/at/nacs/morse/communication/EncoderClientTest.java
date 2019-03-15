package at.nacs.morse.communication;

import at.nacs.morse.logic.EncoderClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class EncoderClientTest {

    @Autowired
    EncoderClient encoderClient;

    @Test
    void encode() {
        Assertions.assertThat(encoderClient.encode("A")).isEqualTo("·−");
    }
}