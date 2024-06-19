package day10.step1;

import java.util.Arrays;
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        // * 입력객체
        Scanner scanner = new Scanner(System.in);
        // 1. 배열구성
        int count = 0;
        Product[] productArray = new Product[count];
        // 2. 무한루프
        while (true){

            System.out.println("배열상태확인함수 : "+ Arrays.toString(productArray));

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
                // 3. 배열에 저장 , js 처럼 push 함수가 없다 , 그러므로 직접 찾아서 대입하자.
                    // 1. 제품 총 개수 증가
                    count++;
                    // 2. 새로운 배열 증가
                    Product[] newProductArray = new Product[count];  // 새로운 배열을 만드는 이유 > 기존에 대입된 객체 정보를 옮기기 위해 > 처음부터 대입을 하게 되면 기존 객체 정보들이 다 사라지기 때문에
                    // 3. 기존 배열내 값을 새로은 배열로 이동/복사/카피
                    for(int i = 0 ; i < productArray.length ; i++){
                        newProductArray[i] = productArray[i];
                    }
                    // 4. 새로운 배열 내 추가된 마지막 인덱스의 저장할 제품 객체를 등록
                    newProductArray[newProductArray.length-1] = p;
                    // 5. 새로운 배열을 기존 배열에 대입
                    productArray = newProductArray;
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
                for( int i = 0 ; i < productArray.length ; i++ ){
                    // i 번째 제품의 코드가 입력받은 코드와 같으면
                    if(productArray[i].getCode().equals(deleteCode)){
                        // 삭제할 인덱스 뒤로 한칸씩 당기기
                        for( int j = i ; j < productArray.length-1 ; j++){
                            productArray[j]=productArray[i+1];
                        }
                    }
                }
                // 3. 마지막 인덱스를 제외한 배열 카피/복사/주소 이동
                    // 1. 1개가 차감된 새로운 배열 생성
                count--;    // 제품 총 개수 1차감
                Product[] newProductArray = new Product[count];
                    // 2. 기준 배열내 마지막 인덱스를 빼고 새로운 배열에 복사
                for( int i = 0 ; i < newProductArray.length ; i++){
                    newProductArray[i] = productArray[i];
                }
                productArray = newProductArray;
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