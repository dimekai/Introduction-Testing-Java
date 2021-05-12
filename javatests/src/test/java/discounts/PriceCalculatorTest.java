package discounts;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Jesus Diaz
 */
public class PriceCalculatorTest {

    private PriceCalculator calculator;

    public PriceCalculatorTest() {
    }

    @Before
    public void setup() {
        calculator = new PriceCalculator();
    }

    @Test
    public void total_zero_when_no_prices() {
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {
        calculator.addPrice(10.51);
        calculator.addPrice(84.33);
        assertThat(calculator.getTotal(), is(94.84));
    }

    @Test
    public void apply_discount_to_prices() {
        calculator.addPrice(17.58);
        calculator.addPrice(9.42);

        calculator.setDiscount(30.0);

        assertThat(calculator.getTotal(), is(18.9));
    }

}
