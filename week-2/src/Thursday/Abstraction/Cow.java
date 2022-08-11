package Thursday.Abstraction;

public class Cow extends Animal{
    @Override
    public void speak() {
        System.out.println("Moo!");
    }

    public void speak(String message) {

    }

    @Override
    int getLegs() {
        return 4;
    }
}
