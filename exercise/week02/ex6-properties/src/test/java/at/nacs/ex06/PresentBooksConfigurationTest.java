package at.nacs.ex06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class PresentBooksConfigurationTest {

    @Autowired
    Book book;

    @Test
    void presentBooks() {
        Map<String, Integer> presentBooks = book.getPresent();
        Assertions.assertEquals(3, presentBooks.size());
    }
}