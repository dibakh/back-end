package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.persistance.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @MockBean
    DiagnosesClient client;

    @Test
    void admit() {
        Patient patient = Patient.builder().name("Omar").symptoms("headache").build();

        Patient actual = admission.admit(patient);
        Assertions.assertThat(actual.getName()).isEqualTo("Omar");

        Assertions.assertThat(actual.getSymptoms()).isEqualTo("headache");
        Assertions.assertThat(actual.getId()).isNotEmpty();
    }
}