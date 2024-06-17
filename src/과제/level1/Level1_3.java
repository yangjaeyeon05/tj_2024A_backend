package 과제.level1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Level1_3 {
    public static void main(String[] args) {
        /*
        [문제] 그림과 같이 기본자료형을 이용하여 변수 8개 선언하고 입력 값을 대입하여 출력하시오.
	    [조건]
		1. 모든 기본자료형 8개 사용
		2. print() 메소드 사용
		3. scanner 객체 사용하여 입력받기
         */
        Scanner scan = new Scanner(System.in);

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(">> Level1_3 answer >>");
        System.out.println(">> answer time : "+dateFormat.format(today));

        System.out.print("input boolean : ");
        boolean b1 = scan.nextBoolean();

        System.out.print("input byte : ");
        byte by1 = scan.nextByte();

        System.out.print("input char : ");
        char c1 = scan.next().charAt(0);

        System.out.print("input short : ");
        short s1 = scan.nextShort();

        System.out.print("input int : ");
        int i1 = scan.nextInt();

        System.out.print("input long : ");
        long l1 = scan.nextLong();

        System.out.print("input float : ");
        float f1 = scan.nextFloat();

        System.out.print("input double : ");
        double d1 = scan.nextDouble();

        System.out.println("output boolean : " + b1);
        System.out.println("output byte : " + by1);
        System.out.println("output char : " + c1);
        System.out.println("output short : " + s1);
        System.out.println("output int : " + i1);
        System.out.println("output long : " + l1);
        System.out.println("output float : " + f1);
        System.out.println("output double : " + d1);

    }
}
