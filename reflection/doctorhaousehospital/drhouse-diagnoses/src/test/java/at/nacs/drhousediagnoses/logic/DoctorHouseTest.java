package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.persistence.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DoctorHouseTest {

    @Autowired
    DoctorHouse doctorHouse;

//    @ParameterizedTest
//    @CsvSource
//            ({
//                    "common Cold, pain",
//                    "Pneumonia, Throat infection",
//                    "Astigmatism, poor sight"
//    })
    @Test
    void recognize() {
        Patient patient = Patient.builder()
                .name("Omar")
                .symptoms("headache")
                .diagnosis("Incurable disease")
                .build();

        Patient diagnosedPatient = doctorHouse.getDiagnosis(patient);

        assertThat(diagnosedPatient.getDiagnosis()).isEqualTo("Incurable disease");
    }
}