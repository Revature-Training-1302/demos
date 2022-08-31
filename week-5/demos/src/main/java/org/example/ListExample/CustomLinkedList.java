package org.example.ListExample;

public class CustomLinkedList<T> implements CustomList<T> {
    // the only field we have is the head:
    Node head;

    // we have to increment/decrement our size whenever we add/remove:
    private int size = 0;

    // create a class within another class:
    // the Node class has a value and a pointer
    class Node {
        // the value is what we're storing in this node
        T value;
        // represents the next node in our list
        Node next;

        // constructor takes in a value and assigns it to the field
        Node(T value) {
            this.value = value;
        }
    }

    public CustomLinkedList() {
        // initially, our head will be null because we have no values in the list:
        this.head = null;
    }


    // add a node to the end of our list
    @Override
    public void add(T element) {
        // Two cases:
        // First case, if we have an empty list
        if(this.head == null) {
            // initialize the list with a new node, given the element that we pass in this method:
            this.head = new Node(element);
            // take our head and have it point to null/nothing
            this.head.next = null;
            size ++;
            return;
        }
        // Otherwise, we have at least one node in our list
        else {
            // iterate through our nodes until we reach next == null, because that would mean we reached the end of the list
            Node iterator = this.head;
            // Less concise way of doing it:
//            while(true) {
//                // if the next node is null, that means we've reached the end of the list
//                if(iterator.next == null) {
//                    // insert the new element at this location (guaranteed to be the end of the list)
//                    iterator.next = new Node(element);
//                    // once we've inserted the element, we can break
//                    break;
//                }
//                else {
//                    // if we haven't found the end yet, we just want to increment our iterator
//                    // take the next value and assign to the iterator so the next time around, we will start at that value
//                    iterator = iterator.next;
//                }
//            }
            // while there is a next value, we increment the iterator
            while(iterator.next != null) {
                iterator = iterator.next;
            }
            // once we break out the loop, then we know we've reached the end:
            iterator.next = new Node(element);
            size ++;
        }


    }

    @Override
    public T get(int i) {
        // given an index, return the specified value?
        Node iterator = this.head;
        // loop up to the index
        for(int j = 0; j < i; j ++) {
            // TODO: check for null values
            if(iterator == null) {
                throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + j);
            }
            iterator = iterator.next;
        }
        //
        return iterator.value;
    }

    @Override
    public void add(int i, T element) {

    }

    // we don't keep track of the size, so we iterate through the list until we reach the end
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String result = "";
        Node iterator = this.head;
        // iterate until we reach a null node
        while(iterator != null) {
            result += iterator.value + " -> ";
            iterator = iterator.next;
        }

        result += "";
        return result;
    }
}
