package discounts;

import java.util.ArrayList;

/**
 *
 * @author Jesus Diaz
 */
public class PriceCalculator {

    private ArrayList<Double> prices = new ArrayList<>();
    private double discount;

    public double getTotal() {
        double total = 0;

        for (Double price : prices) {
            total += price;
        }

        return total - (total * (discount / 100));
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}
