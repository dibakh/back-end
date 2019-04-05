package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistence.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class CureManagerTest {

    @Autowired
    Patient patient;

    @Autowired
    CureManager manager;

    @Test
    void register() {
        assertThat(patient.getTreatment()).isNull();

        Patient registeredPatient = manager.register(patient);

        assertThat(registeredPatient.getTreatment()).isNotNull();
    }
}