package java8.methodreference;

import java.util.Arrays;
import java.util.List;

/*
 * Method reference is a short way to refer to the existing method (method was implemented) of an instance or static class.
 * those are 4 types of method reference:
 * to an instance method: instance::instanceMethodName
 * to a static method: ClassName::staticMethodName
 * to a constructor: ClassName::new
 * to a method reference: ClassName::methodName
 * */
public class Main {
    public static void main(String[] args) {
//        instance method reference
        Animal animal = new Animal("");
        List<String> sound = Arrays.asList("bark", "mew", "tweet");
        // call instance method speak using method reference
        sound.forEach(animal::speak); //this code similar to sound.forEach(s -> animal.speak(s));
        // call static method unionSpeak using method reference
        sound.forEach(Animal::unionSpeak); // sound.forEach(s -> Animal.unionSpeak(s));
        // call constructor using method reference
        List<String> animals = Arrays.asList("mouse", "cat", "dog");
        animals.forEach(Animal::new); // animals.forEach(name -> new Animal(name));
        // call method eat using method reference
        animals.forEach(String::toUpperCase); // animals.forEach(name -> name.toUpperCase());

    }
}
