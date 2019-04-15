package at.nacs.magic8ball.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageRandomizer {

  private final List<String> messages;

  public String getMessage() {
    Collections.shuffle(messages);
    return messages.get(0);

  }
}
