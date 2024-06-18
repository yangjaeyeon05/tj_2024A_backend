package 과제.level2;

import java.time.LocalDateTime;

public class Level2_3 {
    /*
    [문제] 국어,영어,수학 3개의 점수가 선언되어 있습니다. 그림과 같이 출력하시오.
	[조건]
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2.
			합계 : 3개의 점수를 모두 더한 값
			평균 : 합계 / 과목수 		[소수 첫째자리 까지 출력 ]
			3배수 : 합계 값이 3의 배수이면 true 아니면 false
			7배수 : 합계 값이 7의 배수이면 true 아니면 false
			홀짝 : 합계 값이 홀수이면 홀수출력 아니면 짝수 출력
			결과 : 합계가 65점이상이면 합계 아니면 탈락 출력
		3. *(중요) 풀이코드에서 printf는 한번만 사용합니다.
     */
    public static void main(String[] args) {

        int 국어점수 = 89;
        int 영어점수 = 49;
        int 수학점수 = 72;
        int 합계 = 국어점수 + 영어점수 + 수학점수;
        float 평균 =  합계/3;
        boolean 삼배수 = false;
            if(합계%3==0){
                삼배수 = true;
            }else {
                삼배수 = false;
            }
        boolean 팔배수 = false;
            if(합계%8!=0){
                팔배수 = false;
            }else {
                팔배수 = true;
            }
        String 홀짝 = "";
            if(합계%2!=0){
                홀짝 = "홀수";
            }else {
                홀짝 = "짝수";
            }

        String 결과 = "";
        if(합계>=65){
            결과 = "합격";
        }else {
            결과 = "탈락";
        }

        System.out.println(" >> Level2_3 answer >> ");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >> \n");
        System.out.println("--------------------------------------------------------");
        System.out.println("국어   영어   수학   합계   평균   3배수   8배수   홀짝   결과");
        System.out.printf("%3d"+"%6d"+"%6d"+"%7d"+"%7.1f"+"%6b"+"%8b"+"%5s"+"%5s"
                ,국어점수 ,영어점수 , 수학점수 , 합계 , 평균 , 삼배수 , 팔배수 , 홀짝 , 결과);

    }
}
