package sorting;

import java.util.Arrays;

public class Quicksort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high]
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Alice", 250.0),
                new Order(2, "Bob", 150.0),
                new Order(3, "Charlie", 300.0)
        };

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(orders));

        quickSort(orders, 0, orders.length - 1);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(orders));
    }
}

