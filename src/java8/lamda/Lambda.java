package java8.lamda;

/*
 * was introduced in java 8, lambda expression was introduced to work with a functional interface.
 * instead of creating a class for a single method, Lambda helps to use that method in a better way
 * by implementing the method and using it without implement class.
 * */
public class Lambda {

    public static void main(String[] args) {
        // Lambda with no arguments
        Animal animal = () -> System.out.println("mew");
        // If have more than one statement in lambda, use {}
        Animal animal2 = () -> {
            System.out.println("mew mew");
            System.out.println("mew mew mew");
        };
        animal.speak();
        animal2.speak();

        // Lambda with a single argument
        Vehicle vehicle = location -> System.out.println("Vehicle is moving to " + location);
        vehicle.move("Paris");

        // Lambda with multiple arguments
        Man man = (food, drink) -> "man is eating " + food + " and drinking " + drink + ".";
        System.out.println(man.eat("Pizza", "Water"));
    }
}
