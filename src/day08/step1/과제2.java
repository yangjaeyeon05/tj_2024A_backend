package day08.step1;

import java.util.Arrays;
import java.util.Scanner;

public class 과제2 {
    public static void main(String[] args) {
        축구선수[] soccerTeam = new 축구선수[100];

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("1.선수등록 2.명단출력 3.종료 : ");

            int ch = scanner.nextInt();

            if(ch == 1){
                System.out.println("선수등록");

                for (int i = 0; i < soccerTeam.length; i++) {
                    if(soccerTeam[i] == null ){

                        soccerTeam[i] = new 축구선수();
                        System.out.println(soccerTeam[i]);

                        int randomVal = (int)(Math.random() * 101); // 0 ~ 99까지 랜덤
                        System.out.println("고유식별번호 : "+randomVal);

                        System.out.print("이름 : ");
                        soccerTeam[i].setName(scanner.next());

                        System.out.print("나이 : ");
                        soccerTeam[i].setAge(scanner.nextInt());

                        System.out.print("포지션 : ");
                        soccerTeam[i].setPosition(scanner.next());

                        System.out.print("소속팀 : ");
                        soccerTeam[i].setTeam(scanner.next());

                        System.out.println(soccerTeam[i].getNo()+soccerTeam[i].getName()+soccerTeam[i].getAge()+soccerTeam[i].getPosition()+soccerTeam[i].getTeam());
                        System.out.println(soccerTeam[i]);
                        break;
                    }
                }
            } else if (ch == 2) {
                System.out.println("명단출력");

                for (int i = 0; i < soccerTeam.length; i++) {
                    if(soccerTeam[i] != null){
                        System.out.println(soccerTeam[i].getNo()+soccerTeam[i].getName()+soccerTeam[i].getAge()+soccerTeam[i].getPosition()+soccerTeam[i].getTeam());
                    }
                }

            } else if (ch == 3) {
                System.out.println("종료");
                break;
            }else {
                System.out.println("알 수 없는 번호입니다.");
            }
        }
    }
}
