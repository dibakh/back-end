package at.nacs.fengshuiprofiler;

import at.nacs.fengshuiprofiler.domain.Match;
import at.nacs.fengshuiprofiler.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class ProfileEndpoint {

    private final RestTemplate restTemplate;

    private String signUrl = "http://localhost:9001/sign";
    private String compatibilityUrl = "http://localhost:9001/compatibility";

    @GetMapping("/profile/{birthday}")
    Profile toProfile(@PathVariable LocalDate birthday) {
        String sign = restTemplate.getForObject(signUrl + "/" + birthday, String.class);
        Profile profile = Profile.builder()
                .sign(sign)
                .birthday(birthday)
                .build();
        return profile;
    }


    @GetMapping("/match/{birthday1}/{birthday2}")
    Match gett(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return Match.builder()
                .profile1(toProfile(birthday1))
                .profile2(toProfile(birthday2))
                .loveCompatibility(getCompatibility("love", birthday1, birthday2))
                .signCompatibility(getCompatibility("sign", birthday1, birthday2))
                .build();
    }

    private String getCompatibility(String type, LocalDate birthday1, LocalDate birthday2) {
        String url = compatibilityUrl + "/" + type + "/" + birthday1 + "/" + birthday2;
        return restTemplate.getForObject(url, String.class);
    }
}