package day14.step7;

public class BookShelfTest {
    public static void main(String[] args) {
        Queue shelfQueue = new BookShelf();
        shelfQueue.enQueue("태백산맥 1");
        shelfQueue.enQueue("태백산맥 2");
        shelfQueue.enQueue("태백산맥 3");
        // System.out.println(shelfQueue.getSize());

        System.out.println(shelfQueue.deQueue());

        System.out.println(shelfQueue.deQueue());
        System.out.println(shelfQueue.deQueue());

        BookShelf qustn = (BookShelf) shelfQueue;
        System.out.println(qustn.shelf);

        // shelf ArrayList를 호출해서 사용하고 싶으면 타입을 BookShelf로 변환 후 가능.
        // Queue 타입은 Shelf 클래스랑 같은 라인에 있는 아이 이기 때문에.

    }
}
