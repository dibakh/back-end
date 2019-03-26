package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.persistance.Patient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @MockBean
    DiagnosesClient client;

    @Test
    void admit() {
        Patient patient = Patient.builder()
                .name("Omar")
                .symptoms("headache")
                .build();

        Mockito.when(client.forward(patient))
                .thenReturn(patient);

        Patient actual = admission.admit(patient);

        assertThat(actual.getName()).isEqualTo("Omar");
        assertThat(actual.getSymptoms()).isEqualTo("headache");
        assertThat(actual.getId()).isNotEmpty();
    }
}