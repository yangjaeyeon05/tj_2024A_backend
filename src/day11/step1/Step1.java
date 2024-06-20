package day11.step1;

import java.util.ArrayList;

public class Step1 {
    /*
        1. 데이터베이스에서 설계 기반으로 자바의 클래스를 선언/구현
        2. day11 -> Step1 클래스에
            - 각 선언한 클래스를 이용하여 샘플코드 기반으로 각 객체 생성 (테이블 3개이상)
            - 동일한 타입의 객체들을 각 ArrayList 선언해서 저장하고 출력
     */
    public static void main(String[] args) {
        ArrayList<Category> categoryList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<Order> orderList = new ArrayList<>();

        categoryList.add(new Category(1 , "커피"));
        categoryList.add(new Category(2 , "음료"));
        categoryList.add(new Category(3 , "아이스크림"));

        productList.add(new Product(1,"아메리카노",2000 , 1));
        productList.add(new Product(2,"자몽에이드",3500 , 2));
        productList.add(new Product(3,"소프트콘",2000 , 3));

        Order order1 =new Order(1,"2024-06-20");
        orderList.add(order1);
        order1.addOrderDetail(1, 1 ,2);
        order1.addOrderDetail(2, 1 ,2);
        order1.addOrderDetail(3, 1 ,2);

        Order order2 =new Order(2,"2024-06-19");
        orderList.add(order2);
        order2.addOrderDetail(4, 2 ,2);
        order2.addOrderDetail(5, 2 ,2);
        order2.addOrderDetail(6, 2 ,2);

        Order order3 =new Order(3,"2024-06-18");
        orderList.add(order3);
        order3.addOrderDetail(7, 2 ,2);
        order3.addOrderDetail(8, 2 ,2);
        order3.addOrderDetail(9, 2 ,2);

        System.out.println(categoryList);
        System.out.println(productList);
        System.out.println(orderList);







    }
}
