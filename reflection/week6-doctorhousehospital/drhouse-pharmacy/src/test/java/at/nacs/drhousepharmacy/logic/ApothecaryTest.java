package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.Communication.AccountancyClient;
import at.nacs.drhousepharmacy.persistance.Patient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

class ApothecaryTest {
    @Autowired
    Apothecary apothecary;

    @MockBean
    AccountancyClient client;

    @Spy
    PharmacyManager manager;

    @Test
    void getMedicine() {

        Patient patient = Patient.builder()
                .name("name")
                .symptoms("symptoms")
                .diagnosis("x")
                .build();

        assertThat(patient.getMedicine()).isNull();

        Patient actual = apothecary.getMedicine(patient);

        assertThat(actual.getMedicine()).isEqualTo("medicine1");
        assertThat(actual.getMedicine()).isNotNull();

        Mockito.verify(manager).register(patient);

    }
}

