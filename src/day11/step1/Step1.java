package day11.step1;

import java.util.ArrayList;
import java.util.Scanner;

public class Step1 {
    /*
        1. 데이터베이스에서 설계 기반으로 자바의 클래스를 선언/구현
        2. day11 -> Step1 클래스에
            - 각 선언한 클래스를 이용하여 샘플코드 기반으로 각 객체 생성 (테이블 3개이상)
            - 동일한 타입의 객체들을 각 ArrayList 선언해서 저장하고 출력
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayList<Category> categoryList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<Order> orderList = new ArrayList<>();
        ArrayList<Cart> cartList = new ArrayList<>();

//        categoryList.add(new Category("커피"));
//        categoryList.add(new Category("음료"));
//        categoryList.add(new Category("아이스크림"));
//
//        productList.add(new Product("아메리카노", 2000, 1));
//        productList.add(new Product("자몽에이드", 3500, 2));
//        productList.add(new Product("소프트콘", 2000, 3));

//        Order order1 = new Order("2024-06-20");
//        orderList.add(order1);
//        order1.addOrderDetail(1, 2);
//        order1.addOrderDetail(1, 2);
//        order1.addOrderDetail(1, 2);
//
//        Order order2 = new Order("2024-06-19");
//        orderList.add(order2);
//        order2.addOrderDetail(2, 2);
//        order2.addOrderDetail(2, 2);
//        order2.addOrderDetail(2, 2);
//
//        Order order3 = new Order("2024-06-18");
//        orderList.add(order3);
//        order3.addOrderDetail(2, 2);
//        order3.addOrderDetail(2, 2);
//        order3.addOrderDetail(2, 2);

//        System.out.println(categoryList);
//        System.out.println(productList);
//        System.out.println(orderList);
        int cartCount = 0;
        // 기능 구현
        while(true){
            System.out.println(" ===== ADMIN MENU ===== ");
            System.out.print("1.Category Add");   System.out.print("2.Category List");
            System.out.print("3.Product Add");    System.out.println("4.Product List");
            System.out.print("5.Cart Add");      System.out.print("6.Cart List");
            System.out.print("7.Order Add");      System.out.print("8.Order List");
            System.out.print("Menu choose : ");     int ch = scan.nextInt();
            if( ch == 1 ){
                System.out.print(">>카테고리명을 입력해주세요 : ");
                categoryList.add(new Category(scan.next()));

            }
            else if ( ch == 2 ){
                System.out.println("=================== 카테고리 목록 ===================");
                for (Category c : categoryList){
                    System.out.println("카테고리코드 : " + c.getCategoryCode() + "\t카테고리명 : " + c.getCategoryName());
                }
            }

            else if ( ch == 3 ){
                System.out.print(">>카테고리코드를 입력해주세요 : "); int addProdCode = scan.nextInt();
                boolean found = false;
                for (Category c : categoryList){
                    if (c.getCategoryCode() == addProdCode) {
                        System.out.print(">>제품명을 입력해주세요 : "); String addProdName = scan.next();
                        System.out.print(">>제품가격을 입력해주세요 : "); int addProdPrice = scan.nextInt();
                        Product p = new Product(addProdName, addProdPrice, addProdCode);
                        productList.add(p);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(">>존재하지 않는 카테고리 코드입니다.");
                }
            }
            else if ( ch == 4 ){
                System.out.println("=================== 제품 목록 ===================");
                for (Category c : categoryList) {
                    System.out.println(">>" + c.getCategoryName() + " 카테고리 제품목록 -");
                    for (Product p : productList){
                        if (p.getCategoryCode() == c.getCategoryCode()){
                            System.out.println("제품코드 : " + p.getProductCode() + "\t제품명 : " + p.getProductName() + "\t제품가격 : " + p.getProductPrice());
                        }
                    }
                }
            }
            else if ( ch == 5 ){
                System.out.print(">>제품번호를 입력해주세요 : "); int addCartCode = scan.nextInt();
                boolean found = false;
                for (Product p : productList){
                    if (p.getProductCode() == addCartCode) {
                        System.out.print(">>주문수량을 입력해주세요 : "); int addCartAmount = scan.nextInt();
                        Cart c = new Cart(cartCount, addCartCode, addCartAmount);
                        cartList.add(c);
                        cartCount++; found = true; break;

                    }
                }
                if (!found){
                    System.out.println(">>존재하지 않는 제품번호입니다.");
                }
            }
            else if ( ch == 6 ){
                System.out.println("=================== 카트 내역 ===================");
                for (Cart c : cartList) {
                    System.out.println("제품번호 : " + c.getProductCode() + "\t주문수량 : " + c.getAmount());
                }
            }
            else if ( ch == 7 ){
                System.out.print(">>주문날짜를 입력해주세요 (2000-01-01) : "); String orderDate = scan.next();
                Order o = new Order(orderDate);
//                for(Cart c : cartList){
//                    o.addOrderDetail(c.getProductCode(), c.getAmount());
//                }
                cartList.forEach(c -> o.addOrderDetail(c.getProductCode(), c.getAmount()));
                orderList.add(o);
                cartList.clear();
            }
            else if ( ch == 8 ){
                System.out.println("=================== 주문 정보 ===================");
                for (Order o : orderList){
                    System.out.println(o.getOrderCode() + "번째 주문 내역 -");
                    for (OrderDetail od : o.orderDetailList){
                        String prodName = "";
                        for (Product p : productList){
                            if (p.getProductCode() == od.getProductCode()){
                                prodName = p.getProductName();
                            }
                        }
                        System.out.println(">>제품명 : " + prodName + "\t주문수량 : " + od.getOrderAmount());
                    }
                }
            }
            else if (ch == 9){
                System.out.println(">>프로그램을 종료합니다.");
                break;
            }
            else {
                System.out.println(">>잘못된 입력입니다.");
            }
        } // w end
    }
}