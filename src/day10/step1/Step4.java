package day10.step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Step4 {
    public static void main(String[] args) {
        // * 입력객체
        Scanner scanner = new Scanner(System.in);
        // 1. 배열구성
        ArrayList<Product> productList = new ArrayList<>();
        // 2. 무한루프
        while (true){

            System.out.println("배열상태확인함수 : "+ productList);

            System.out.print("1.등록(C) 2.출력(R) 3.수정(U) 4.삭제(D) 5.종료 선택 >> "); // 무한출력

            int ch = scanner.nextInt(); // 무한입력 , 입력받은 데이터로 기능을 구현하기 위해
            // - 입력값에 따라 논리/경우의 수 판단
            if( ch == 1 ){
                // 1. 입력받고
                System.out.println(">>>제품코드 : ");       String code = scanner.next();
                System.out.println(">>>제품명 : ");        String name = scanner.next();
                System.out.println(">>>제품가격 : ");       int price = scanner.nextInt();
                // 2. 가공(유효성검사 혹은 객체화)
                Product p = new Product(code,name,price);
                // 3. 배열에 저장
                   productList.add(p);
            }
            else if( ch == 2 ){
                // 전과 동일
            }
            else if( ch == 3 ){
                // 전과 동일
            }
            else if( ch == 4 ){
                // 1. 입력받기
                System.out.print(">>삭제할 제품코드 : ");  String deleteCode = scanner.next();
                // 2. 삭제할 코드 찾기
                for( int i = 0; i < productList.size() ; i++){
                    if(productList.get(i).getCode().equals(deleteCode)){
                        productList.remove(i);
                        break;
                    }
                }
            }
            else if( ch == 5 ){
                System.out.println("안내] 프로그램 종료합니다.");
                break;
            }
            else{
                System.out.println("안내] 알수없는 번호 입니다.");
            }
        }   // while end
    }   // main end
}   // class end
/*
    [메모리설계]
    1. 객체의 추상적인 구성( 특성, 행위 )을 클래스로 구현해서 선언
    2. 구성한 개념을 클래스로 구현하기
    3. 해당 클래스 타입의 객체를 여러개 저장하기 위해 배열 선정/만들기
        - 배열 선언 방법 : 타입[] 배열변수명 = new 타입[길이];
    [화면 구현 설계]
    1. 콘솔에 출력할 내용들을 구성
    [ 기능 구현 ]
 */