package day06.Step8;

public class Step8 {    // class s
    public static void main(String[] args) {    // main s

        // 1. 객체 생성
        계산기 c = new 계산기();
        계산기 d = new 계산기();

        // 2. 객체 내 함수 호출 , 호출 시 3 , 5
        int result1 = c.sumMethod1( 3 , 5 );
        System.out.println("result1 = " + result1);

        // 2. 객체 내 함수 호출
        int result2 = c.sumMethod2();
        System.out.println("result2 = " + result2);

        // 2. 함수 호출
        c.sumMethod3();

        // 2. 함수 호출
        c.point = 10;
        c.sumMethod4(3 , 5);

        d.point = 20;
        d.sumMethod4(6 , 7);

    }   // main e
}   // class e
