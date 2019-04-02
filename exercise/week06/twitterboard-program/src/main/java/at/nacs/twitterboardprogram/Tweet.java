package at.nacs.twitterboardprogram;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {

    private String id;
    private String user;
    private String message;
    private int likes;
    private List<String> comments;
    private LocalDateTime timestamp;

}
