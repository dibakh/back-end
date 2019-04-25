package at.nacs.drhousepharmacy.Communication;

import at.nacs.drhousepharmacy.communication.AccountancyClient;
import at.nacs.drhousepharmacy.logic.Apothecary;
import at.nacs.drhousepharmacy.logic.PharmacyManager;
import at.nacs.drhousepharmacy.persistance.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    Patient patient;

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    AccountancyClient client;

    @MockBean
    Apothecary apothecary;

    @SpyBean
    PharmacyManager manager;


    @Test
    void diagnose() {

//        assertThat(patient.getMedicine()).isNull();
//
//        when(client.send(patient)).thenReturn(patient);
//
//        restTemplate.postForObject("/patients", patient, Patient.class);
//
//        verify(manager).register(patient);
    }
}