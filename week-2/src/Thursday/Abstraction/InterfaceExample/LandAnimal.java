package Thursday.Abstraction.InterfaceExample;

public interface LandAnimal {
    // we don't need the abstract keyword because we're in an interface
    public void walk();
    public void run();

    // Cannot have concrete methods in an interface:
    /*public void something() {

    }*/
}
