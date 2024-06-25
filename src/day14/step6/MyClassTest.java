package day14.step6;

public class MyClassTest {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.x();
        myClass.y();
        myClass.myMethod();

        X xClass = myClass;
        xClass.x();
        MyClass mClass = (MyClass)xClass;
        mClass.y();

        Y yClass = myClass;
        yClass.y();
        // yClass.x();

        MyInterface iClass = myClass;
        iClass.myMethod();  // 본인꺼
        iClass.x();         // X 부모꺼
        iClass.y();         // Y 부모꺼
    }
}
