package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.Communication.BedsClient;
import at.nacs.drhousediagnoses.Communication.PharmacyClient;
import at.nacs.drhousediagnoses.persistance.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class DoctorHouseTest {

    @Autowired
    DoctorHouse doctorHouse;

    @MockBean
    BedsClient bedsClient;

    @MockBean
    PharmacyClient pharmacyClient;

    @Test
    void recognize() {
        Patient patient = Patient.builder().name("Omar").symptoms("headache").build();
        Patient diagnosedPatient = doctorHouse.recognize(patient);

        Assertions.assertThat(diagnosedPatient.getDiagnosis()).isEqualTo("Punch");
    }
}