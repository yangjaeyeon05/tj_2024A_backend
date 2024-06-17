package 과제.level1;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Level1_2 {
    public static void main(String[] args) {
        /*
        [문제] 그림과 같이 기본자료형을 이용하여 변수 8개 선언하고 임의값을 대입하여 출력하시오.
	    [조건]
		1. 모든 기본자료형 8개 사용
		2. printf() 메소드 사용
         */
        boolean b1 = true;
        byte by1 = 100;
        char c1 = 'A';
        short s1 = 30000;
        int i1 = 2000000000;
        long l1 = 40000000000L;
        float f1 = 3.123F;
        double d1 = 3.12312312;
        String str1 = " ";

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(">> Level1_2 answer >>");
        System.out.println(">> answer time : "+dateFormat.format(today));
        System.out.println();
        System.out.printf("type"+"%11s"+"value"+"%25s"+"range"+"\n" , str1 , str1);
        System.out.println("--------------------------------------------------");
        System.out.printf("boolean"+"%12b"+"%18s"+"true or false"+"\n" , b1 , str1);
        System.out.printf("byte"+"%15d"+"%21s"+"-128 ~ 127"+"\n" , by1 , str1);
        System.out.printf("char"+"%15c"+"%12s"+"0~65535[character1]"+"\n" , c1 , str1);
        System.out.printf("short"+"%15d"+"%16s"+"-32768 ~ 32767"+"\n" , s1 , str1);
        System.out.printf("int"+"%17d"+"%16s"+"-+2000 million"+"\n" , i1 , str1);
        System.out.printf("long"+"%16d"+"%9s"+"-+2000 million Excess"+"\n" , l1 , str1);
        System.out.printf("float"+"%15f"+"%14s"+"8 demical places"+"\n" , f1 , str1);
        System.out.printf("double"+"%14f"+"%13s"+"17 demical places" , d1 , str1);

    }
}
