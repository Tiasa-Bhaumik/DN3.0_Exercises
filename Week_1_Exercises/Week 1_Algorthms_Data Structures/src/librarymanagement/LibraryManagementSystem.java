package librarymanagement;
import java.util.Arrays;

public class LibraryManagementSystem {
    // Linear search for books by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search for books by title
    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Sample book data
        Book[] books = {
                new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book(2, "To Kill a Mockingbird", "Harper Lee"),
                new Book(3, "1984", "George Orwell")
        };

        // Sort books by title for binary search
        Arrays.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));

        // Linear search example
        System.out.println("Linear Search:");
        Book book = linearSearch(books, "1984");
        System.out.println(book != null ? book : "Book not found");

        // Binary search example
        System.out.println("Binary Search:");
        book = binarySearch(books, "1984");
        System.out.println(book != null ? book : "Book not found");
    }
}

