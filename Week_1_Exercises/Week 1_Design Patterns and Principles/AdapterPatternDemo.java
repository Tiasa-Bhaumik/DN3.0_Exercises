public class AdapterPatternDemo {

    // Step 2: Define Target Interface
    interface PaymentProcessor {
        void processPayment();
    }

    // Step 3: Implement Adaptee Classes
    static class PayPal {
        public void makePayment() {
            System.out.println("Processing payment with PayPal.");
        }
    }

    static class Stripe {
        public void charge() {
            System.out.println("Processing payment with Stripe.");
        }
    }

    // Step 4: Implement the Adapter Class
    static class PayPalAdapter implements PaymentProcessor {
        private PayPal payPal;

        public PayPalAdapter(PayPal payPal) {
            this.payPal = payPal;
        }

        @Override
        public void processPayment() {
            payPal.makePayment();
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private Stripe stripe;

        public StripeAdapter(Stripe stripe) {
            this.stripe = stripe;
        }

        @Override
        public void processPayment() {
            stripe.charge();
        }
    }

    // Step 5: Test the Adapter Implementation
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());

        payPalProcessor.processPayment();
        stripeProcessor.processPayment();
    }
}

