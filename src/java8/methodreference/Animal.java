package java8.methodreference;

public class Animal {
    void speak(String sound) {
        System.out.println(sound);
    }
    
    public static void unionSpeak(String sound1) {
        System.out.println(sound1);
    }

    public Animal(String name) {
        System.out.println("Animal name: " + name);
    }

    public void eat(String name) {
        System.out.println("Animal is eating");
    }
}
