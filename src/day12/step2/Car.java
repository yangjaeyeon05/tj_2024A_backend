package day12.step2;

public class Car {
    // 1. 멤버변수
    public int speed;
    // 2. 생성자

    // 3. 메소드
    public void speedUp(){ this.speed += 1; }
    public void stop(){ this.speed = 0; }
}   // Car class end
class SportCar extends Car{ // extends : 상속 (상위 클래스를 하위클래스에 연장)
    public int power;
    // - 빠른 개발 : 기존에 있던 설계도를 물려받아서 커스텀해서 새로운 설계도/클래스 제작

}