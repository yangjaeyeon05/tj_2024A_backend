package day14.step3;

public class Step3 {
    public static void main(String[] args) {

        // 인터페이스 타입의 변수 선언
        StepInterface si ;
        // 인터페이스는 스스로 객체 /인스턴스를 생성 불가능
            // 구현을 안한 메소드가 있으니까 -> 추상메소드
            // 구현을 해준 (implements) 클래스가 필요하다.
            // implements 한 클래스로 객체 생성한다. -> 구현(객)체

        new ImplementClass(); // <------ (인터페이스가 구현된 클래스의)구현체
        si = new ImplementClass();

        si.method1(3);         // ImplementClass.method1
        si.method2("JAVA");    // ImplementClass.method2

        si.method3(3);          // StepInterface.method3
        si.method4("JAVA");     // StepInterface.method4

        // si.method5(3);          // static 객체 없이 사용하는 멤버들
        // si.method6(3);          // static 객체 없이 사용하는 멤버들
        StepInterface.method5(3);
        StepInterface.method6("JAVA");

        // si.method7(3);          // private 이므로 외부 클래스로부터 사용 불가능
        // si.method8("JAVA");     // private 이므로 외부 클래스로부터 사용 불가능

        // si.method9(2);          // private 이므로 외부 클래스로부터 사용 불가능
        // si.method10("JAVA");    // private 이므로 외부 클래스로부터 사용 불가능

        System.out.println(StepInterface.value1);

    }   // main end
}   // class end
