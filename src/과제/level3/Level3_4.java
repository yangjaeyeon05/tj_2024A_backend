package 과제.level3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_4 {
    /*
    [문제] 그림과 같이 계속입력한 수에 따라 누적으로 저장되어 저장된 수 만큼 '■' 를 출력하시오.
	[조건]
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 만약에 누적값이 0 보다 작으면 종료됩니다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" >> Level3_4 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");

        // 무한 반복 - 특정 조건까지 반복
        int sum = 0;

        while(true){
            // 입력한 수에 따라 누적 저장
                // 입력받기
            System.out.print("input : ");
            sum += scanner.nextInt();
            // 만약 누적 값이 0보다 작으면 종료
            if(sum < 0){
                System.out.println("종료");
                break;
            }else {
                // 아니면 누적 만큼 도형 출력
                for(int i = 0 ; i < sum ; i++){
                    // 만약 누적 값이 0 보다 작으면 종료
                    System.out.print("■ ");
                }
                System.out.println();
            }
        }
    }
}
