package at.nacs.drhouseadministrationui.view.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Invoice {

  private Long id;
  private Patient patient;
  private Kind kind;
  private String symptoms;
  private String diagnosis;
  private String provided;
  private double cost;
  private boolean paid;
  private LocalDateTime timestamp;

}
