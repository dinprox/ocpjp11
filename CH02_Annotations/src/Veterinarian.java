public class Veterinarian {

    static final int CONST = 2;
    @ZooAnimal(Habitat="Infirmary")
    private Lion sickLion;

    @ZooAnimal(Habitat="Zoo")
    private Lion healtyLion;

    public static void main(String[] args) {

    }

}

class Mammal{};
class Bird {};

class Lion extends Mammal {};
class Peacock extends Bird {};

// Parenthesis are optional for MARKER ANNOTATIONS, rest are required.
@Exercise(hoursPerDay = Veterinarian.CONST)
class Penguin {}

// VALUES ARE COMMA SEPARATED
@Exercise(hoursPerDay = 2, startHour =4)
class Sloth {}

@interface Exercise {
    // ALL ARE IMPLICITLY PUBLIC AND ABSTRACT
    // NO OTHER MODIFIERS ALLOWED

    // Attributes or elements
    int hoursPerDay();
    // Setting default value, makes this attribute optional
    int startHour () default 5;

    // Valid types are just the following
    Class myExtraClass() default  Exercise.class; // CLASS
    String getName() default ""; // String
    JavaFundamentals.Season getSeason() default JavaFundamentals.Season.SUMMER; // ENUM
    double getPrecision() default 2.0d; // PRIMITIVE TYPE
    int[] getInts() default {3,3}; // Array of above types
    ZooAnimal getDefaultExercise() default @ZooAnimal(Habitat = "Polar"); // Another annotation

    // INVALID TYPES
//    Integer getInteger();
//    String[][] doubleArray();
//    Bird getBird();

}