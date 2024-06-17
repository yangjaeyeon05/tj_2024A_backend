package day08;

import java.util.Arrays;

public class Step3 {
    public static void main(String[] args) {

        int[] array1 = new int[3];
        array1[0] = 30;
        // array1[1] = "유재석";   // 타입이 다르므로 오류
        array1[1] = 'A'; // 자동 타입 변환
        array1[2] = (int)3.14;  // 강제 차입 변환
        // array1[3] = 'B'; // 존재하지 않는 인덱스 오류

        System.out.println(Arrays.toString(array1));

        // [2]
        Book[] library = new Book[5];
            // - library = [null] [null] [null] [null] [null]
        for( int i = 0 ; i < library.length ; i++){
            System.out.println(library[i]);
            // 객체가 null 일 때 .(도트/접근) 사용 불가능.
            // System.out.println(library[i].getBookName());
            // library[i].showBookInfo();
        }

        library[0] = new Book("책이름1","저자1");
        library[1] = new Book("책이름2","저자2");
        library[2] = new Book("책이름3","저자3");
        library[3] = new Book("책이름4","저자4");
        library[4] = new Book("책이름5","저자5");

        for( int i = 0 ; i < library.length ; i++){
            System.out.println(library[i]); // day08.Book@119d7047 객체가 저장된 주소값
            library[i].showBookInfo();
        }



    }
}
