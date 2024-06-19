package 과제.level3;

import java.time.LocalDateTime;
import java.util.Random;

public class Level3_5 {
    /*
    [문제]
		- 본인확인 인증번호 구현
		1. 문자열 authNumber 변수에 빈 데이터가 초기화 되어 있습니다.
		2. 난수[ 0~9 ]를 생성하여 authNumber변수에 추가합니다.
			난수 생성 코드 참고 : int random = new Random().nextInt(10);
		3. 총 6회 난수[ 0~9 ]를 생성하여 6자리 인증번호를 만들어줍니다.
	[조건]
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 실행할때마다 서로 다른 인증번호가 생성 되어야 합니다.
     */
    public static void main(String[] args) {

        System.out.println(" >> Level3_5 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");

        String authNumber = "";

        for(int i = 0 ; i < 6 ; i++){
            int random = new Random().nextInt(10);
            authNumber += random;
        }
        System.out.println("본인확인 인증번호 : "+authNumber);
    }
}
