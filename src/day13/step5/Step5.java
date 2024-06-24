package day13.step5;

class Car{
    Tire tire;                                      // Car는 일반 타이어의 클래스를 가진 타이어를 가지고 있다.
    public void run(){ this.tire.roll();}
}
class Tire{                                          // 한국 타이어와 금호 타이어라는 자식 2를 가지고 있음
    public void roll(){
        System.out.println("일반 타이어가 회전합니다.");
    }
}
class HankookTire extends Tire{
    @Override
    public void roll() {
        System.out.println("한국 타이어가 회전합니다.");
    }
}
class KumhoTire extends Tire{
    @Override
    public void roll() {
        System.out.println("금호 타이어가 회전합니다.");
    }
}

public class Step5 {
    public static void main(String[] args) {
        Car myCar = new Car();
        // myCar.run();
        Car yourCar = new Car();
        yourCar.tire = new Tire();              // 일반 타이어
        yourCar.run();                          // 일반 타이어

        myCar. tire = new Tire();
        myCar.run();                            // 일반 타이어

        myCar.tire = new HankookTire();
        myCar.run();                            // 한국 타이어   자식이 부모타입의 메소드를 재정의했기 때문에

        myCar.tire = new KumhoTire();
        myCar.run();                            // 금호 타이어   자식이 부모타입의 메소드를 재정의했기 때문에
        yourCar.run();                          // 일반타이어    yourCar 객체는 부모타입으로 자식들의 메소드를 가지고 올 수 없음 yourCar는 자식이 된 적이 없음.

        System.out.println(myCar.tire instanceof KumhoTire);
        if(myCar.tire instanceof Tire){
            myCar.tire = new HankookTire();
        }
        myCar.run();
    }
}








