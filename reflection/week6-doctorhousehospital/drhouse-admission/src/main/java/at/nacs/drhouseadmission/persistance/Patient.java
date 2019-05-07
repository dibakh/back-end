package at.nacs.drhouseadmission.persistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Patient {
  private String id;
  private String name;
  private String symptoms;

}
