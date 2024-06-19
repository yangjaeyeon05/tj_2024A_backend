package 과제.level4;

public class Board {
    int no;
    String content;
    String date;
    String writer;

    public Board(int no, String content, String date, String writer) {
        this.no = no;
        this.content = content;
        this.date = date;
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Board{" +
                "no=" + no +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
