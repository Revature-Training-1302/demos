package Wednesday.FinalExample;

public class Mammal {
    private String name;
    private int legs;
    private String texture;

    public Mammal() {

    }


    public Mammal(String name, int legs, String texture) {
        this.name = name;
        this.legs = legs;
        this.texture = texture;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }


    @Override
    public String toString() {
        return "Mammal{" +
                "name='" + name + '\'' +
                ", legs=" + legs +
                ", texture='" + texture + '\'' +
                '}';
    }

    // let's see we want to make a method that should be the same for all sub-classes
    // meaning we can't override it
    public final void speak() {
        System.out.println("Speaking now...");
    }
}
