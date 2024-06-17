package 과제.level1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Level1_7 {
    public static void main(String[] args) {
        /*
        [문제조건]
		1. 기본 자료형8개 + 문자열클래스 변수 1개 를 이용한 9개변수를 입력 받습니다.
		2. 입력받은 9개 변수를 그림과 같이 출력합니다.
         */
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Scanner scanner = new Scanner(System.in);

        System.out.println(">> Level1_7 answer >>");
        System.out.println(">> answer time : "+dateFormat.format(today));
        System.out.println();

        System.out.print("회원명 String : ");
        String 회원명 = scanner.next();
        System.out.print("상태 boolean : ");
        boolean 상태 = scanner.nextBoolean();
        System.out.print("회원번호 byte : ");
        byte 회원번호 = scanner.nextByte();
        System.out.print("성별 char : ");
        char 성별 = scanner.next().charAt(0);
        System.out.print("나이 short : ");
        short 나이 = scanner.nextShort();
        System.out.print("포인트 int : ");
        int 포인트 = scanner.nextInt();
        System.out.print("예금액 long : ");
        long 예금액 = scanner.nextLong();
        System.out.print("키 float : ");
        float 키 = scanner.nextFloat();
        System.out.print("몸무게 double : ");
        double 몸무게 = scanner.nextDouble();

        String s1 = " ";

        System.out.println();
        System.out.println("==========회원 개인정보==========");
        System.out.printf("|"+"%8s"+"회원명 : "+"%s"+"        |"+"\n" ,s1 , 회원명 , s1 );
        System.out.printf("|"+"%8s"+"상태 : "+"%b"+"          |"+"\n" ,s1 , 상태 , s1 );
        System.out.printf("|"+"%8s"+"회원번호 : "+"%d"+"         |"+"\n" ,s1 , 회원번호 , s1 );
        System.out.printf("|"+"%8s"+"성별 : "+"%c"+"             |"+"\n" ,s1 , 성별 , s1 );
        System.out.printf("|"+"%8s"+"나이 : "+"%d"+"            |"+"\n" ,s1 , 나이 , s1 );
        System.out.printf("|"+"%8s"+"포인트 : "+"%d"+"        |"+"\n" ,s1 , 포인트 , s1 );
        System.out.printf("|"+"%8s"+"예금액 : "+"%d"+"      |"+"\n" ,s1 , 예금액 , s1 );
        System.out.printf("|"+"%8s"+"평균 : "+"%4.1f"+"           |"+"\n" ,s1 , 키 , s1 );
        System.out.printf("|"+"%8s"+"평균 : "+"%5.2f"+"          |"+"\n" ,s1 , 몸무게 , s1 );
        System.out.println("===============================");


    }
}
