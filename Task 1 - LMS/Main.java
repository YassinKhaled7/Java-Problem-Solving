import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search by Title");
            System.out.println("4. Search by Author");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. List All Books");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        int isbn = scanner.nextInt();
                        library.addBook(new Book(title, author, isbn));
                    }
                    case 2 -> {
                        System.out.print("Enter ISBN of book to remove: ");
                        int isbn = scanner.nextInt();
                        library.removeBook(isbn);
                    }
                    case 3 -> {
                        System.out.print("Enter title to search: ");
                        String title = scanner.nextLine();
                        Optional<Book> found = library.searchByTitle(title);
                        System.out.println(found.map(book -> "Found: " + book).orElse("Book not found."));
                    }
                    case 4 -> {
                        System.out.print("Enter author to search: ");
                        String author = scanner.nextLine();
                        Optional<Book> found = library.searchByAuthor(author);
                        System.out.println(found.map(book -> "Found: " + book).orElse("Book not found."));
                    }
                    case 5 -> {
                        System.out.print("Enter ISBN to issue: ");
                        int isbn = scanner.nextInt();
                        library.issueBook(isbn);
                    }
                    case 6 -> {
                        System.out.print("Enter ISBN of book to return: ");
                        int isbn = scanner.nextInt();
                        library.returnBook(isbn);
                    }
                    case 7 -> library.listBooks();
                    case 0 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
