package at.nacs.fengshuiprofiler.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Match {

    private Profile profile1;
    private Profile profile2;
    private String signCompatibility;
    private String loveCompatibility;
}
