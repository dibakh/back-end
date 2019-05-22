package at.nacs.cashier.persistance.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Purchase {

  private String uuid;
  private List<String> items = new ArrayList<>();
}
