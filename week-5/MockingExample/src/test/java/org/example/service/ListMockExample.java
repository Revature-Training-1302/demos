package org.example.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ListMockExample {
    List<String> list;

    @BeforeEach
    public void setUp() {
        // mock an instance of the List class
        list = mock(List.class);

        // when we get the size, return 1
        when(list.size()).thenReturn(1);
        // when try to return the 0th element, we return cat
        when(list.get(0)).thenReturn("cat");
        // we can specify that if we go out of bounds, we throw an index out of bounds exception:
        when(list.get(1)).thenThrow(IndexOutOfBoundsException.class);
    }

    @Test
    public void testList() {
        assertEquals(1, list.size());
        assertEquals("cat", list.get(0));
    }

    // test to make sure an exception is thrown:
    // TODO: get back to this once we learn Java 8
    @Test
    public void testIndexOutOfBounds() {
        // because list only has 1 element, this should throw an index out of bounds exception:
        // asserting that list.get(1) throws and index out of bounds exception
        // Otherwise, we get the message:
        assertThrows(
                IndexOutOfBoundsException.class,
                // lambda function, more on that when we get to Java 8 features:
                () -> list.get(1),
                "Expected index out of bounds, but it didn't happen"
        );
    }

    @Test
    public void testSpy() {
        List spyArrayList = spy(ArrayList.class);

        // initially empty, so the size is 0
        assertEquals(0, spyArrayList.size());


        // add an item to the list
        spyArrayList.add("Mockito");
        assertEquals(1, spyArrayList.size());

        // now we want to mock the return value:
        when(spyArrayList.get(0)).thenReturn("Mocked Value");
        assertEquals("Mocked Value", spyArrayList.get(0));

    }

}
