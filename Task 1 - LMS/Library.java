import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private final List<Book> books;
    private final List<Book> issuedBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.issuedBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void removeBook(int isbn) {
        books.removeIf(book -> book.getIsbn() == isbn);
        System.out.println("Book with ISBN " + isbn + " removed.");
    }

    public Optional<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public Optional<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .findFirst();
    }

    public synchronized void issueBook(int isbn) throws Exception {
        Optional<Book> bookOpt = books.stream()
                .filter(b -> b.getIsbn() == isbn)
                .findFirst();

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            books.remove(book);
            issuedBooks.add(book);
            System.out.println("Book issued: " + book);
        } else {
            throw new Exception("Book not found or already issued.");
        }
    }

    public synchronized void returnBook(int isbn) throws Exception {
        Optional<Book> bookOpt = issuedBooks.stream()
                .filter(b -> b.getIsbn() == isbn)
                .findFirst();

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            issuedBooks.remove(book);
            books.add(book);
            System.out.println("Book returned: " + book);
        } else {
            throw new Exception("This book was not issued or ISBN is incorrect.");
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books currently available in the library.");
        } else {
            System.out.println("Available books:");
            books.forEach(System.out::println);
        }
    }

}
