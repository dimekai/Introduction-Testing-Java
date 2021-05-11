package payments;

/**
 *
 * @author Jesus Diaz
 */
public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        boolean status = false;
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        if (response.getStatus() == PaymentResponse.PaymentStatus.OK) {
            status = true;
        }
        return status;
    }
}
