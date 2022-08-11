package Thursday.Abstraction.InterfaceExample;

public interface WaterAnimal {
    public void swim();


    // default keyword lets us implement the method
    public default void something() {
        System.out.println("Hello");
    }
}
