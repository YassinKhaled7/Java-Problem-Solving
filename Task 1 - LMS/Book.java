public class Book {
    private String title;
    private String author;
    int isbn;

    public Book(String title, String name, int num) {
        this.title = title;
        this.author = name;
        this.isbn = num;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return author;
    }

    public int getisbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String author) {
        this.author = author;
    }

    public void setisbn(int isbn) {
        this.isbn = isbn;
    }
}