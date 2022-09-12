package com.revature.entity;

// A POJO class because there's nothing really "special" about it
public class HelloWorld {

    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Java will give us a constructor because we don't have one


    // As soon as we make a constructor, Java won't provide us one
//    public HelloWorld(String message) {
//        this.message = message;
//    }

}
