package com.example.kacper.secondapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDo {
    private String _type;
    private Date _time;

    public ToDo(String type, Date time){
        _type = type;
        _time = time;
    }

    public String getType(){
        return _type;
    }

    public String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return format.format(_time);
    }

    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return _type + " \n" + "Date: " + format.format(_time);
    }
}
