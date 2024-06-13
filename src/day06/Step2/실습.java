package day06.step2;

public class 실습 {
    public static void main(String[] args) {

        Card c1 = new Card();

        c1.name = "현대카드";
        System.out.println(c1.name);
        c1.color = "white";
        System.out.println(c1.color);
        c1.width = 85;
        System.out.println(c1.name+"의 카드 길이는 "+c1.width+"mm 입니다.");
        c1.height = 54;
        System.out.println(c1.name+"의 카드 높이는 "+c1.height+"mm 입니다.");

        c1.결제();

        Card c2 = new Card();

        c2.name = "국민카드";
        System.out.println(c2.name);
        c2.color = "silver";
        System.out.println(c2.color);
        c2.width = 85;
        System.out.println(c2.name+"의 카드 길이는 "+c2.width+"mm 입니다.");
        c2.height = 54;
        System.out.println(c2.name+"의 카드 높이는 "+c2.height+"mm 입니다.");

        c2.결제();

    }
}
