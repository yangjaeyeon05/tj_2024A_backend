package day09.step3;

import java.util.Scanner;

public class 제품CRUD_배열버전 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 제품 메모리 설계
        String[] productCode = new String[3];
        String[] productName = new String[3];
        int[] productPrice = new int[3];

        while (true){
            System.out.println("1.등록(C) 2.출력(R) 3.수정(U) 4.삭제(D) 5.종료 선택 >>");  // 무한 출력
            int ch = scanner.nextInt(); // 무한 입력

            if(ch == 1){

                System.out.print("제품 코드를 입력해주세요 : ");
                String code = scanner.next();
                System.out.print("제품명을 입력해주세요 : ");
                String name = scanner.next();
                System.out.print("제품 가격을 입력해주세요 : ");
                int price = scanner.nextInt();

                if(productCode[0] == null){
                    productCode[0] = code;
                    productName[0] = name;
                    productPrice[0] = price;
                } else if (productCode[1] == null) {
                    productCode[1] = code;
                    productName[1] = name;
                    productPrice[1] = price;
                } else if (productCode[2] == null) {
                    productCode[2] = code;
                    productName[2] = name;
                    productPrice[2] = price;
                }else {
                    System.out.println("[경고] 제품등록 자리가 부족합니다.");
                }

            } else if (ch == 2) {

                System.out.println("============제품목록============");
                if(productCode[0] != null){
                    System.out.println(productCode[0] + productName[0] + productPrice[0]);
                }
                if(productCode[1] != null){
                    System.out.println(productCode[1] + productName[1] + productPrice[1]);
                }
                if(productCode[2] != null){
                    System.out.println(productCode[2] + productName[2] + productPrice[2]);
                }
            } else if (ch == 3) {

                System.out.print("수정할 제품 코드를 입력하세요. : ");
                String code = scanner.next();

                if(code == productCode[0]){
                    System.out.print("새로운 제품명을 입력하세요. : ");
                    String newName = scanner.next();
                    System.out.print("새로운 제품 가격을 입력하세요. : ");
                    int newPrice = scanner.nextInt();
                    productName[0] = newName;
                    productPrice[0] = newPrice;
                } else if (code == productCode[1]) {
                    System.out.print("새로운 제품명을 입력하세요. : ");
                    String newName = scanner.next();
                    System.out.print("새로운 제품 가격을 입력하세요. : ");
                    int newPrice = scanner.nextInt();
                    productName[1] = newName;
                    productPrice[1] = newPrice;
                } else if (code == productCode[2]) {
                    System.out.print("새로운 제품명을 입력하세요. : ");
                    String newName = scanner.next();
                    System.out.print("새로운 제품 가격을 입력하세요. : ");
                    int newPrice = scanner.nextInt();
                    productName[2] = newName;
                    productPrice[2] = newPrice;
                }else {
                    System.out.println("[경고] 알 수 없는 제품 코드입니다.");
                }
            } else if (ch == 4) {
                System.out.print("삭제할 제품 코드를 입력하세요. : ");
                String code = scanner.next();

                if(code == productCode[0]){
                    productCode[0] = null;
                    productName[0] = null;
                    productPrice[0] = 0;
                } else if (code == productCode[1]) {
                    productCode[1] = null;
                    productName[1] = null;
                    productPrice[1] = 0;
                } else if (code == productCode[2]) {
                    productCode[2] = null;
                    productName[2] = null;
                    productPrice[2] = 0;
                }else {
                    System.out.println("[경고] 알 수 없는 제품 코드입니다.");
                }
            } else if (ch == 5) {
                System.out.println("안내) 프로그램 종료합니다.");
                break;
            }else {
                System.out.println("알 수 없는 번호입니다.");
            }
        }   // while end

    }   // main end
}   // class end
