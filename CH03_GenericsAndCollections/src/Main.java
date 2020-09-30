import jdk.swing.interop.SwingInterOpUtils;

import javax.print.DocFlavor;
import java.awt.font.FontRenderContext;
import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.usingMethodReferences();
        main.collectionFramework();
    }

    private void usingMethodReferences() {
        // STATIC METHODS
        Consumer<List<Integer>> consumer = Collections::sort;

        // INSTANCE METHODS ON PARTICULAR INSTANCES
        Function<Integer, Boolean> function3 = new Animal()::isOdd;
        String myString = "This is the string";
        Predicate<String> predicate = myString::startsWith;

        var randomInstance = new Random();
        Supplier<Integer> supplier = randomInstance::nextInt;

        // Calling methods on a PARAMETER TO BE DETERMINED AT RUNTIME
        Function<String, Boolean> function2 = String::isEmpty;

        BiPredicate<String, String> biConsumer = String::contains;

        // METHOD REFERENCES
        Function<Integer , List<Integer>> function4 = (x) -> List.of(x);
        Function<Integer, List<Integer>> function5 = List::of;
        Function<String[], String> funcString = (x) -> String.join("l", x );

        // CONSTRUCTOR REFERENCES

        Function<List<Integer>, ArrayList<Integer>> function = ArrayList::new;
    }

    private void diamondOperator(){
        List<Integer> list = new ArrayList<>(); // short
        var list2 = new ArrayList<>(); // ArrayList of OBJECTS

    }

    private void collectionFramework(){
        // USING SET, MAP, LIST, QUEUE

        // LIST: Ordered, duplicates
        List<Integer> myArrayList = new ArrayList<>();
        // SET: NO Ordered, NO duplicates
        Set<Integer> myHashSet = new HashSet<>(2);
        // MAP: No duplicates, maps key to values

        // QUEUE: Orders its elements in specific order to be processed, FIFO, LIFO etc..

        // COLLECTION METHODS
        Collection<String> collection =  new ArrayList<>();
        Collection<String> collection2 = new HashSet<>();

        // add()
        System.out.println(collection.add("Sparrow"));
        System.out.println(collection.add("Sparrow"));
        System.out.println(collection.add("Bird"));
        System.out.println(collection.add("Crapy"));

        System.out.println(collection2.add("Sparrow"));
        System.out.println(collection2.add("Sparrow"));

        // remove()
        System.out.println(collection2.remove("Sparrow")); // Removes only one match // RETURNS BOOLEAN
//        for (String s : collection){
//             collection.remove(s);// will throw exception, CANT MODIFY THE LIST WHILE LOOPING ConcurrentModificationException
//        }

        // isEmpty(), size(), clear()
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        collection.clear();

        collection.add("Test");
        collection.add("Test1");
        collection.add("Test12");
        collection.add("Test5");
        System.out.println("Contains bird?: " + collection.contains("Bird"));

        for (String s : collection){
            System.out.println(s);
        }

        System.out.println(collection.removeIf(x-> x.contains("1")));

        for (String s : collection){
            System.out.println(s);
        }

        System.out.println("\n Inmutable collection...\n");
        collection = Collections.unmodifiableCollection(collection);
//        collection.remove("Test1"); ERROR

        // LIST
        // Factory Methods
        List<String> collection1 = Arrays.asList("a", "b", "c"); // FIXED-SIZE
        List<String> collection3 = List.of("a", "b", "c"); //  Immutable List
        List<String> L     = List.copyOf(collection1); // Copy and immutable List

        L.add("aa");
        L.get(0);
        L.replaceAll(x-> x+"_");
        L.set(0, "ZERO" );

        // SET
        // Factory Methods
        Set<Integer> set = Set.of(1,2,3); // Fixed size
        Set<Integer> set2 = Set.copyOf(set); // Immutable
        TreeSet treeSet = new TreeSet(); // ORDERED

        // QUEUE

        LinkedList<Integer> linkedList =  new LinkedList<>();
        linkedList.offer(3);
        linkedList.offer(4);
        linkedList.poll(); // Removes and retrieves OR NULL
        linkedList.peek();  // Retrieves only OR NULL
        linkedList.element(); // Retrieves or EXCEPTION
        linkedList.remove();  //Retrieve and remove OR EXCEPTION

        // MAP
        Map<String, Integer > integerMap = new HashMap();
        Map.of("A", 1, "B", 2);
        Map<String, Integer> stringIntegerMap = Map.copyOf(integerMap);

        // Better approach
        Map.ofEntries(
                Map.entry("A",1),
                Map.entry("b", 2)
        );
        TreeMap treeMap = new TreeMap();

    }
}
