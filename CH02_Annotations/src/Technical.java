import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// IMPORTANT: TYPE_USE ALLOW TO USE ANNOTATION IN OBJECT CREATION AND CASTING
@Target(ElementType.TYPE_USE)
@interface Technical {
    int value() default 5;
}