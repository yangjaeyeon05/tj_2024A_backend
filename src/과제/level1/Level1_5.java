package 과제.level1;

public class Level1_5 {
    public static void main(String[] args) {
        /*
        [문제] 그림과 같이 기본자료형을 이용하여 변수 5개 선언되어 있습니다. 그림과 같이 자동 형변환을 하여 출력하시오.
	    [조건]
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 자동 형변환 만 사용하여 그림과 같이 출력합니다.
	    [샘플]
		byte value1 = 100
		short value2 = 30000;
		int value3 = 2000000000;
		long value4 = 40000000000L;
		float value5 = 3.123123123F;
         */
        byte value1 = 100;
        short s1 = value1;

        short value2 = 30000;
        int i1 = value2;

        int value3 = 2000000000;
        long l1 = value3;

        long value4 = 40000000000L;
        float f1 = value4;

        float value5 = 3.123123123F;
        double d1 = value5;

        System.out.println(">> Level1_5 answer >>");
        System.out.println();
        System.out.println("byte -> short : "+s1);
        System.out.println("short -> int : "+i1);
        System.out.println("int -> long : "+l1);
        System.out.println("long -> float : "+f1);
        System.out.println("float -> double : "+d1);

    }
}
