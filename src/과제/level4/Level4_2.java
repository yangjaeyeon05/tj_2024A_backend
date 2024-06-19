package 과제.level4;

import java.time.LocalDateTime;

public class Level4_2 {
    /*
    주제 : '방문록' 을 설계하고 만들기
	[ 클래스 생성 ]
	멤버변수/필드 : 방문록번호 , 내용 , 작성일 , 작성자
		- 위 필드을 적절한 자료형을 선택하여 설계하시오.

	[ 객체 생성 ]
	임의의 데이터를 입력하여 2개의 객체를 생성하고 출력하는 코드를 작성하시오.

     */
    public static void main(String[] args) {
        // 임의 데이터를 입력하여 2개의 객체를 생성하라
        Board board1 = new Board(1,"안녕하세요","2024-06-18","유재석");
        Board board2 = new Board(2,"반갑습니다","2024-06-19","강호동");

        // 출력
        System.out.println(" >> Level4_2 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");

        System.out.println("//=====================방명록=====================//");
        System.out.println("번호         내용           작성일           작성자");
        System.out.println(board1.no +"        "+ board1.content +"       "+ board1.date +"        "+ board1.writer );
        System.out.println(board2.no +"        "+ board2.content +"       "+ board2.date +"        "+ board2.writer );

    }
}
