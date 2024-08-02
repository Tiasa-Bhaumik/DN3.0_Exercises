public class StrategyPatternDemo {

    // Step 2: Define Strategy Interface
    interface PaymentStrategy {
        void pay(int amount);
    }

    // Step 3: Implement Concrete Strategies
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paying " + amount + " using Credit Card: " + cardNumber);
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paying " + amount + " using PayPal: " + email);
        }
    }

    // Step 4: Implement Context Class
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public PaymentContext(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(int amount) {
            paymentStrategy.pay(amount);
        }
    }

    // Step 5: Test the Strategy Implementation
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432");
        PaymentStrategy payPal = new PayPalPayment("user@example.com");

        PaymentContext context = new PaymentContext(creditCard);
        context.executePayment(500);

        context = new PaymentContext(payPal);
        context.executePayment(300);
    }
}

