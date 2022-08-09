package Tuesday.Polymorphism;

public class Scope {
    public static void main(String[] args) {
        while(true) {
            int var = 4;
        }
        // can't use var outside of the scope it was created in
        // System.out.println(var);
    }
}
