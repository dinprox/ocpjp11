import com.ocpjp11.Testeable;

import static java.lang.Math.*;

public class JavaFundamentals implements Testeable {

    final int CONSTANT = 1;
    final int CONSTANT2;
    final static int STATIC_CONSTANT;

    static {
        STATIC_CONSTANT = 4;
    }
    public JavaFundamentals() {
        CONSTANT2 = 2;
    }

    // When method is final, it can not be overridden by subclasses
    public final void test(){

        // It must be assigned a value before it can be used WHEN LOCAL

        final int LOCAL_CONST;
        int number = (int)(random() *100);
        if (number == 3) LOCAL_CONST = 5;
        else
            LOCAL_CONST = 4;

        System.out.println("Final local constant value assigned at runtime: " + LOCAL_CONST);

        //Enums
        System.out.println("Working with enums.....");
        Season s = Season.SUMMER;
        System.out.println(s);
        // Can compare using == or equals(), is the same
        System.out.println(s == Season.SUMMER);
        System.out.println(s.equals(Season.SUMMER));

        // name() and ordinal() methods of all ENUMS
        for (Season season : Season.values()){
            System.out.println("Name of Season> " + season.name() + " ordinal number> "+ season.ordinal());
        }

        // Invalid compare enum with primitive types
//        if (Season.SUMMER == 2)

        // Enum value MUST MATCH EXACTLY
        Season s1 =  Season.valueOf("SUMMER"); // OK
//        Season s2 = Season.valueOf("summer"); // NOT OK, RUNTIME EXCEPTION, ILLEGAL ARGUMENT EXCEPTION

        // USING ENUMS WITH SWITCH STATEMENTS

        switch (s1){
            case SUMMER:
                System.out.println("IT IS SUMMER");
                break;
//            case Season.SPRING: // DOES NOT COMPILE
//            case 0: // DOES NOT COMPILE
                case ALL:
                System.out.print("It is ALL ");
        }

    }

    // CREATE AND USE FINAL CLASSES
    // Mark class as final avoid this to be extended by subclasses.
    final class MyFinalClass {

    }

    // WORKING WITH ENUMS
    enum Season{
        WINTER, SPRING, SUMMER, ALL
    }

    // CONSTRUCTORS, FIELDS AND METHODS INSIDE ENUMS
    enum ZOO {
        ZOO(){

        }
    }

}
