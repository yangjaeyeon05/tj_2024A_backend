package 과제.level1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Level1_8 {

        /*
        [문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	    [조건]
		1. 문자열클래스를 이용하여 그림과 같이 제목과 내용을 입력받습니다. [ 내용만 띄어쓰기가 가능하도록 입력받습니다 ]
		2. *반복문을 사용하지 않고 총 5개의 방문록이 작성 되도록 작성하시오.
		3. 방문록 1번 작성할때마다 방문록을 목록을 보여줍니다.
		4. 기존에 미리 작성된 변수를 최대한 활용합니다. 변수를 추가하지 않습니다.

         */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String header = "\n============방문록===============\n번호\t 작성자 \t 방문록\n";
        String boardlist = "";
        String footer = "================================\n";
        String output = "";

        /* 문제풀이 위치 */

        System.out.println(">> Level1_8 answer >>");
        System.out.println(">> answer time : "+dateFormat.format(today));
        System.out.println();

        System.out.print("[1]작성자 : ");
        String 작성자1 = scanner.next();

        scanner.nextLine(); // 의미없는 스캐너

        System.out.print("[1]방문록 : ");
        String 내용1 = scanner.nextLine();

        boardlist = 1 +  작성자1 + 내용1 + "\n";

        System.out.println(header);
        System.out.println(boardlist);
        System.out.print(footer);

        System.out.print("[2]작성자 : ");
        String 작성자2 = scanner.next();

        scanner.nextLine(); // 의미없는 스캐너

        System.out.print("[2]방문록 : ");
        String 내용2 = scanner.nextLine();

        boardlist += 2 +  작성자2 + 내용2 + "\n";

        System.out.println(header);
        System.out.println(boardlist);
        System.out.print(footer);

        System.out.print("[3]작성자 : ");
        String 작성자3 = scanner.next();

        scanner.nextLine(); // 의미없는 스캐너

        System.out.print("[3]방문록 : ");
        String 내용3 = scanner.nextLine();

        boardlist += 3 +  작성자3 + 내용3 + "\n";

        System.out.println(header);
        System.out.println(boardlist);
        System.out.print(footer);

        System.out.print("[4]작성자 : ");
        String 작성자4 = scanner.next();

        scanner.nextLine(); // 의미없는 스캐너

        System.out.print("[4]방문록 : ");
        String 내용4 = scanner.nextLine();

        boardlist += 4 +  작성자4 + 내용4 + "\n";

        System.out.println(header);
        System.out.println(boardlist);
        System.out.print(footer);

        System.out.print("[5]작성자 : ");
        String 작성자5 = scanner.next();

        scanner.nextLine(); // 의미없는 스캐너

        System.out.print("[2]방문록 : ");
        String 내용5 = scanner.nextLine();

        boardlist += 5 +  작성자5 + 내용5 ;

        System.out.println(header);
        System.out.println(boardlist);
        System.out.print(footer);


        /* ----------- */


    }
}