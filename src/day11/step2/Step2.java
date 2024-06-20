package day11.step2;

import java.util.ArrayList;
import java.util.Scanner;

public class Step2 {
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
        ArrayList<Cart> cartList = new ArrayList<>();
        ArrayList<Order> orderList = new ArrayList<>();

       /* categoryList.add(new Category(1 , "커피"));
        categoryList.add(new Category(2 , "음료"));
        categoryList.add(new Category(3 , "아이스크림"));*/

        /*productList.add(new Product(1,"아메리카노",2000 , 1));
        productList.add(new Product(2,"자몽에이드",3500 , 2));
        productList.add(new Product(3,"소프트콘",2000 , 3));*/

      /*  Order order1 =new Order(1,"2024-06-20");
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
        order3.addOrderDetail(9, 2 ,2);*/

       /* System.out.println(categoryList);
        System.out.println(productList);
        System.out.println(orderList);*/

        int cartCount = 1; // 장바구니 코드 카운트 위한 변수

        while(true){

            System.out.println(" ===== ADMIN MENU ===== ");
            System.out.println("1.Category Add");   System.out.println("2.Category List");
            System.out.println("3.Product Add");    System.out.println("4.Product List");
            System.out.println("5.Cart Add");      System.out.println("6.Cart List");
            System.out.println("7.Order Add");      System.out.println("8.Order List");
            System.out.println("9.Exit");
            System.out.print("Menu choose : ");     int ch = scan.nextInt();

            if(ch == 1){
                System.out.print("생성할 카테고리명을 입력해주세요. >> ");
                String addCategoryName = scan.next();
                Category c = new Category(addCategoryName);
                categoryList.add(c);
            } else if (ch == 2) {
                System.out.println("------------카테고리목록-----------");
                for(int i = 0; i < categoryList.size(); i++){
                    System.out.println("카테고리 코드 : " + categoryList.get(i).getCategoryCode() +
                            "   카테고리명 : " + categoryList.get(i).getCategoryName());
                }
            }else if(ch == 3){
                System.out.print("생성할 제품의 카테고리 코드를 입력해주세요. >> ");
                int addProdCateCode = scan.nextInt();
                boolean check = false;
                for(int i = 0 ; i < categoryList.size(); i++){
                    if(categoryList.get(i).getCategoryCode() == addProdCateCode){
                        System.out.print("생성할 제품의 제품명을 입력해주세요. >> ");
                        String addProductName = scan.next();
                        System.out.print("생성할 제품의 제품 가격을 입력해주세요. >> ");
                        int addProductPrice = scan.nextInt();
                        Product p = new Product(addProductName,addProductPrice,addProdCateCode);
                        productList.add(p);
                        check = true;
                        break;
                    }
                }
                if(check == false){
                    System.out.println("해당 카테고리 코드가 없습니다.");
                }

            } else if (ch == 4) {
                System.out.println("------------------제품목록-----------------");

                    for (Category c : categoryList) {
                        System.out.println(">>" + c.getCategoryName() + " 카테고리 제품목록 -");
                        for (Product p : productList){
                            if (p.getCategoryCode() == c.getCategoryCode()){
                                System.out.println("제품코드 : " + p.getProductCode() + "    제품명 : " + p.getProductName() + "    제품가격 : " + p.getProductPrice());
                            }
                        }
                    }

            } else if (ch == 5) {
                System.out.print("장바구니에 넣을 제품번호를 입력해주세요. >> ");
                int addProdCode = scan.nextInt();
                boolean check = false;
                for(int i = 0 ; i < productList.size() ; i++){
                    if(productList.get(i).getProductCode()==addProdCode){
                        System.out.print("장바구니에 넣을 제품의 수량을 입력해주세요. >> ");
                        int addProdAmount = scan.nextInt();
                        Cart c = new Cart(cartCount,addProdCode,addProdAmount);
                        cartList.add(c);
                        check = true;
                        break;
                    }
                }
                if (check == false) {
                    System.out.println("해당 제품번호는 없습니다.");
                }
            }else if (ch == 6){
                System.out.println("------------장바구니목록-----------");
                for(int i = 0; i < cartList.size(); i++){
                    System.out.println("제품 코드 : " + cartList.get(i).getProductCode() +
                            "   주문수량 : " + cartList.get(i).getAmount());
                }
            } else if (ch == 7) {
                System.out.print("주문날짜를 입력해주세요. >> ");
                String orderDate = scan.next();
                Order o = new Order(orderDate);
                for(int i = 0 ; i < cartList.size(); i++){
                    o.addOrderDetail(cartList.get(i).getProductCode() ,cartList.get(i).getAmount() );
                }
                orderList.add(o);
                cartList.clear();
            } else if (ch == 8) {
                System.out.println("------------------주문목록-----------------");

                for (Order o : orderList) {
                    System.out.println(">>" + o.getOrderCode() + " 번째 주문   주문날짜"+o.getOrderTime());
                    for (OrderDetail ot : o.orderDetailList){
                        for(int i = 0 ; i < productList.size(); i++){
                            if(productList.get(i).getProductCode()==ot.getProductCode()){
                                System.out.println("제품명 : "+productList.get(i).getProductName()+
                                        "주문수량"+ot.getOrderAmount());
                            }
                        }
                    }
                }
            } else if (ch == 9) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }else {
                System.out.println("알 수 없는 코드입니다.");
            }


        } // w end

    }
}
