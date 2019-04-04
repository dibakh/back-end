package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistence.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class CureManagerTest {

    @Autowired
    Patient patient;

    @Autowired
    CureManager manager;


    @Test
    void register() {
    }
}