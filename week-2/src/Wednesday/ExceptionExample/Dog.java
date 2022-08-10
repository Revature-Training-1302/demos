package Wednesday.ExceptionExample;

public class Dog {
    int legs;
    String name;

    public Dog(int legs, String name) throws DogException {
        if(legs != 4) {
            throw new DogException("Dogs should have 4 legs");
        }
        this.legs = legs;
        this.name = name;
    }
}
