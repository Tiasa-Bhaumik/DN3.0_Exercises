package recursion;
import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting_optimised {
    private static Map<Integer, Double> memo = new HashMap<>();

        // Optimized recursive method using memoization
        public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
            if (periods == 0) {
                return presentValue; // Base case
            }
            if (memo.containsKey(periods)) {
                return presentValue * memo.get(periods);
            }
            double futureValue = calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
            memo.put(periods, futureValue / presentValue); // Store the growth factor
            return futureValue;
        }

        public static void main(String[] args) {
            double presentValue = 1000.0; // Example initial investment
            double growthRate = 0.05; // Example growth rate of 5%
            int periods = 10; // Number of years

            double futureValue = calculateFutureValue(presentValue, growthRate, periods);
            System.out.printf("The future value of the investment is: $%.2f%n", futureValue);
        }
    }


