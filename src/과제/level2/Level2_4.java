package 과제.level2;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level2_4 {
    /*
    [문제] 가위바위보 게임을 진행합니다.
	[조건]
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 가위 바위 보 입력은 문자로 입력받습니다. [ player 변수 사용 ]
		3. 그림과 같이 컴퓨터가 낸 수를 출력합니다. [ com 변수 사용 ]
			난수 생성 코드 참고 : int random = new Random().nextInt(3);
		4. 승리자를 출력합니다.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int random = new Random().nextInt(3);
        System.out.println(random);

        System.out.print("가위 바위 보 : ");
        String player = scanner.next();
        // System.out.println(player);

        // 결과 값을 낼 변수들
        int playerNum = 0;  // 문자로 받은 값 숫자로 바꾸기 위한 변수.
        int com = random;

        if(player.equals("주먹")){
            playerNum = 0;
        }
        if(player.equals("가위")){
            playerNum = 1;
        }
        if(player.equals("보")){
            playerNum = 2;
        }
        if(!player.equals("주먹")&&!player.equals("가위")&&!player.equals("보")){
            System.out.println("알 수 없는 코드입니다.");
        }

        // System.out.println(playerNum);

        // 주먹 = 0 가위 = 1 보 = 2
        System.out.println(" >> Level2_4 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");
        // 무승부일 경우
        if(playerNum==com){
            System.out.println("무승부입니다.");
        }
        // 만약 내가 주먹을 낼 경우
        if(playerNum == 0){
            // com 가위 일 경우
            if(com==1){
                System.out.println("player 승리");
            }
            // com 보일 경우
            if(com==2){
                System.out.println("com 승리");
            }
        }
        // 만약 내가 가위를 낼 경우
        if(playerNum == 1){
            // com 주먹 일 경우
            if(com==0){
                System.out.println("com 승리");
            }
            // com 보일 경우
            if(com==2){
                System.out.println("player 승리");
            }
        }
        // 만약 내가 보를 낼 경우
        if(playerNum == 2){
            // com 가위 일 경우
            if(com==1){
                System.out.println("com 승리");
            }
            // com 주먹일 경우
            if(com==0){
                System.out.println("player 승리");
            }
        }

    }
}
