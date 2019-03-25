package at.nacs.fengshuiprofiler.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Profile {

    private LocalDate birthday;
    private String sign;

}
