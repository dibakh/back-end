package at.nacs.cashier.persistance.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

  private String uuid;
  private List<String> items = new ArrayList<>();
}
