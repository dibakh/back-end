package at.nacs.twitterboardprogram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TwitterTest {

    @Autowired
    Twitter twitter;

    @Autowired
    TweetRepository repository;

    @Autowired
    List<Tweet> tweets;

    @Autowired
    Tweet tweet;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        repository.saveAll(tweets);
    }

    @Test
    void findAllByOrderByTimestampDesc(String user) {
        List<Tweet> actual = twitter.findAllByTimestampDesc(user);
        assertThat(actual).isNotEmpty();

    }

    @Test
    void findAllByUserOrderByTimestampDesc(String user) {
        List<Tweet> actual = twitter.findAllByUserOrderByTimestampDesc(user);
        assertThat(actual).isNotEmpty();

    }

    @Test
    void postTweet() {
    }

    @Test
    void putLike() {
    }

    @Test
    void putComment() {
    }
}