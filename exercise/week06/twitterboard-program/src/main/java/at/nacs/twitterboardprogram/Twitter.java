package at.nacs.twitterboardprogram;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class Twitter {

    private final TweetRepository repository;

    public List<Tweet> findAllByTimestampDesc(String user) {
        return repository.findAllByUserOrderByTimestampDesc(user);
    }

    public List<Tweet> findAllByUserOrderByTimestampDesc(String user) {

        return repository.findByUserOrderByTimestampDesc(user);
    }

    public void postTweet(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        repository.save(tweet);
    }

    public void putLike(String id) {
        Tweet tweet = repository.findById(id).orElse(null);
        int likes = tweet.getLikes();
        tweet.setLikes(likes + 1);
        repository.save(tweet);

    }

    public Tweet putComment(String id, String comments) {
        Tweet tweet = repository.findById(id).get();
        List<String> listOfComments = tweet.getComments();
        listOfComments.add(comments);
        tweet.setComments(listOfComments);
        repository.save(tweet);
        return tweet;

    }

}
