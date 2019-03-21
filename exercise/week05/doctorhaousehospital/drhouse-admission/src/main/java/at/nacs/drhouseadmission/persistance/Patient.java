package at.nacs.drhouseadmission.persistance;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Patient {
    private String id;
    private String name;
    private String symptoms;

}
