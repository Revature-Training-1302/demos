package org.example.service;

import java.util.List;

// Later on, we're going to define how these work by mocking them
public interface ToDoService {
    // given a user, we return the todos for that given user
    public List<String> getTodos(String user);

    // delete any todo that contains the doString
    public void deleteTodos(String doString);
}
