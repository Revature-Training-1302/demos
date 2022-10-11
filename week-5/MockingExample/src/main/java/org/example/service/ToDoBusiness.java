package org.example.service;

import java.util.ArrayList;
import java.util.List;

public class ToDoBusiness {
    // First, we're going to be using our ToDoService:
    public ToDoService toDoService;

    // constructor that takes in the toDoService and initalizes it:
    public ToDoBusiness(ToDoService toDoService) {
        // taking in whatever implementation of the toDoservice, and assigning it to
        // our member variable:
        this.toDoService = toDoService;
    }

    // we're going to get all Todo items for a given user that have to
    // with sql
    public List<String> getTodosForSQL(String user) {

        // this is an empty list that will store our result
        List<String> result = new ArrayList<>();
        // this is the list that we're picking from, using the toDoService
        List<String> todosForUser = toDoService.getTodos(user);

        // iterate through the todos for our user
        // and add it to our result if it contains the string "SQL"
        for(String toDo: todosForUser) {
            if(toDo.contains("SQL")) {
                result.add(toDo);
            }
        }
        return result;
    }

    // delete all todos that don't have to do with SQL
    public void deleteTodosNotRelatedToSQL(String user) {
        List<String> toDosForUser = toDoService.getTodos(user);

        for(String toDo: toDosForUser) {
            // if string does NOT contain SQL, we delete it using the service
            if(!toDo.contains("SQL")) {
                toDoService.deleteTodos(toDo);
            }
        }
    }
}
