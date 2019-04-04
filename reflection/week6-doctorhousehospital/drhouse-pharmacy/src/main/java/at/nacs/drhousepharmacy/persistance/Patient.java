package at.nacs.drhousepharmacy.persistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private String id;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String medicine;
}
