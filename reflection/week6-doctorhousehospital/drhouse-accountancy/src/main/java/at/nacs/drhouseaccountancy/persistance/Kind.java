package at.nacs.drhouseaccountancy.persistance;

import lombok.Data;


@Data
public class Kind {

    //    @Enumerated(EnumType.STRING)
    public enum kind {
        TREATMENT, MEDICINE
    }
}
