package day14.step3;

public interface StepInterface {

    // 1. 상수 : public static final
    public static final int value1 = 10;
    int value2 = 20;    // 인터페이스 안에서는 변수 생성 시 무조건 상수.

    // 2. 추상메소드 : abstract
    abstract void method1(int a);
    int method2(String a);

    // 3. 디폴트메소드 : default
    default void method3(int a){
        System.out.println("StepInterface.method3");
    }
    default int method4(String a){
        System.out.println("StepInterface.method4");
        return 3;
    }

    // 4. 정적메소드 : static
    static void method5(int a){
        System.out.println("StepInterface.method5");
    }
    static int method6(String a){
        System.out.println("StepInterface.method6");
        return 3;
    }

    // 5. private 메소드 : private
    private void method7(int a){
        System.out.println("StepInterface.method7");
    }
    private int method8(String a){
        System.out.println("StepInterface.method8");
        return 3;
    }

    // 6. private 정적 메소드 : private static
        // static영역에 저장됨
        // 프로그램이 실행될 때 할당이 되어지기 때문에  static은 static끼리만 사용을 해야 할당 시기가 맞아 불러올 수 있음.
    private static void method9(int a){
        System.out.println("StepInterface.method9");
    }
    private static int method10(String a){
        System.out.println("StepInterface.method10");
        return 3;
    }
}
