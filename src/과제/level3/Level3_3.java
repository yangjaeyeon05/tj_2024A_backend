package 과제.level3;

import java.time.LocalDateTime;

public class Level3_3 {
    /*
        [문제]
		다음과 같이 july1,july2,july3,july4 변수는 7월의 1주차,2주차,3주차,4주차 의 매출액이 저장된 변수 입니다.
		1. 주차별로 100만원당 도형 '■' 출력하시오.
		2. 도형 뒤로는 그림과 같이 만원대 까지만 출력하시오.
	    [샘플]

     */
    public static void main(String[] args) {
        // 100만원 도형 ■ , for문 활용 그 뒤로는 만원까지 출력
        int july1 = 3532100;    // ■■■353만원
        int july2 = 9123700;
        int july3 = 5183400;
        int july4 = 11738700;

        String square1 = "";
        String square2 = "";
        String square3 = "";
        String square4 = "";

        System.out.println(" >> Level3_3 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");

        System.out.println("----------------7월 매출액----------------");
        for(int i = 0; i < july1/1000000 ; i++){
            square1 += "■";
        }
        System.out.println("1주차 : "+square1+july1/10000+"만원");
        for(int i = 0; i < july2/1000000 ; i++){
            square2 += "■";
        }
        System.out.println("2주차 : "+square2+july2/10000+"만원");
        for(int i = 0; i < july3/1000000 ; i++){
            square3 += "■";
        }
        System.out.println("3주차 : "+square3+july3/10000+"만원");
        for(int i = 0; i < july4/1000000 ; i++){
            square4 += "■";
        }
        System.out.println("4주차 : "+square4+july4/10000+"만원");


    }
}
