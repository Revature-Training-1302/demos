package Thursday.Abstraction.InterfaceExample;

public class Main {
    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.run();
        frog.walk();
        frog.swim();

        Fish fish = new Fish();
        fish.swim();
    }
}
