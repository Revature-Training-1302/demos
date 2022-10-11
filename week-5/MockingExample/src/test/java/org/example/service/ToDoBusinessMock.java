package org.example.service;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

// this ensures that when we run these tests, it will check the verify statements
@RunWith(MockitoJUnitRunner.class)
public class ToDoBusinessMock {

    @Test
    public void testUsingMocks() {
        // create a mock of the ToDoService interface:
        ToDoService toDoService = mock(ToDoService.class);

        // make some lists to use in our mocking:
        // take a bunch of values and create a list out of them:
        List<String> roryTodos= Arrays.asList("Learn Junit", "Finish project", "Work on SQL", "Eat Dinner");
        List<String> lovingTodos = Arrays.asList("SQL studying", "SQL exercise", "SQL notecards", "Java");

        // Set up and declare what the dummy return values are going to be:
        when(toDoService.getTodos("Rory")).thenReturn(roryTodos);
        when(toDoService.getTodos("Loving")).thenReturn(lovingTodos);

        // take the todoService that we mocked and passed it into the toDoBusiness constructor:
        ToDoBusiness toDoBusiness = new ToDoBusiness(toDoService);

        assertEquals(1, toDoBusiness.getTodosForSQL("Rory").size());
        assertEquals(3, toDoBusiness.getTodosForSQL("Loving").size());
    }

    @Test
    public void testUsingVerify() {
        // create a mock of our service:
        ToDoService toDoService = mock(ToDoService.class);

        List<String> list1 = Arrays.asList("SQL studying", "SQL project", "cat", "Cat", "Cat");

        // specified some behavior, when we pass in rory, we will get the previously
        // defined list
        given(toDoService.getTodos("rory")).willReturn(list1);

        // create a new business object and pass in the mocked service
        ToDoBusiness toDoBusiness = new ToDoBusiness(toDoService);

        toDoBusiness.deleteTodosNotRelatedToSQL("rory");

        // verify that the delete method is called in the appropriate values
        // because "cat" doesn't contain "SQL" we want to verify that it is deleted
        verify(toDoService).deleteTodos("cat");

        // make sure that we're not deleting "SQL studying":
        // we use the never method to make sure we never call that method
        verify(toDoService, never()).deleteTodos("SQL studying");




        verify(toDoService, times(2)).deleteTodos("Cat");

        // Look into how the test would fail
    }

}
