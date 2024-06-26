package day09.step3;

import java.lang.invoke.StringConcatFactory;
import java.util.Scanner;

public class 제품CRUD_변수버전 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 제품 메모리 설계
        String productCode1 = "";
        String productName1 = "";
        int productPrice1 = 0;

        String productCode2 = "";
        String productName2 = "";
        int productPrice2 = 0;

        String productCode3 = "";
        String productName3 = "";
        int productPrice3 = 0;

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

                if(productCode1.equals("")){
                    productCode1 = code;
                    productName1 = name;
                    productPrice1 = price;
                } else if (productCode2.equals("")) {
                    productCode2 = code;
                    productName2 = name;
                    productPrice2 = price;
                } else if (productCode3.equals("")) {
                    productCode3 = code;
                    productName3 = name;
                    productPrice3 = price;
                }else {
                    System.out.println("[경고] 제품등록 자리가 부족합니다.");
                }

            } else if (ch == 2) {

                System.out.println("============제품목록============");
                if(!productCode1.equals("")){
                    System.out.println(productCode1 + productName1 + productPrice1);
                }
                if(!productCode2.equals("")){
                    System.out.println(productCode2 + productName2 + productPrice2);
                }
                if(!productCode3.equals("")){
                    System.out.println(productCode3 + productName3 + productPrice3);
                }

            } else if (ch == 3) {

                System.out.print("수정할 제품 코드를 입력하세요. : ");
                String code = scanner.next();

                if(code.equals(productCode1)){
                    System.out.print("새로운 제품명을 입력하세요. : ");
                    String newName = scanner.next();
                    System.out.print("새로운 제품 가격을 입력하세요. : ");
                    int newPrice = scanner.nextInt();
                    productName1 = newName;
                    productPrice1 = newPrice;
                } else if (code.equals(productCode2)) {
                    System.out.print("새로운 제품명을 입력하세요. : ");
                    String newName = scanner.next();
                    System.out.print("새로운 제품 가격을 입력하세요. : ");
                    int newPrice = scanner.nextInt();
                    productName2 = newName;
                    productPrice2 = newPrice;
                } else if (code.equals(productCode3)) {
                    System.out.print("새로운 제품명을 입력하세요. : ");
                    String newName = scanner.next();
                    System.out.print("새로운 제품 가격을 입력하세요. : ");
                    int newPrice = scanner.nextInt();
                    productName3 = newName;
                    productPrice3 = newPrice;
                }else {
                    System.out.println("[경고] 알 수 없는 제품 코드입니다.");
                }

            } else if (ch == 4) {
                System.out.print("삭제할 제품 코드를 입력하세요. : ");
                String code = scanner.next();

                if(code.equals(productCode1)){
                    productCode1 = "";
                    productName1 = "";
                    productPrice1 = 0;
                } else if (code.equals(productCode2)) {
                    productCode2 = "";
                    productName2 = "";
                    productPrice2 = 0;
                } else if (code.equals(productCode3)) {
                    productCode3 = "";
                    productName3 = "";
                    productPrice3 = 0;
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
