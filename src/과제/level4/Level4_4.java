package 과제.level4;

import java.time.LocalDateTime;

public class Level4_4 {
    /*
    주제 : '제품' 을 설계하고 만들기
	[ 클래스 생성 ]
	멤버변수/필드 : 제품코드 , 제품명 , 가격 , 등록일
		- 위 필드을 적절한 자료형을 선택하여 설계하시오.
	[ 객체 생성 ]
	임의의 데이터를 입력하여 2개의 객체를 생성하고 출력하는 코드를 작성하시오.
     */
    public static void main(String[] args) {
        // 객체 2개 생성
        Product product1 = new Product();
        Product product2 = new Product();

        // getter and setter 사용하여 하나씩 대입하는 연습
        product1.setCode("A-1");
        product1.setName("콜라");
        product1.setPrice(1500);
        product1.setDate("2024-06-18");

        product2.setCode("A-2");
        product2.setName("환타");
        product2.setPrice(1700);
        product2.setDate("2024-06-19");

        // 출력
        System.out.println(" >> Level4_4 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");
        System.out.println("//================제품목록================//");
        System.out.println("제품코드   제품명    가격          등록일");
        System.out.println(product1.getCode()+"       "+product1.getName()+"     "+product1.getPrice()+"       "+product1.getDate());
        System.out.println(product2.getCode()+"       "+product2.getName()+"     "+product2.getPrice()+"       "+product2.getDate());
    }
}
