package day06.Step6;

import java.util.Scanner;

public class Step6 {    // class s
    public static void main(String[] args) {    // main e

        // 1. 입력 객체 : 입력기능(.next())을 사용하려고
            // .next() 관련된 기능을 scanner 객체가 가지고 있으니까

        Scanner scanner = new Scanner(System.in);

        // 1. 객체 생성
        Account myAccount = new Account();

        // 2. 객체 내 필드/멤버변수에 값 대입
        myAccount.balance = 0;
        myAccount.number = "123-123";

        while (true){   // while s

            // 출력
            System.out.println("-------------------------");
            System.out.print(">>>1.예금 2. 출금 3. 잔고확인 4. 종료 : ");

            // 입력
            int ch = scanner.nextInt();

            // 3. 입력값에 따른 서로 다른 로직 처리(조건문)
            if(ch==1){          // 만약에 내가 입력한 값이 1이면 예금처리
                System.out.print("예금할 금액 입력 : ");
                int money = scanner.nextInt();
                System.out.println("money = " + money);

                myAccount.balance += money;
                System.out.println(">예금 현재 잔액 : "+myAccount.balance);
            } else if (ch==2) { // 만약에 내가 입력한 값이 2이면 출금처리
                System.out.print("출금할 금액 입력 : ");
                int money = scanner.nextInt();
                System.out.println("money = " + money);

                myAccount.balance -= money;
                System.out.println(">출금 현재 잔액 : "+myAccount.balance);
            } else if (ch==3) { // 만약에 내가 입력한 값이 3이면 잔고확인
                System.out.println(">잔고확인 현재 잔액 : "+myAccount.balance);
            } else if (ch==4) { // 만약에 내가 입력한 값이 4이면 종료
                System.out.println(">종료");
                break;
            }else { // 그 외
                System.out.println(">알 수 없는 입력 번호입니다.");
            }

        }   // while e

    }   // main e
}   // class e
