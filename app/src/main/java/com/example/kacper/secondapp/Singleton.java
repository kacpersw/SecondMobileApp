package com.example.kacper.secondapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kacper on 03.10.2017.
 */

public class Singleton {
    private static Singleton instance;
    private static List<ToDo> list;

    public static void initInstance(){
        if(instance == null){
            instance = new Singleton();

            list = new ArrayList<ToDo>();

            list.add(new ToDo("Do something", new Date(), false));
            list.add(new ToDo("Do something 2", new Date(), false));
            list.add(new ToDo("Do something 3", new Date(), false));
            list.add(new ToDo("Do something 4", new Date(), false));
            list.add(new ToDo("Do something 5", new Date(), false));
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

    public static List<ToDo> getToDos(){
        return list;
    }

    public static void removeElementFromList(int item){
        list.remove(item);
    }
}
