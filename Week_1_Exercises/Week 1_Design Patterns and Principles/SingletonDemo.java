
public class SingletonDemo {

    // Singleton Logger class
    public static class Logger {
        // Private static instance of the Logger class
        private static Logger instance;

        // Private constructor to prevent instantiation
        private Logger() {
            // Initialization code
        }

        // Public static method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        // Example method to log messages
        public void log(String message) {
            System.out.println("Log message: " + message);
        }
    }

    // Main method to test the Singleton pattern
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Logger is a singleton.");
        } else {
            System.out.println("Logger is not a singleton.");
        }

        // Use the logger
        logger1.log("This is a log message.");

        // Demonstrate that logger1 and logger2 are the same instance
        logger2.log("This message is from logger2.");
    }
}
