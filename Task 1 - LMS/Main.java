public class Main {
    public static void main(String[] args){
        Library library = new Library();

        Book book1 = new Book("Basic", "John", 12345);
        Book book2 = new Book("Intermediate", "Mark", 56678);
        Book book3 = new Book("Advanced", "Vince", 12992);

        library.addbook(book1);
        library.addbook(book2);
        library.addbook(book3);
        library.removebook(book3);

        try {
            Book found = library.searchBook("Basic");
            System.out.println("Book found: " + found.getTitle());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Book found = library.searchBook("new book");
            System.out.println("Book found: " + found.getTitle());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        Thread t1 = new Thread(() -> {
            try {
                library.issueBook(12345);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        
        Thread t2 = new Thread(() -> library.returnBook(book1));
        
        t1.start();
        t2.start();
    }
}
