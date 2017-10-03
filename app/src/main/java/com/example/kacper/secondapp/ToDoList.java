package com.example.kacper.secondapp;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoList {
    public List<ToDo> list;

    public ToDoList(){
        list = new ArrayList<ToDo>();
        list.add(new ToDo("something", new Date()));
        list.add(new ToDo("something2", new Date()));
        list.add(new ToDo("something4", new Date()));
        list.add(new ToDo("something3", new Date()));
        list.add(new ToDo("something5", new Date()));
    }

    public void addToList(ToDo item){
        list.add(item);
    }

    public void removeFromList(ToDo item){
        list.remove(item);
    }

}

