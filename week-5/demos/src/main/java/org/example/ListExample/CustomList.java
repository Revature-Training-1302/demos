package org.example.ListExample;

// using generics, we can keep our list type agnostic, doesn't care about the type of data that we pass in:
public interface CustomList <T>{
    // take in an element of type T and add it to the list
    public void add(T element);
    public T get(int i);
    public String toString();
    public void add(int i, T element); // add the element at the given index
    public int getSize();
}


// CustomList<String> = new CustomArrayList();
