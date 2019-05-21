package at.nacs.cashier;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
public class Purchase {

  private UUID uuid;

  private List<String> products = new ArrayList<>();

}
