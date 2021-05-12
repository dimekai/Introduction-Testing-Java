package player;

/**
 *
 * @author Jesus Diaz
 */
public class FizzBuzz {

    public static String guessFizzBuzz(int num) {
        String result = "";
        if (num % 3 == 0) {
            result += "Fizz";
        }
        if (num % 5 == 0) {
            result += "Buzz";
        }

        return result.isEmpty() ? String.valueOf(num) : result;
    }

}
