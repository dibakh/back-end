package at.nacs.fengshuiapi.domain;


import at.nacs.fengshuiapi.MapLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class FengshuiClient {

    private final RestTemplate restTemplate;
    private final String url = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=A8e4a13FaAZaj548C68I7e0Zc4lDD4542771GF99";
    private final MapLoader mapLoader;

    @GetMapping("/sign/{birthday}")
    String getSign(@PathVariable LocalDate birthday) {
        String extensionUrl = "&year=" + birthday.getYear() +
                "&month=" + birthday.getMonthValue()
                + "&day=" + birthday.getDayOfMonth();

        Answer answer = restTemplate.getForObject(url + extensionUrl, Answer.class);
        return answer.getResult();
    }




    @GetMapping("/compatibility/sign/{birthday1}/{birthday2}")
    String getCompatibility(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) throws IOException {
        String sign1 = getSign(birthday1);
        String sign2 = getSign(birthday2);

        String signValue1 = mapLoader.getSigns().get(sign1);
        String signValue2 = mapLoader.getSigns().get(sign2);
        Answer answer = restTemplate.getForObject("https://fengshui-api.com/api/v1/findSignCompatibility?token=A8e4a13FaAZaj548C68I7e0Zc4lDD4542771GF99&sign=" + signValue1
                + "&sign2=" + signValue2, Answer.class);
        return answer.getResult();
    }
    @GetMapping("/compatibility/love/{birthday1}/{birthday2}")
    String getLove(@PathVariable LocalDate birthday1,@PathVariable LocalDate birthday2){
        Answer answer = restTemplate.getForObject("https://fengshui-api.com/api/v1/findLoveCompatibility?token=A8e4a13FaAZaj548C68I7e0Zc4lDD4542771GF99&year=" +
                        birthday1.getYear() + "&month=" + birthday1.getMonthValue() + "&day=" + birthday1.getDayOfMonth()
                        + "&year2=" + birthday2.getYear() + "&month2=" + birthday2.getMonthValue() + "&day2=" + birthday2.getDayOfMonth()
                , Answer.class);
        return answer.getResult();
    }
}

