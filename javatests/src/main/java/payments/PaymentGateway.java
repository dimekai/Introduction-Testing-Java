package payments;

/**
 *
 * @author Jesus Diaz
 */
public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);

}
