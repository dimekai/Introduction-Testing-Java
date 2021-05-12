package player;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesus Diaz
 */
public class FizzBuzzTest {

    public FizzBuzzTest() {
    }

    @Test
    public void when_number_is_divisble_by_3() {
        assertEquals("Fizz", FizzBuzz.guessFizzBuzz(3));

    }

    @Test
    public void when_number_is_divisble_by_5() {
        assertEquals("Buzz", FizzBuzz.guessFizzBuzz(5));

    }

    @Test
    public void when_number_divisible_by_3_and_5() {
        assertEquals("FizzBuzz", FizzBuzz.guessFizzBuzz(15));
    }

}
