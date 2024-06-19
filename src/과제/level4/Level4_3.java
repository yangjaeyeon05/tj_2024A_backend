package 과제.level4;

import java.time.LocalDateTime;

public class Level4_3 {
    /*
    주제 : '회원' 을 설계하고 만들기
	[ 클래스 생성 ]
	멤버변수/필드 : 회원번호 , 아이디 , 비밀번호 , 이름
		- 위 필드을 적절한 자료형을 선택하여 설계하시오.

	[ 객체 생성 ]
	임의의 데이터를 입력하여 2개의 객체를 생성하고 출력하는 코드를 작성하시오.
     */

    public static void main(String[] args) {
        // 생성자 매개변수를 사용하지 않은 버전

        Member member1 = new Member();
        member1.no = 1;
        member1.id = "did123";
        member1.password = "1234";
        member1.name = "양재연";

        Member member2 = new Member();
        member2.no = 2;
        member2.id = "you34";
        member2.password = "4567";
        member2.name = "유재석";

        // 출력
        System.out.println(" >> Level4_3 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");
        System.out.println("//========================회원목록========================//");
        // toString 사용하여 쉽게 출력 가능
        System.out.println(member1);
        System.out.println(member2);

    }
}
