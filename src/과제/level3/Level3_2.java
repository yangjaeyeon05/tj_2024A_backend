package 과제.level3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_2 {
    /*
    [문제]
    그림과 같이 무한적으로 문자열을 입력 받다가 end 입력시
    입력받은 횟수와 문구를 출력후 종료되는 반복문을 구현하시오.
	[조건]
            1. 문제풀이 위치 외 코드는 수정 불가 합니다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 1;

        System.out.println(" >> Level3_2 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");

        while (true){

         // 문자열을 입력받는다
            System.out.print(n+"회입력 : ");
            String text = scanner.next();

         // end 입력 시 종료
            // 문자열 입력받은 횟수 출력 end 문자열 제외

            if(text.equals("end")){
                System.out.println("[안내] 프로그램을 종료합니다. 총 " +(n-1)+"회 입력");
                break;
            }

            n += 1;
        }
    }
}
