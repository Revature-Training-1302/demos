package org.example.ListExample;

import java.util.Arrays;

/**
Say some information about the class here:
 **/
public class CustomArrayList<T> implements CustomList<T> {
    // make an object array that will store our elements
    // We will have to resize it if we go past the bounds
    private Object elements[];

    // we want to keep track of our size, initially be 0 (no elements)
    private int size = 0;

    // static and final because it's universal to all Array Lists and we don't want it to change
    // here  we're specifying that all arrays will start with 10 "slots"
    private static final int DEFAULT_CAPACITY = 10;

    // constructor:
    public CustomArrayList () {
        // when we create an array list, we're really just creating an array with a default starting capacity:
        elements = new Object[DEFAULT_CAPACITY];
    }



    @Override
    public void add(T element) {
        // before we insert, we need to check if we have room for the value:
        if(size == elements.length) {
            // do some resizing:
            resize();
        }
        // normally when we add to an array
        // What is our index?
        // we can use size as our index, because it represents how many elements are already filled up, so we can use this to
        // get the index
        elements[size] = element;
        // increment size for the next time we insert (otherwise we would be inserting into the same spot every time)
        size ++;
    }

    // whenever we need more room in our array, we call this method
    private void resize() {
        int newSize = elements.length * 2;
        // take the original array and make a copy of in an array that has this new size
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public T get(int i) {
        // first check if we're going over our size
        if(i > size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        // otherwise, return the element at the specified location:
        return (T) elements[i];
    }

    @Override
    public void add(int i, T element) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String result = "[";
        for(int i = 0; i < elements.length; i ++) {
            if(elements[i] != null) {
                result += elements[i].toString() + ", ";
            }
        }
        result += "]";
        return result;
    }


}
