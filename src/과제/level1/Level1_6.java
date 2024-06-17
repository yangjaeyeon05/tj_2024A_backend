package 과제.level1;

public class Level1_6 {
    public static void main(String[] args) {
        /*
        [문제] 그림과 같이 기본자료형을 이용하여 변수 5개 선언되어 있습니다. 그림과 같이 강제 형변환을 하여 출력하시오.
	    [조건]
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 강제 형변환 만 사용하여 그림과 같이 출력합니다.
	    [샘플]
		short value1 = 30000;
		int value2 = 2000000000;
		long value3 = 40000000000L;
		float value4 = 3.123123123F;
		double value5 = 3.123123123;
         */
        short value1 = 30000;
        byte b1 = (byte)value1;

        int value2 = 2000000000;
        short s1 = (short)value2;

        long value3 = 40000000000L;
        int i1 = (int)value3;

        float value4 = 3.123123123F;
        long l1 = (long)value4;

        double value5 = 3.123123123;
        float f1 = (float)value5;

        System.out.println(">> Level1_6 answer >>");
        System.out.println();
        System.out.println("byte <- short : "+b1);
        System.out.println("short <- int : "+s1);
        System.out.println("int <- long : "+i1);
        System.out.println("long <- float : "+l1);
        System.out.println("float <- double : "+f1);
    }
}
