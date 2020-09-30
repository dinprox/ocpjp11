import java.io.Serializable;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/* @Target, @Retention, @Documented, @Inherited */

@Retention(RetentionPolicy.SOURCE)
@Documented // Include this annotation within Javadoc
@Inherited  // All subclasses will inherit this annotation
/*
RetentionPolicy.SOURCE
RetentionPolicy.CLASS // DEFAULT
RetentionPolicy.RUNTIME
 */
@interface ExampleAnnotation {}

// @Repeatable annotation requires a value of annotation that contains value() array of the type.
@Repeatable(Risks.class)
@Deprecated(since = "1.8")
@interface Risk {
    String danger();
    int level();
}

@interface Risks {
    Risk[] value();
}

class Zoo {
    static class Monkey{}

    // Using repeatable annotation
    @Risk(danger = "High", level = 3)
    @Risk(danger = "Low",  level = 5)
    @Risk(danger = "High", level = 3)
    private Monkey myMonkey;

    // Prior JAVA 8
    @Risks({
            @Risk(danger = "High", level = 3),
            @Risk(danger = "Low",  level = 5),
            @Risk(danger = "High", level = 3),
    })
    private Monkey oldMonkey;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        BuiltInAnnotations builtInAnnotations = new BuiltInAnnotations();
        builtInAnnotations.voidMethod(4);

        @SuppressWarnings("unchecked")
        List<String> list = new ArrayList();

    }


}

// USING ANNOTATIONS TO ALL JAVA DECLARATIONS
public class BuiltInAnnotations implements  @Technical Serializable {
    public static void main(String[] args) { }
//    @Technical // Invalid, because it does not return type

    /** This is a JavaDoc documentation for any pur
     * @nothing useless param
     * @return  void
     */
    @ExampleAnnotation
    @Deprecated(since = "1.8")
    public void voidMethod(int nothing){

        var myString = new @Technical(5) String("AA");

        var myInnerClass = new Animal().new @Technical InnerAnimal(); // Target.TYPE_USE

        var remaining = (@Technical int) 10; // Target.TYPE_USE

        Predicate<Integer> predicate = (@Technical  Integer xx) -> { return 2==3;};
    }

    @SafeVarargs // FINAL METHOD
    public final void thisIsSafe(List<int>... carrot){

    }

    @SafeVarargs // STATIC METHOD
    public static void thisIsSafe2(List<int>... carrot){

    }
    //.. or

    @SafeVarargs // PRIVATE METHOD
    private void thisIsSafe3(List<int>... carrot){

    }
}
