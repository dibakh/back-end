package at.nacs.drhouseadministrationui.communication;

import at.nacs.drhouseadministrationui.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvoiceClient {
  private final RestTemplate restTemplate;

  @Value("${invoices.url}")
  private String url;

  public List<Invoice> getAll() {
    Invoice[] invoices = restTemplate.getForObject(url, Invoice[].class);
    return Arrays.asList(invoices);
  }

  public void markAsPaid(String id) {
    url = url + "/" + id + "/paid";
    restTemplate.put(url, void.class);
  }
}
