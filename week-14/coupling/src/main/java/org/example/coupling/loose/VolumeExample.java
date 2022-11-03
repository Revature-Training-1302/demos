package org.example.coupling.loose;

public class VolumeExample {
    public static void main(String[] args) {
        Box box = new Box(4,5,6);
        // More loosely coupled, now we don't have direct access to the volume attribute
        // we only access it through the public method (encapsulation)
        System.out.println(box.getVolume());
    }
}

class Box {
    private int length;
    private int width;
    private int height;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getVolume() {
        return length * width * height;
    }
}
