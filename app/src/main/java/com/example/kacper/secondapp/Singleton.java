package com.example.kacper.secondapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kacper on 03.10.2017.
 */

public class Singleton {
    private static Singleton instance;
    public static List<ToDo> list;

    public static void initInstance(){
        if(instance == null){
            instance = new Singleton();

            list = new ArrayList<ToDo>();

            list.add(new ToDo("something", new Date()));
            list.add(new ToDo("something2", new Date()));
            list.add(new ToDo("something4", new Date()));
            list.add(new ToDo("something3", new Date()));
            list.add(new ToDo("something5", new Date()));
        }
    }

    public static Singleton getInstance() {
        return instance;
    }

    private Singleton() {
    }

    public static void addElementToList(ToDo element){
        list.add(element);
    }

    public static void removeElementFromList(int item){
        list.remove(item);
    }
}
