package at.nacs.twitterboardprogram;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TweetRepository extends MongoRepository<Tweet, String> {
    List<Tweet> findAllByUserOrderByTimestampDesc(String user);

    List<Tweet> findByUserOrderByTimestampDesc(String user);
}
