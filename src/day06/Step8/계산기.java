package day06.Step8;

import java.util.Random;

public class 계산기 {  // class s

    /*
        함수 정의 : 클래스 { } 안에서 작성
        함(상자)수(숫자)란? 상자안에 들어있는 수 -> 상자안에 들어있는 코드
            - 왜? 미리 만들어진 코드 -> 미리 만들어서 반복적으로 사용하기 위해
            변수(값 저장) vs 함수(실행문 저장)

            자바의 함수 선언방법
                반환타입 함수명 ( 타입 매개변수명1 , 타입 매개변수명2 ){
                    다양한 실행문;/로직
                    return 반환값;
                }

                1. 반환 타입 : return 문에 넣어준 값의 자료형/타입
                    - 만일 return 문에 넣어준 값이 없으면 void
                2. 함수명 : (임의) * 카멜표기법
                3. 매개변수 : 함수 호출 시 함수 안으로 넣어주는 값 (=(들어갈)인(숫자)수)
                4. return 값;
                    - 왜? 1. 함수종료 2. 함수 종료 후 함수를 호촐했던 곳으로 반환할 값

                - 함수 안에서 선언된 지역 변수는 함수가 종료되면 사라진다.
         */

    int point;

    // 1, 매개변수가 있고 반환이 있는 함수
    int sumMethod1( int x , int y ){
        return x + y;   // int + int => int
    }
    // 2. 매개변수가 없고 반환값이 있는 함수
    int sumMethod2( ){
        // new Random().nextInt(); int 형의 표현 범위내 난수 랜덤 생성
        return new Random().nextInt();
    }
    // 3. 매개변수가 없고 반환값도 없는 함수
    void sumMethod3(){
        System.out.println("sumMethod3()");
    }
    // 4. 매개변수가 있고 반환값이 없는 함수
    void sumMethod4(int x , int y){
        // soutp + 엔터
        System.out.println("x = " + x + ", y = " + y);
    }

}   // class e
