import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaces implements Testeable {
    public void test() {
        List<Animal> collection = List.of(new Animal(true, false, true), new Animal(true, true, true));
        printNow(collection, x-> x.isCanBark());
    }

    public void printNow(List<Animal> collection, final Predicate<Animal> condition){
        // VAR variables CAN be final
        final var finalVarVariable = 4;

        // Adding {} to new Class() makes it anonymous and extending class
        // So when inner class is final, it refuses to compiles;
        var innerAnimal =
                new Animal(true, true, true).new InnerAnimal(); // new InnerAnimal() {};

        for (var animal : collection){
            if (condition.test(animal)){
                System.out.println("Chosen");
            }
        }
    }
}

class Animal {
    private boolean canSwim, canBark, canDive;

    public Animal(boolean canSwim, boolean canBark, boolean canDive) {
        this.canSwim = canSwim;
        this.canBark = canBark;
        this.canDive = canDive;
    }

    public Animal() {

    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public boolean isCanBark() {
        return canBark;
    }

    public boolean isCanDive() {
        return canDive;
    }

    public boolean isOdd(int number) {
        return number % 2 ==0;
    }

    public final class InnerAnimal {
        private boolean canSwim = true;

        void test(){
            System.out.println(canSwim);

            // HIDDEN VARIABLE - OUTERCLASS + THIS + VAR/METHOD
            System.out.println(Animal.this.canSwim);
        }
    }
}

@FunctionalInterface
interface Sprint {
    public void Sprint();
}

@FunctionalInterface
interface FunctionalInterfaceExtending extends  Sprint {}
interface FunctionalInterfaceExtendingAndMethods extends  Sprint {
    static void method() {}
    default void defaultMethod(){return;}
}

// NOT VALID FUNCTIONAL
//@FunctionalInterface
//interface NotFunctionInterface extends  Sprint {
//    public void Skip();
//}

//@FunctionalInterface
//interface NotValidFunctionalInterfaceObject {
//    String toString();
//}

