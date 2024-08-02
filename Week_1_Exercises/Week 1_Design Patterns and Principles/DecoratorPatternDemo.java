public class DecoratorPatternDemo {

    // Step 2: Define Component Interface
    interface Notifier {
        void send(String message);
    }

    // Step 3: Implement Concrete Component
    static class EmailNotifier implements Notifier {
        @Override
        public void send(String message) {
            System.out.println("Sending email: " + message);
        }
    }

    // Step 4: Implement Decorator Classes
    abstract static class NotifierDecorator implements Notifier {
        protected Notifier decoratedNotifier;

        public NotifierDecorator(Notifier decoratedNotifier) {
            this.decoratedNotifier = decoratedNotifier;
        }

        @Override
        public void send(String message) {
            decoratedNotifier.send(message);
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            System.out.println("Sending Slack message: " + message);
        }
    }

    // Step 5: Test the Decorator Implementation
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        slackNotifier.send("Hello, World!");
    }
}

