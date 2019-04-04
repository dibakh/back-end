package at.nacs.drhouseaccountancy.persistance;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    private String uuid; //(id that arrived from the DTO)
    private String name;

}
