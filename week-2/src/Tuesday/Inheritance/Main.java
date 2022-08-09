package Tuesday.Inheritance;

public class Main {
    public static void main(String[] args) {
        Animal shark = new Animal(5000, 2, 0, "Heptranchias perlo", "Gurgle");
        Animal lion = new Animal(420, 2, 4, "Panthera leo", "ROAR");

        shark.speak();
        lion.speak();

        // speak with the species name included
        shark.speak_specific();
        lion.speak_specific();
    }
}
