package at.nacs.drhouseaccountancy.Domain;

import lombok.Data;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;

@Data
public class Invoice {

  @Id
  @GeneratedValue
  private Long id;


  @ManyToOne
  private Patient patient;

  @Enumerated(STRING)
  private Kind kind;
  private String symptoms;
  private String diagnosis;
  private String provided;
  private double cost;
  private boolean paid;
  private LocalDateTime timestamp;

}
