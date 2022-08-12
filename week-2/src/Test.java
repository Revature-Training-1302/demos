import Thursday.Abstraction.InterfaceExample.Fish;
import Thursday.Abstraction.InterfaceExample.WaterAnimal;

public class Test {
    public static void main(String[] args) {
        WaterAnimal shark = new Fish();
        shark.swim();
    }
}
