import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public void addbook(Book book){
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removebook(Book book){
        books.remove(book);
        System.out.println("Book removed: " + book.getTitle());
    }

    public Book searchBook(String title) throws Exception {
        Optional<Book> foundBook = books.stream()
            .filter(book -> book.getTitle().equalsIgnoreCase(title))
            .findFirst();
    
        if (foundBook.isPresent()) {
            return foundBook.get();
        } else {
            throw new Exception("Book not found: " + title);
        }
    }

    public synchronized void issueBook(int isbn) throws Exception {
        Book book = books.stream()
            .filter(b -> b.getisbn() == isbn)
            .findFirst()
            .orElseThrow(() -> new Exception("Book not found: " + isbn));
    
        books.remove(book);
        System.out.println("Book issued: " + book.getTitle());
    }
    
    public synchronized void returnBook(Book book) {
        books.add(book);
        System.out.println("Book returned: " + book.getTitle());
    }
    
}
