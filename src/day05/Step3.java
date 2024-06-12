package day05;

import java.util.Scanner;

public class Step3 {    // class s
    public static void main(String[] args) {    // main s
        // [입력] : 입력객체
        Scanner scanner = new Scanner(System.in);
        /*
        // [1] 입력받은 수 만큼 별 출력
            // 1. 키보드로부터 정수형으로 입력받아 정수형 변수에 저장
        System.out.print("[1]별 개수 : ");
        int star1 = scanner.nextInt();
        System.out.println(">star1 = " + star1);
            // 2. 입력받은 수만큼 '*' 출력
        for(int i = 1 ; i <= star1 ; i++){
            System.out.print('*');
        }
        System.out.println("\n=============구분선=============");

        // [2] 입력받은 수 만큼 별 출력 3의 배수마다 줄바꿈처리하시오.
        System.out.print("[2]별 개수 : ");
        int star2 = scanner.nextInt();  // scanner 객체 생성은 { } 마다 1번 선언
        System.out.println(">star2 = " + star2);
            // 2. 입력받은 수 만큼 '*' 출력 만약에 3의 배수이면 줄바꿈 처리
        for(int i = 1 ; i <=star2 ; i++){
            System.out.print('*');
            if(i%3 == 0){
                System.out.println();
            }
        }
        System.out.println("\n=============구분선=============");

        // [3] 입력받은 수 만큼 별을 하나에 변수에 하나씩 추가 후 해당 변수 출력
        System.out.print("[3]별 개수 : ");
        int star3 = scanner.nextInt();
        String star = "";
        for(int i = 1 ; i <= star3 ; i++){
            star += "*";
        }
        System.out.println("star = " + star);
        System.out.println("\n=============구분선=============");

        // [4]
        System.out.print("[4]줄 수 : ");
        int inputLine = scanner.nextInt();
        String html = "";

        // 현재 줄 수는 1부터 입력받은 줄수 까지 1씩 증가
        for (int currentLine = 1; currentLine <= inputLine; currentLine++) {
            for(int star = 1 ; star <= currentLine ; star++){
                html += "*";
            }
                // 줄바꿈
            html += "\n";
        }
        System.out.println(html);


        // [5]
        System.out.print("[5]줄 수 : ");  // 안내문 출력
        int iLine = scanner.nextInt();  // 키보드로부터 입력받은 값 반환해서 변수에 저장

        String html = "";

        for(int cLine = 1 ; cLine <= iLine ; cLine++){

            // 줄마다 공백출력
            for(int blank = 1 ; blank <= iLine-cLine ; blank++){
                html+=" ";
            }
            // 줄마다 별 출력
            for(int star = 1 ; star <= cLine ; star++){
                html += "*";
            }
            // 줄마다 줄바꿈
            html += "\n";
        }
        System.out.println(html);


        // [6]
        System.out.print("[6]줄 수 : ");  // 안내문 출력
        int iLine = scanner.nextInt();  // 키보드로부터 입력받은 값 반환해서 변수에 저장

        String html = "";

        for(int cLine = 1 ; cLine <= iLine ; cLine++){

            // 줄마다 별 출력
            for(int star = 1 ; star <= iLine-cLine+1 ; star++){
                html += "*";
            }
            // 줄마다 줄바꿈
            html += "\n";
        }
        System.out.println(html);


        // [7]
        System.out.print("[7]줄 수 : ");  // 안내문 출력
        int iLine = scanner.nextInt();  // 키보드로부터 입력받은 값 반환해서 변수에 저장

        String html = "";

        for(int cLine = 1 ; cLine <= iLine ; cLine++){

            // 줄마다 공백출력
            for(int blank = 1 ; blank <= cLine-1 ; blank++){
                html+=" ";
            }
            // 줄마다 별 출력
            for(int star = 1 ; star <= iLine-cLine+1 ; star++){
                html += "*";
            }
            // 줄마다 줄바꿈
            html += "\n";
        }
        System.out.println(html);

        // [8]
        System.out.print("[8]줄 수 : ");  // 안내문 출력
        int iLine = scanner.nextInt();  // 키보드로부터 입력받은 값 반환해서 변수에 저장

        String html = "";

        for(int cLine = 1 ; cLine <= iLine ; cLine++){

            // 줄마다 공백출력
            for(int blank = 1 ; blank <= iLine-cLine  ; blank++){
                html+=" ";
            }

            // 줄마다 별 출력
            for(int star = 1 ; star <= cLine*2-1 ; star++){
                html += "*";
            }

            // 줄마다 줄바꿈
            html += "\n";
        }
        System.out.println(html);

        // [9]
        System.out.print("[9]줄 수 : ");  // 안내문 출력
        int iLine = scanner.nextInt();  // 키보드로부터 입력받은 값 반환해서 변수에 저장

        String html = "";

        for(int cLine = 1 ; cLine <= iLine ; cLine++){

            // 줄마다 공백출력
            for(int blank = 1 ; blank <= cLine-1  ; blank++){
                html+=" ";
            }

            // 줄마다 별 출력
            for(int star = 1 ; star <= (iLine-cLine)*2+1 ; star++){
                html += "*";
            }

            // 줄마다 줄바꿈
            html += "\n";
        }
        System.out.println(html);
        */
        /*
        // [10]
        System.out.print("[10]줄 수 : ");  // 안내문 출력

        int iLine = scanner.nextInt();  // 키보드로부터 입력받은 값 반환해서 변수에 저장

        String html = "";
        String html2 = "";

        for(int cLine = 1 ; cLine <= iLine ; cLine++){

            // 줄마다 공백출력
            for(int blank = 1 ; blank <= iLine-cLine  ; blank++){
                html+=" ";
            }

            // 줄마다 별 출력
            for(int star = 1 ; star <= cLine*2-1 ; star++){
                html += "*";
            }

            // 줄마다 줄바꿈
            html += "\n";
        }
        for(int cLine = 1 ; cLine <= iLine-1 ; cLine++){

            // 줄마다 공백출력
            for(int blank = 1 ; blank <= cLine  ; blank++){
                html2 +=" ";
            }

            // 줄마다 별 출력
            for(int star = 1 ; star <= (iLine-cLine)*2-1 ; star++){
                html2 += "*";
            }

            // 줄마다 줄바꿈
            html2 += "\n";
        }
        System.out.println(html+html2);
        */

        // [11]
        char star = '*';
        char space = ' ';
        int a = 1, z = 9;
        int i=1;
        int start = 0;
        start = i/2 + 1;
        for(i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                if(a==j || z==j){
                    System.out.print(star);
                }else{
                    System.out.print(space);
                }
            }
            a++;
            z--;
            System.out.println();
        }

    }   // main e
}   // class e
