import com.ocpjp11.Testeable;

public class JavaInterfaces extends AbstractClass implements Testeable, MyInterface {

    @Override
    public void test() {
        defaultMethod();
    }

    @Override
    public void doSomething() {

    }

    JavaInterfaces(){
        // Hidden method OF PARENT INTERFACE -- SUPER
        MyInterface.super.defaultMethod();
        // Static method is not inherited
        MyInterface.staticMethod();
    }

    @Override
    public void defaultMethod() {
        System.out.println("Default method overriden");

        // HOW TO CALL HIDDEN METHOD??
        MyInterface.super.defaultMethod();
    }
}

interface MyInterface {
    // Before JAVA 8

    public static final int CONSTANT = 1;

    public abstract void doSomething();

    // JAVA 8
    public default void defaultMethod(){ // CANT BE FINAL, STATIC NOR ABSTRACT
        System.out.println("Default implementation, requires DEFAULT KEYWORD");
    }

    // CAN NOT BE FINAL AND ITS NOT INHERITED
    // AS A RESULT OF NOT BEING INHERITED, INHERITOR CAN COMPILE EVEN WHEN PARENTS HAVE SAME SIGNATURE OF STATIC METHODS
    public static void staticMethod(){
        System.out.println("static method, requires STATIC KEYWORD");
    }

    // JAVA 9
    private static void myPrivateStaticMethod(){
        System.out.println("Private static method");
    }

    // SCOPE ONLY FOR DEFAULT METHODS OF THIS INTERFACE
    private void myPrivateMethod(){
        System.out.println("Private instance method");
    }
}

abstract class AbstractClass {

    public abstract void defaultMethod();
}