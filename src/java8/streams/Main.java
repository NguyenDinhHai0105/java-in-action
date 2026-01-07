package java8.streams;

import java.util.Arrays;
import java.util.List;

public class Main {
    /*
     * was introduced in java 8, Stream API is used to process collections of objects.
     * A stream is a sequence of objects that can be processed and supports various operations.
     * They can be pipelined to produce the desired result.
     *
     * Stream feature:
     * - A Stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
     * - Streams don't change the original data structure, they only provide the result as per the
     *   pipelined methods.
     * - There are two types of Stream operations: Intermediate and Terminal.
     *   Intermediate operations return the stream itself, so you can chain multiple method calls.
     *   Terminal operations return a non-stream result, such as a primitive value, a collection,
     *   or no value at all (void).
     * */

    public static void main(String[] args) {
        /*
         * how to create a stream
         * many way by the most common ways are from a collection or array or use stream.of() method
         */

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream() // create a stream from the list
                .filter(s -> s.startsWith("c"))
                .peek(System.out::println)// intermediate operation
                .map(String::toUpperCase)
                .peek(System.out::println)// intermediate operation
                .sorted() // intermediate operation
                .map(s -> s + "Hai")
                .forEach(System.out::println); // terminal operation

        //that piece of code will print:
        //c2
        //C2
        //c1
        //C1
        //C1HAI
        //C2HAI
        /*
        * let get detail how streams works
        // Streams are processed element by element (lazy evaluation).
         The source list order is: a1, a2, b1, c2, c1.

         1) filter(s -> s.startsWith("c")) pass only: c2, c1 (original order).

         For each element passing the filter, the pipeline is executed top-down:

         Element "c2":
         - peek(1) prints: c2
         - map(String::toUpperCase) transforms it to: C2
         - peek(2) prints: C2

         Element "c1":
         - peek(1) prints: c1
         - map(String::toUpperCase) transforms it to: C1
         - peek(2) prints: C1

         2) sorted() is a stateful intermediate operation.
            It waits until all elements are processed, then sorts them as: C1, C2.

         3) map(s -> s + "Hai") appends "Hai": C1Hai, C2Hai.

         4) forEach prints the final sorted results:

         Output order:
         c2
         C2
         c1
         C1
         C1Hai
         C2Hai

        * */
    }

}
