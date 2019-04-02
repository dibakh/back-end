package at.nacs.twitterboardprogram;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetEndpoint {

    private final Twitter manager;

    @GetMapping
    List<Tweet> findOrderByTime(String user) {
        return manager.findAllByTimestampDesc(user);

    }

    @GetMapping("/user/{user}")
    List<Tweet> findUserByOrderTime(String user) {
        return manager.findAllByUserOrderByTimestampDesc(user);

    }

    @PostMapping
    void postTweet(@RequestBody Tweet tweet) {
        manager.postTweet(tweet);
    }

    @PutMapping("/{id}/likes")
    void putLike(@PathVariable String id) {
        manager.putLike(id);
    }

    @PutMapping("/{id}/comments")
    Tweet putComment(@PathVariable String id, @RequestBody String comments) {
        return manager.putComment(id, comments);
    }
}