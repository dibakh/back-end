package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientEndpoint {

  private final Accountant accountant;

  @PostMapping
  void post(@RequestBody PatientDTO patientDTO) {
    accountant.invoice(patientDTO);
  }
}

