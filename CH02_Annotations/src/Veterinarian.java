import java.util.function.Predicate;

public class Veterinarian {

    static final int CONST = 2;

    @ZooAnimal(Habitat="Infirmary")
    private Lion sickLion;

    @ZooAnimal(Habitat="Zoo")
    private Lion healthyLion;

    public static void main(String[] args) {

    }

}
class Bird {};
class Lion extends Mammal {};
class Peacock extends Bird {};

@interface MARKER_ANNOTATION {

}

// Annotations can be applied to any Java declaration
@Exercise2({3,4}) // CLASSES
class Mammal{

    @Exercise2 Integer integer = 4; // INSTANCE MEMBERS

    @Exercise2(1) // CONSTRUCTORS
    Mammal(){

    }

    @Exercise2(1)
    public void method(){

        Predicate<Integer> predicate = (@Exercise2(1) Integer var) -> { return var >1; }; // Lambda expressions
        var castingOperation = ( String) "2";

    }
};

// Parenthesis are optional for MARKER ANNOTATIONS, rest are required.
@Exercise(hoursPerDay = Veterinarian.CONST, getDefaultExercise = @ZooAnimal(Habitat="",  value = 5))
class Penguin {}

// VALUES ARE COMMA SEPARATED
@Exercise(hoursPerDay = 2, startHour =4)
class Sloth {}

@interface Exercise {
    // ALL ARE IMPLICITLY PUBLIC AND ABSTRACT
    // NO OTHER MODIFIERS ALLOWED

    // PROPERTIES STATIC PUBLIC AND FINAL -- THEY ARE NOT ELEMENTS
    int CONST = 1;

    // Attributes or elements
    int hoursPerDay();
    // Setting default value, makes this attribute optional
    int startHour () default 5;

    // Valid types are just the following
    Class myExtraClass() default  Exercise.class; // CLASS
    String getName() default ""; // String cannot be null
    JavaFundamentals.Season getSeason() default JavaFundamentals.Season.ALL;
    double getPrecision() default 2.0d; // PRIMITIVE TYPE
    int[] getInts() default {3,3}; // Array of above types
    ZooAnimal getDefaultExercise() default @ZooAnimal(Habitat = "Polar"); // Another annotation

    // INVALID TYPES
//    Integer getInteger();
//    String[][] doubleArray();
//    Bird getBird();

}

@interface Exercise2{
    int[] value() default 5;
}