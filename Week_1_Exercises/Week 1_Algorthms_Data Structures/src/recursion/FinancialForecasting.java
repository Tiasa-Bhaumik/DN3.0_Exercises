package recursion;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue; // Base case
        } else {
            return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1); // Recursive case
        }
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Example initial investment
        double growthRate = 0.05; // Example growth rate of 5%
        int periods = 10; // Number of years

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("The future value of the investment is: $%.2f%n", futureValue);
    }
}

