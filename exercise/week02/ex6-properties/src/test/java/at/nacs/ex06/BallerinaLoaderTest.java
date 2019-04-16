package at.nacs.ex06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BallerinaLoaderTest {

    @Autowired
    BallerinaLoader ballerina;

    @ParameterizedTest
    @CsvSource({
            "sara, 1",
            "lili, 5",
            "juliet, 3",
            "andrea, 2"
    })
    void getBallerinas(String name, int performance_quality) {
        List<Ballerina> ballerinas = ballerina.getPerson();
        Assertions.assertEquals(4, ballerinas.size());
    }
}