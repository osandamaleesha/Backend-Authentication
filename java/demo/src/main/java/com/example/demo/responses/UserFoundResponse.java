package com.example.demo.responses;
import java.util.List;
import java.util.List;

import com.example.demo.entities.User;

public class UserFoundResponse{

    private String message;
    private List<User> users;


    public UserFoundResponse(String message, List<User> users) {
        this.message = message;
        this.users = users;
    }


    public UserFoundResponse(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }
}








