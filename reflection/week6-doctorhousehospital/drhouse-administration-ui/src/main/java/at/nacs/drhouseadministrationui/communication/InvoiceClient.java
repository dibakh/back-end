package at.nacs.drhouseadministrationui.communication;

import at.nacs.drhouseadministrationui.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class InvoiceClient {
  private final RestTemplate restTemplate;

  @Value("${invoices.url}")
  private String invoicesUrl;

  @Value("${invoices.paid.url}")
  private String paidUrl;

  public List<Invoice> getAll() {
    Invoice[] invoices = restTemplate.getForObject(invoicesUrl, Invoice[].class);
    return Arrays.asList(invoices);
  }

  public void markAsPaid(Long id) {
    restTemplate.put(paidUrl, null, Map.of("id", id));
  }
}
