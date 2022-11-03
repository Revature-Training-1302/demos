package org.example.coupling.tight;

public class VolumeExample {
    public static void main(String[] args) {
        Box box = new Box(3,4,5);
        // why is this tightly coupled?
        // how can we make it looser?
        System.out.println(box.volume);
        // we should have a separate method to calculate volume
    }
}

class Box {
    public int volume;
    Box(int length, int width, int height) {
        this.volume = length * width * height;
    }
}