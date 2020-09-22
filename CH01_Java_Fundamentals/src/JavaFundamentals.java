import com.ocpjp11.Testeable;

import static java.lang.Math.random;

public class JavaFundamentals implements Testeable {

    final int CONSTANT = 1;
    final int CONSTANT2;
    final static int STATIC_CONSTANT;
    static final int b = 2;

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

//        Invalid compare enum with primitive types
//        if (Season.SUMMER == 2)

        // Enum value MUST MATCH EXACTLY
        Season s1 =  Season.valueOf("SUMMER");  // OK
//        Season s2 = Season.valueOf("summer"); // NOT OK, RUNTIME EXCEPTION, ILLEGAL ARGUMENT EXCEPTION

        // USING ENUMS WITH SWITCH STATEMENTS

        switch (s1) {
            case SUMMER:
                System.out.println("IT IS SUMMER");
                break;
//            case Season.SPRING: // DOES NOT COMPILE
//            case 0: // DOES NOT COMPILE
            case ALL:
                System.out.print("It is ALL ");
        }

        // Instantiating inner classes
        MyFinalNestedClass mfn = new JavaFundamentals().new MyFinalNestedClass();
        MyStaticInnerHelper dummy = new JavaFundamentals.MyStaticInnerHelper();
    }

    // CREATE AND USE FINAL CLASSES
    // Mark class as final avoid this to be extended by subclasses.

    // CONSTRUCTORS, FIELDS AND METHODS INSIDE ENUMS
    enum ZOO {
        // LIST OF VALUES MUST GO FIRST
        ELEPHANT("0") {
            @Override
            public int getSleepHour() {
                return 0;
            }
        }, HORSE("2") {
            @Override
            public int getSleepHour() {
                return 2;
            }
        }; // semicolon is MUST when adding constructor, fields or any other enum member

        public static String mRanking2 = "AA";
        private final String mRanking; // Good practice but NOT mandatory to mark properties final

        ZOO(String ranking) { // Public or protected are invalid modifiers
            this.mRanking = ranking;
        }

        public static String getRanking() {
            return mRanking2;
        }

        // All enums must implement this
        public abstract int getSleepHour();

        public static class Dummy {
        }
    }

    // WORKING WITH ENUMS
    enum Season {
        WINTER, SPRING, SUMMER, ALL
    }

    // 2- STATIC NESTED CLASS                          Nested and inner classes can extend or implement interfaces
    public static class MyStaticInnerHelper implements Testeable {
        void abstractMethod() {
        }

        @Override
        public void test() {

        }
    }

    // 1- INNER CLASS
    // VALID: abstract and all modifiers
    // They can access outer class including private members
    private final class MyFinalNestedClass {


        void nestedClasses() {
            final int instanceVariableOuter;

            instanceVariableOuter = 2;

            abstract class instanceInitializerClass {
                void doSomething (){
                    int result = instanceVariableOuter + 1;
                }
            }

            int OuterField = CONSTANT;
            // 3- ANONYMOUS CLASS
            Runnable rn = () -> {
                // parent outer member
                int constant2 = CONSTANT2;
            };

            // Interfaces

            // Calling enum methods
            String ranking = ZOO.getRanking();

            ZOO zoo = ZOO.HORSE;
            ZOO.getRanking();

            // would make variable not effectively final, so cant be used within local class

//            ranking = "aa";
            // 4- LOCAL CLASS
            // NOT ALLOWED ACCESS MODIFIERS
            // NOT ALLOWED STATIC
            class LOCAL {
                static final int AA = 4;

                void test() {
                    // effectively final
                    ranking.startsWith("aa");
                }
            }

            // LOCAL INTERFACES OR ENUMS ARE NOT ALLOWED
//            interface myInterfaceLocal {}
        }

    }


}
