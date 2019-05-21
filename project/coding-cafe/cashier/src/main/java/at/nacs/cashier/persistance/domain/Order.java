package at.nacs.cashier.persistance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Order {


  private String uuid;

  private String iteam;
}
