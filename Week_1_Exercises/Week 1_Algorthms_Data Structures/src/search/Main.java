package search;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // Create sample products
        Product[] products = new Product[]{
                new Product(2, "Laptop", "Electronics"),
                new Product(3, "Smartphone", "Electronics"),
                new Product(1, "Table", "Furniture")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        // Test linear search
        Product resultLinear = SearchUtil.linearSearch(products, 2);
        System.out.println("Linear Search Result: " + resultLinear);

        // Test binary search
        Product resultBinary = SearchUtil.binarySearch(products, 3);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}

