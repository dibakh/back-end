package at.nacs.fengshuiapi;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties("symbol")
@Component
@Setter
@Getter
@RequiredArgsConstructor
public class MapLoader {

    private final Map<String, String> signs;

}
