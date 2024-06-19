package day10.step2;

public class Book {

    // 1. 멤버변수/필드
    String bookName;
    String author;

    // 2. 생성자
    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
