package at.nacs.drhouseaccountancy.persistance;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Invoice {
    private Long id;
    private Patient patient; //(many to one)
    private Kind kind; //(enum)
    private String symptoms;
    private String diagnosis;
    private String provided; //(either the treatment given or the medicine suggested)
    private double cost;
    private boolean paid;
    private LocalDateTime timestamp;

}
