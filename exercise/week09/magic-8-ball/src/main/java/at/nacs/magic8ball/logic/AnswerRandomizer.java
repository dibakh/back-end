package at.nacs.magic8ball.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerRandomizer {

  private final List<String> answers;

  public String getAnswer() {
    Collections.shuffle(answers);
    return answers.get(0);

  }
}
