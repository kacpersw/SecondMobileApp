package com.example.kacper.secondapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDo {
    private String _type;
    private Date _time;
    private boolean _notification;

    public ToDo(String type, Date time, boolean notification){
        _type = type;
        _time = time;
        _notification = notification;
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
