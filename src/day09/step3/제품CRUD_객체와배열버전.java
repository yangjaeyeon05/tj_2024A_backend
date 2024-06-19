package day09.step3;

import java.util.Scanner;

public class 제품CRUD_객체와배열버전 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 제품 메모리 설계
        Product[] list = new Product[3];

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

                boolean saveCheck = false;

                for( int i = 0 ; i < list.length ; i++ ){
                    if(list[i].productCode == null){
                    list[i] = new Product(code , name , price);
                    saveCheck = true;
                    break;
                    }
                }
                if(saveCheck == true){
                    System.out.println("[경고] 제품등록 자리가 부족합니다.");
                }

            } else if (ch == 2) {

                System.out.println("============제품목록============");

                for( int i = 0; i < list.length ; i++){
                    if(list[i].productCode != null){
                        System.out.println(list[i].productCode+list[i].productName+list[i].productPrice);
                    }
                }

            } else if (ch == 3) {

                System.out.print("수정할 제품 코드를 입력하세요. : ");
                String code = scanner.next();

                boolean saveCheck = false;

                for( int i = 0; i < list.length; i++ ){
                    if( list[i]!=null && code == list[i].productCode ){
                        System.out.print("새로운 제품명을 입력하세요. : ");
                        String newName = scanner.next();
                        System.out.print("새로운 제품 가격을 입력하세요. : ");
                        int newPrice = scanner.nextInt();

                        list[i].productName = newName;
                        list[i].productPrice = newPrice;

                        saveCheck = true;
                        break;
                    }
                }
                if( saveCheck == false ){
                    System.out.println("[경고] 알 수 없는 제품 코드입니다.");
                }

            } else if (ch == 4) {
                System.out.print("삭제할 제품 코드를 입력하세요. : ");
                String code = scanner.next();

                boolean saveCheck = false;

                for( int i = 0; i < list.length; i++ ){
                    if( list[i]!=null && code == list[i].productCode ){
                        list[i] = null;
                        break;
                    }
                }
                if( saveCheck == false ){
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
