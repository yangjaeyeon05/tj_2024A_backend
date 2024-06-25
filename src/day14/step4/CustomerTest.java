package day14.step4;

public class CustomerTest {
    public static void main(String[] args) {

        // Buy buyer;
        // buyer.buy();    // 구현을 하지 않았기 때문에 오류 추상메소드이기 때문에

        // 객체 생성
        Customer customer = new Customer();
        // Customer 타입에서 Buy 타입으로 변환 (자동 타입 변환)-> 가능 이유 : customer 가 buy 인터페이스를 구현하고 있기 때문에
        Buy buyer = customer;
        buyer.buy();
        buyer.order();
        // Customer 타입에서 Sell 타입으로 변환 (자동 타입 변환)
        Sell seller = customer;
        seller.sell();
        seller.order();

        if(seller instanceof Customer){     // seller 타입이 Customer 타입에 포함되는지
            Customer customer2 = (Customer) seller;
            customer2.buy();
            customer2.sell();
        }
        customer.order();

        // 상속은 일반 메소드, 멤버변수 , 생성자를 물려주고 인터페이스는 추상메소드를 물려준다.
        // 인터페이스를 사용하는 이유 : 상속은 하나의 클래스만 상속받을 수 있지만 구현은 여러 인터페이스를 할 수 있기 때문에 확장성이 좋다.
        // 추상메소드를 사용하는 이유 : 동일한 목적 하에 서로 다른 기능을 구현하기 위해
        // 클래스는 오버라이드를 하는 상황일 수도 있고 아닐 수도 잇다.
        // 인터페이스 무조건 오버라이드를 해야함. 기능을 구현하기 위해서
    }
}
