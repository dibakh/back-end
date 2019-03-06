package at.nacs.primenumber;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class PrimeAdder {

    private final Primes primes;

    public int getSum(int amount) {
        return IntStream.iterate(2, e -> e + 1)
                .filter(primes::isPrime)
                .limit(amount)
                .sum();
    }
}