package com.example.kacper.secondapp;

import java.util.Date;

public class ToDo {
    private String _type;
    private Date _time;

    public ToDo(String type, Date time){
        _type = type;
        _time = time;
    }

    public String toString(){
        return _type + " " + "Date: " + _time.toString();
    }
}
