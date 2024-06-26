package 과제.level2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level2_1 {
    public static void main(String[] args) {
        /*
        [문제] 음악 재생이 반복적으로 재생되고 있습니다. x 입력하면 종료되도록 하세요
        [조건] 1. 문제풀이 위치 외 코드는 수정 불가 합니다.
        [샘플]
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println(" >> Level2_1 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");

        while( true ) {
            System.out.print(" 음악 재생 중 종료버튼[x] : ");
            char btn = scanner.next().charAt(0);
            if( btn == 'x' ){
                System.out.println("음악종료");
                break;
            }else {
                System.out.println("알 수 없는 코드입니다.");
            }
        }
    }
}
